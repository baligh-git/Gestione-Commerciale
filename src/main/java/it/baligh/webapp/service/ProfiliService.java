package it.baligh.webapp.service;

import java.util.List;


import it.baligh.webapp.entities.Profili;

public interface ProfiliService {
	
	List<Profili> selTuttiProfili();
	 Profili selByIdProfili(long id);
	 void saveProfili(Profili entity);
	 void updateProfili(Profili entity);
	 void eliminaProfili(Profili entity);
	 List<Profili> selProfiliUser(String userId);
}
