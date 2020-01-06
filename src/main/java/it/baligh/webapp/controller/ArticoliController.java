package it.baligh.webapp.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.baligh.webapp.entities.Articoli;
import it.baligh.webapp.service.ArticoliService;

@Controller
@RequestMapping("/articoli")
public class ArticoliController {
	@Autowired
	private ArticoliService articoliService;
	
	@GetMapping("/")
	public String getTuttiArticoli(Model model) {
		
		List<Articoli> listeArticoli=articoliService.selTutti();
			
		model.addAttribute("articoli", listeArticoli);
		
		return "articoli";
	}
	@GetMapping("/cerca/{codart}")
	public String getArticolo(@PathVariable("codart") String codArt ,Model model) {
		Articoli articolo=articoliService.selById(codArt);
		model.addAttribute("articoli", articolo);
		
		return "articoli";
	}
	@GetMapping("/aggiungi")
	public String getAggiungiArticolo(Model model) {
		Articoli articolo=new Articoli();
		model.addAttribute("newArticolo", articolo);
		
		return "articoli_aggiungi";
	}
	@GetMapping("/modifica/{codart}")
	public String getModificaArticolo(@PathVariable("codart") String codArt ,Model model) {
		Articoli articolo=articoliService.selById(codArt);
		if (articolo!=null) {
			model.addAttribute("newArticolo", articolo);
		}
		
		
		return "articoli_aggiungi";
	}
	
	
	@PostMapping("/modifica/{codart}")
	public String updateArticolo(@ModelAttribute("newArticolo") Articoli articolo ) {
		
		Date d=new Date();
		articolo.setDataCreaz(d);
			
	    articoliService.update(articolo);
		
		return "redirect:/articoli/";
	}
	
	@PostMapping("/aggiungi")
	public String salvaArticolo(@ModelAttribute("newArticolo") Articoli articolo ) {
		Long idd=articolo.getId();
		Date d=new Date();
		if (articoliService.selById(idd.toString().trim())!=null) {
			
			articoliService.update(articolo);
		}else {
			articolo.setDataCreaz(d);
			
			articoliService.save(articolo);
			
		}
		
		
		
		
		
		
		return "redirect:/articoli/";
	}
	@GetMapping("/elimina/{id}")
	public String eliminaArticolo(@PathVariable("id") String id ,Model model) {
		Articoli articolo=articoliService.selById(id);
		if (articolo!=null) {
			articoliService.elimina(articolo);
		}
		
		
		return "redirect:/articoli/";
	}
	
	
	

}
