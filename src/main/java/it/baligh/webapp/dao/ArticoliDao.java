package it.baligh.webapp.dao;

import java.util.List;

import it.baligh.webapp.entities.Articoli;

public interface ArticoliDao {
	
	 List<Articoli> selTutti();
	 Articoli selById(long id);
	 void save(Articoli entity);
	 void update(Articoli entity);
	 void elimina(Articoli entity);

	 
}
