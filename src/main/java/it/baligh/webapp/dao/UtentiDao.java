package it.baligh.webapp.dao;

import java.util.List;

import it.baligh.webapp.entities.Utenti;

public interface UtentiDao {
	
	 List<Utenti> selTuttiUtenti();
	 Utenti selByUserId(String userId);
	 void saveUtenti(Utenti entity);
	 void updateUtenti(Utenti entity);
	 void eliminaUtenti(Utenti entity);
	 Utenti selByidClienti(long idClienti);
	 
	 
}
