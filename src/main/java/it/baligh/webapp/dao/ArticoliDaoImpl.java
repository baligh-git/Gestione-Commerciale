package it.baligh.webapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import it.baligh.webapp.entities.Articoli;
@Repository
public class ArticoliDaoImpl extends AbstractDao<Articoli, Long> implements ArticoliDao {

	@Override
	public List<Articoli> selTutti() {
		
		return super.selTutti();
	}

	@Override
	public Articoli selById(long id) {
		
		
		return super.selById(id);
	}

	@Override
	public void save(Articoli entity) {
		super.save(entity);

	}

	@Override
	public void update(Articoli entity) {
		super.update(entity);

	}

	@Override
	public void elimina(Articoli entity) {
		super.elimina(entity);

	}



}
