package it.baligh.webapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.baligh.webapp.dao.ClientiDao;
import it.baligh.webapp.entities.Clienti;
@Service
@Transactional
public class ClientiServiceImpl implements ClientiService{
	
	
	@Autowired
    private ClientiDao ClientiDao;
	@Override
	public List<Clienti> selTuttiClienti() {
		
		return ClientiDao.selTuttiClienti();
	}

	@Override
	public Clienti selByIdClienti(long id) {
		
		return ClientiDao.selByIdClienti(id);
	}

	@Override
	public void saveClienti(Clienti entity) {
		
		ClientiDao.saveClienti(entity);
		
	}

	@Override
	public void updateClienti(Clienti entity) {
		
		ClientiDao.updateClienti(entity);
		
	}

	@Override
	public void eliminaClienti(Clienti entity) {
		
		ClientiDao.eliminaClienti(entity);
		
	}

}
