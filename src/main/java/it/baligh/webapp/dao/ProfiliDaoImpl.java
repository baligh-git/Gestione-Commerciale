package it.baligh.webapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import it.baligh.webapp.entities.Profili;
@Repository
public class ProfiliDaoImpl extends AbstractDao<Profili,Long> implements ProfiliDao{

	@Override
	public List<Profili> selTuttiProfili() {
		
		return super.selTutti();
	}

	@Override
	public Profili selByIdProfili(long id) {
		
		return super.selById(id);
	}

	@Override
	public void saveProfili(Profili entity) {
		super.save(entity);
		
	}

	@Override
	public void updateProfili(Profili entity) {
		super.update(entity);
		
	}

	@Override
	public void eliminaProfili(Profili entity) {
		String jpql="DELETE FROM Profili p WHERE p.idProfili=:id";
		super.entityManager.createQuery(jpql)
		.setParameter("id", entity.getIdProfili())
		.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profili> selProfiliUser(String userId) {
		String jpql="SELECT p FROM Profili p JOIN p.utenti u WHERE u.idUtenti=:userId";
		return super.entityManager.createQuery(jpql)
				.setParameter("userId", userId).getResultList();
	}
	
	

}
