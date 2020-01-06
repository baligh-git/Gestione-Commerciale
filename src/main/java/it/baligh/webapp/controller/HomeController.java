package it.baligh.webapp.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.baligh.webapp.config.security.SpringSecurityUserContext;

@Controller
@RequestMapping("/")
public class HomeController {
	@PersistenceContext
	EntityManager entityManager;
	@RequestMapping
	public String getHome(Model model) {
		model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 
		
		return "home";
	}
	@RequestMapping("/home")
	public String getHome2(Model model) {
		model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 
		
		return "home";
	}

}
