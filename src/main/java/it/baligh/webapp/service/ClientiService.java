package it.baligh.webapp.service;

import java.util.List;


import it.baligh.webapp.entities.Clienti;

public interface ClientiService {
	
	List<Clienti> selTuttiClienti();
	 Clienti selByIdClienti(long id);
	 void saveClienti(Clienti entity);
	 void updateClienti(Clienti entity);
	 void eliminaClienti(Clienti entity);
}
