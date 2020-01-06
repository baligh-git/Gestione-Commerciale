package it.baligh.webapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.baligh.webapp.dao.ProfiliDao;
import it.baligh.webapp.entities.Profili;

@Service
@Transactional
public class ProfiliServiceImpl implements ProfiliService{
	
	
	@Autowired
    private ProfiliDao profiliDao;
	@Override
	public List<Profili> selTuttiProfili() {
		
		return profiliDao.selTuttiProfili();
	}

	@Override
	public Profili selByIdProfili(long id) {
		
		return profiliDao.selByIdProfili(id);
	}

	@Override
	public void saveProfili(Profili entity) {
		
		profiliDao.saveProfili(entity);
		
	}

	@Override
	public void updateProfili(Profili entity) {
		
		profiliDao.updateProfili(entity);
		
	}

	@Override
	public void eliminaProfili(Profili entity) {
		
		profiliDao.eliminaProfili(entity);
		
	}

	
	@Override
	public List<Profili> selProfiliUser(String userId) {
		
		return profiliDao.selProfiliUser(userId);
	}

}
