package it.baligh.webapp.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.baligh.webapp.config.security.SpringSecurityUserContext;
import it.baligh.webapp.entities.Clienti;
import it.baligh.webapp.entities.Profili;
import it.baligh.webapp.entities.Utenti;
import it.baligh.webapp.service.ClientiService;
import it.baligh.webapp.service.ProfiliService;
import it.baligh.webapp.service.UtentiService;

@Controller
@RequestMapping("/clienti")
public class ClientiController {
	
	@Autowired
	private ClientiService clientiService;
	@Autowired
	private UtentiService utentiService;
	@Autowired
	private ProfiliService profiliService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private boolean IsSaved = false;
	
	@GetMapping("/")
	public String selTuttiClienti(Model model) {
		List<Clienti> clienti=clientiService.selTuttiClienti();
		
		model.addAttribute("tabclienti", clienti);
		return "clienti";
	}
	
	
	@GetMapping("/aggiungi")
	public String aggiungiClienti(Model model) {
		Clienti clienti=new Clienti();
		Utenti utenti =new Utenti();
		Profili profili =new Profili();
		model.addAttribute("cliente", clienti);
		model.addAttribute("utente", utenti);
		model.addAttribute("profili", profili);
		model.addAttribute("saved", false);
		model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 
		
		return "clienti_aggiungi";
	}
	
	@PostMapping("/aggiungi")
	public String aggiungiClientiPost(@ModelAttribute("cliente") Clienti cliente,RedirectAttributes ra) {
		Date data = new Date();
		cliente.setDataCreaz(data);
		clientiService.saveClienti(cliente);
		
		
		
		
		return "redirect:/clienti/modifica/"+cliente.getIdClienti();
	}
	
	@GetMapping("/modifica/{id}")
	public String updateClientiget(@PathVariable("id") long idCliente,Model model) {
		Clienti cl=clientiService.selByIdClienti(idCliente);
		Utenti ut=utentiService.selByidClienti(idCliente);
		model.addAttribute("cliente", cl);
		model.addAttribute("utente", ut);
		model.addAttribute("profili", new Profili());
		model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 
		
		
		model.addAttribute("saved", IsSaved?true:false);
		
		
		IsSaved=false;
		
		return "clienti_aggiungi";
	}
	
	@PostMapping("/modifica/{id}")
	public String updateClientiPost(@ModelAttribute("cliente") Clienti cliente,
			                        @ModelAttribute("utente") Utenti utente,
			                        @ModelAttribute("profili") Profili profili,
			                        @PathVariable("id") Long idCliente,
			                        Model model) {
		Set<Profili> pro=new HashSet<>();
		Date d =new Date();
		/*dati Clienti*/
		if(cliente.getNome()!=null)
		{cliente.setDataCreaz(d);
		 clientiService.updateClienti(cliente);
		}
		/*dati utenti*/
		if(utente.getUser()!=null)
		{ Utenti ut=utentiService.selByidClienti(idCliente);
			if(ut.getUser()!=null)
		   {utente.setPwd(passwordEncoder.encode(utente.getPwd())); 
			utentiService.updateUtenti(utente);
		   }else {
			   utente.setPwd(passwordEncoder.encode(utente.getPwd()));  
			  Profili p=new Profili();
			  Clienti c =new Clienti();
			  c.setIdClienti(idCliente);
			  pro.add(new Profili("USER",utente));
			  utente.setProfili(pro);
			  utente.setClienti(c);
			  utentiService.saveUtenti(utente);
		   }
		}  
		/*dati profili*/
		if(profili.getTipo()!=null)
		{
		  Utenti ut2=utentiService.selByidClienti(idCliente);
		  profili.setUtenti(ut2);
		  profiliService.updateProfili(profili);
				
		}
			
		
		IsSaved=true;
		
		return  "redirect:/clienti/modifica/" + idCliente;
	}
	
	@RequestMapping(value = { "modifica/delprofilo/{idCliente}/{id}" }, method = RequestMethod.GET)
	public String DelProfilo(@PathVariable("idCliente") long idCliente, @PathVariable("id") long id)
	{
		Profili Profilo = profiliService.selByIdProfili(id);

		profiliService.eliminaProfili(Profilo);

		return "redirect:/clienti/modifica/" + idCliente;
	}


}
