package it.baligh.webapp.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.baligh.webapp.dao.UtentiDao;
import it.baligh.webapp.entities.Utenti;

@Service
@Transactional
public class UtentiServiceImpl implements UtentiService{
	
	
	@Autowired
    private UtentiDao UtentiDao;
	@Override
	public List<Utenti> selTuttiUtenti() {
		
		return UtentiDao.selTuttiUtenti();
	}

	

	@Override
	public void saveUtenti(Utenti entity) {
		
		UtentiDao.saveUtenti(entity);
		
	}

	@Override
	public void updateUtenti(Utenti entity) {
		
		UtentiDao.updateUtenti(entity);
		
	}

	@Override
	public void eliminaUtenti(Utenti entity) {
		
		UtentiDao.eliminaUtenti(entity);
		
	}
	@Override
	public void SalvaAdminUser(String Password) {
		UtentiDao.SalvaAdminUser(Password);
		
	}
	@Override
	public Utenti selByidClienti(long idClienti) {
		
		return UtentiDao.selByidClienti(idClienti);
	}

	@Override
	public Utenti selByUserId(String userId) {
		
		return UtentiDao.selByUserId(userId);
	}

}
