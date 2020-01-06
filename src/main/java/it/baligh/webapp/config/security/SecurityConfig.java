package it.baligh.webapp.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import it.baligh.webapp.config.security.AuthenticationFilter;
import it.baligh.webapp.config.security.CustomLogoutSuccessHandler;
import it.baligh.webapp.config.security.CustomRememberMeServices;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService userDetailsService;
	
	@Autowired
	@Qualifier("persistentTokenRepository")
	private PersistentTokenRepository persistentTokenRepository;
	
	@Autowired
	private CustomLogoutSuccessHandler customLogoutSuccessHandler;
	
	
	@Autowired
    DataSource dataSource;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(final AuthenticationManagerBuilder auth) throws Exception
	{
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return authenticationProvider;
	}
	
	
	private static final String[] ADMIN_CLIENTI_MATCHER =
		{
				"/clienti/aggiungi/**",
				"/clienti/modifica/**",
				"/clienti/elimina/**"
		};
		
		private static final String[]  ADMIN_ARTICOLI_MATCHER =
		{ 
				"/articoli/aggiungi/**", 
				"/articoli/modifica/**", 
				"/articoli/elimina/**" 
		}; 
		
		
		@Override/*2.3*//*il prossimo passo e de creare la pagina login e poi se crea il controller*/
		protected void configure(final HttpSecurity http) throws Exception
		{
			http
			.authorizeRequests()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/login/**").permitAll()
			.antMatchers("/").hasAnyRole("ANONYMOUS", "USER")
			.antMatchers(ADMIN_ARTICOLI_MATCHER).access("hasRole('ADMIN')")
			.antMatchers(ADMIN_CLIENTI_MATCHER).access("hasRole('ADMIN')")
			.antMatchers("/clienti/**").hasRole("USER")
			.antMatchers("/articoli/**").hasRole("USER") 
			.and()
			.addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
				.formLogin()
					.loginPage("/login/form")
					.loginProcessingUrl("/login")
					.failureUrl("/login/form?error")
						.usernameParameter("userId")
						.passwordParameter("password")
			.and()
				.exceptionHandling()
				.accessDeniedPage("/login/form?forbidden")
			.and()
				.logout()
				.logoutUrl("/login/form?logout");
				//.logoutSuccessHandler(customLogoutSuccessHandler);
				//.invalidateHttpSession(true)
				//.logoutSuccessHandler(customLogoutSuccessHandler)
				//.clearAuthentication(true);
			//.and().csrf().disable();
					
		}
		
		public AuthenticationFilter authenticationFilter() 
				throws Exception 
		{
			
			 AuthenticationFilter filter = new AuthenticationFilter();
			 
			 filter.setAuthenticationManager(authenticationManagerBean());
			 filter.setAuthenticationFailureHandler(failureHandler());
			 filter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
			 filter.setRememberMeServices(customRememberMeServices());
			 
			 
			 return filter;
			 
		}
		
		public SimpleUrlAuthenticationFailureHandler failureHandler() 
		{ 
	        return new SimpleUrlAuthenticationFailureHandler("/login/form?error"); 
	    } 
		
		@Bean
		public SavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler() 
		{
	        SavedRequestAwareAuthenticationSuccessHandler auth = new SavedRequestAwareAuthenticationSuccessHandler();
			auth.setTargetUrlParameter("targetUrl");
			
			return auth;
		}
		
		@Bean
		public PersistentTokenBasedRememberMeServices customRememberMeServices()
		{
			String Key = "ricordamiKey";
			
			PersistentTokenBasedRememberMeServices rememberMeServices = 
	      			new CustomRememberMeServices(Key, userDetailsService, persistentTokenRepository);
			
			rememberMeServices.setCookieName("ricordami");
	      	rememberMeServices.setTokenValiditySeconds(60 * 60 * 4);
	      	rememberMeServices.setParameter("ricordami");
	      	rememberMeServices.setUseSecureCookie(false); //todo Abilitare con l'SSL
	      	
	      	return rememberMeServices;
			
			
		}
		/*
		@Bean
	    public PersistentTokenRepository persistentTokenRepository() 
		{
	        JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
	        tokenRepositoryImpl.setDataSource(dataSource);
	        
	        return tokenRepositoryImpl;
	    }
	    */
	/*
	@Bean
	@Override
	public UserDetailsService userDetailsService()
	{
		UserBuilder users = User.builder();
		
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		
		//Utente 1
		manager.createUser(
				users
				.username("karim")
				.password(new BCryptPasswordEncoder().encode("root"))
				.roles("USER")
				.build());
		
		manager.createUser(
				users
				.username("baligh")
				.password(new BCryptPasswordEncoder().encode("root"))
				.roles("USER", "ADMIN")
				.build());
		
		return manager;

	}
	*/

}
