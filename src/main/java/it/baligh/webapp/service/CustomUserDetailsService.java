package it.baligh.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.baligh.webapp.entities.Utenti;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private UtentiService utenteService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String UserId) 
			throws UsernameNotFoundException
	{
		
		 
		 if (UserId == null ) 
		 {
	            throw new UsernameNotFoundException("Devono essere inserito la Userid del cliente");
		 }
		 
		
		 
		 Utenti utente = utenteService.selByUserId(UserId);
		 
		 if (utente == null)
		 {
			 throw new UsernameNotFoundException("Utente non Trovato!!");
		 }
		 
		 UserBuilder builder = null;
		
		 builder = User.withUsername(utente.getUser());
		 builder.password(utente.getPwd());
		 
		 String[] profili = utente.getProfili()
				 .stream()
				 .map(a -> "ROLE_" + a.getTipo())
				 .toArray(String[]::new);
		 
		 builder.authorities(profili);
		 
		 return builder.build();
	}
	 
}
