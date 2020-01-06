package it.baligh.webapp.service;

import java.util.List;


import it.baligh.webapp.entities.Utenti;

public interface UtentiService {
	
	 List<Utenti> selTuttiUtenti();
	 Utenti selByUserId(String userId);;
	 void saveUtenti(Utenti entity);
	 void updateUtenti(Utenti entity);
	 void eliminaUtenti(Utenti entity);
	 Utenti selByidClienti(long idClienti);
	 void SalvaAdminUser(String Password) ;

}
