package it.baligh.webapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import it.baligh.webapp.entities.Utenti;
@Repository
public class UtentiDaoImpl extends AbstractDao<Utenti, String> implements UtentiDao {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public List<Utenti> selTuttiUtenti() {
		
		return super.selTutti();
	}

	@Override
	public Utenti selByUserId(String userId) {
		
		return super.selById(userId);
	}
	@Override
	public void SalvaAdminUser(String Password) 
	{
		String EncodedPwd = passwordEncoder.encode(Password);
		
		String Sql = "EXEC Sp_InsAdminUser '" + EncodedPwd + "'";
		
		entityManager
			.createNativeQuery(Sql)
			.executeUpdate();
	}


	@Override
	public void saveUtenti(Utenti entity) {
		super.save(entity);
		
	}

	@Override
	public void updateUtenti(Utenti entity) {
		super.update(entity);
		
	}

	@Override
	public void eliminaUtenti(Utenti entity) {
		super.elimina(entity);
		
	}

	@Override
	public Utenti selByidClienti(long idClienti) {
		try {
			String jpql="SELECT u FROM Utenti u JOIN u.clienti c WHERE c.idClienti=:idClienti ";
			
			return (Utenti) super.entityManager.createQuery(jpql)
					.setParameter("idClienti", idClienti).getSingleResult();
		}catch (Exception e) {
			return new Utenti();
		}
			
		
		
	}

	
	

	

}
