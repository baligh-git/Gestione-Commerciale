package it.baligh.webapp.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<E extends Serializable,I extends Serializable> {
	 List<E> selTutti();
	 E selById(I id);
	 void save(E entity);
	 void update(E entity);
	 void elimina(E entity);
	
	

}
