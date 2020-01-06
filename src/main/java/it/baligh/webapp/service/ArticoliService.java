package it.baligh.webapp.service;

import java.util.List;

import it.baligh.webapp.entities.Articoli;

public interface ArticoliService {
	
	 List<Articoli> selTutti();
	 Articoli selById(String id);
	 void save(Articoli entity);
	 void update(Articoli entity);
	 void elimina(Articoli entity);

}
