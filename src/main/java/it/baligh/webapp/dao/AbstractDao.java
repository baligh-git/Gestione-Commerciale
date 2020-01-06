package it.baligh.webapp.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@SuppressWarnings("unchecked")
public abstract class AbstractDao<E extends Serializable, I extends Serializable> implements GenericDao<E, I> {
	
	@PersistenceContext
	EntityManager entityManager;
	final Class<E> entityClass;
	public AbstractDao() {
		this.entityClass=(Class<E>) ((ParameterizedType)
				this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
				
	}
	@Override
	public List<E> selTutti() {
		String sql="SELECT a FROM "+entityClass.getSimpleName()+" a";
		return this.entityManager.createQuery(sql).getResultList();
	}
	@Override
	public E selById(I id) {
		return this.entityManager.find(entityClass, id);
	}
	
	@Override
	public void save(E entity) {
		this.entityManager.persist(entity);
		FlushAndClear();
	}
	
	
	@Override
	public void update(E entity) {
	this.entityManager.merge(entity);
	FlushAndClear();
	}
	@Override
	public void elimina(E entity) {
		
		entity=this.entityManager.contains(entity) ? entity : this.entityManager.merge(entity);
		
		this.entityManager.remove(entity);
		FlushAndClear();
		
	}
    public void FlushAndClear() {
	  this.entityManager.flush();
	  this.entityManager.clear();
   }

}
