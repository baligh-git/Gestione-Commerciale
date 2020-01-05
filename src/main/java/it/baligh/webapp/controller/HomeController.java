package it.baligh.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping
	public String getHome() {
		
		return "home";
	}
	
	@GetMapping("/home")
	public String getHome2() {
		
		return "home";
	}

}
