package it.baligh.webapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import it.baligh.webapp.entities.Clienti;
@Repository
public class ClientiDaoImpl extends AbstractDao<Clienti, Long> implements ClientiDao {

	@Override
	public List<Clienti> selTuttiClienti() {
		
		return super.selTutti();
	}

	@Override
	public Clienti selByIdClienti(long id) {
		
		return super.selById(id);
	}

	@Override
	public void saveClienti(Clienti entity) {

		super.save(entity);
		
	}

	@Override
	public void updateClienti(Clienti entity) {

		super.update(entity);
		
	}

	@Override
	public void eliminaClienti(Clienti entity) {
		
		super.elimina(entity);
		
	}
	
	
	

}
