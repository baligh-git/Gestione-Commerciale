package it.baligh.webapp.dao;

import java.util.List;

import it.baligh.webapp.entities.Clienti;

public interface ClientiDao {
	
	 List<Clienti> selTuttiClienti();
	 Clienti selByIdClienti(long id);
	 void saveClienti(Clienti entity);
	 void updateClienti(Clienti entity);
	 void eliminaClienti(Clienti entity);

	 
}
