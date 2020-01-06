package it.baligh.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.baligh.webapp.entities.Clienti;
import it.baligh.webapp.service.ClientiService;

@Controller
@RequestMapping("/clienti")
public class ClientiController {
	
	@Autowired
	private ClientiService clientiService;
	
	
	@GetMapping("/")
	public String selTuttiClienti(Model model) {
		List<Clienti> clienti=clientiService.selTuttiClienti();
		
		model.addAttribute("tabclienti", clienti);
		return "clienti";
	}
	
	
	
}
