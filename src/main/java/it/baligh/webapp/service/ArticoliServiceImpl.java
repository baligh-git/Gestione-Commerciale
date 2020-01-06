package it.baligh.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.baligh.webapp.dao.ArticoliDao;
import it.baligh.webapp.entities.Articoli;
@Service
@Transactional
public class ArticoliServiceImpl implements ArticoliService {
	
	@Autowired
	private ArticoliDao	 articoliDao;
	@Override
	public List<Articoli> selTutti() {
		
		return articoliDao.selTutti() ;
	}

	@Override
	public Articoli selById(String id) {
		
		return articoliDao.selById(Long.parseLong(id));
	}

	@Override
	public void save(Articoli entity) {
		articoliDao.save(entity);

	}

	@Override
	public void update(Articoli entity) {
		articoliDao.update(entity);

	}

	@Override
	public void elimina(Articoli entity) {
		articoliDao.elimina(entity);

	}

}
