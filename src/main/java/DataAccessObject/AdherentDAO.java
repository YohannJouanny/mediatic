package DataAccessObject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Model.Adherent;


public class AdherentDAO {
	
	
	public Adherent create(Adherent adherent) {
		EntityManager entityManager = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(entityManager);
		
		entityManager.persist(adherent);
		
		DatabaseHelper.commitTxAndClose(entityManager);
		return adherent;
	}
	
	
	public Adherent update(Adherent adherent) {
		EntityManager entityManager = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(entityManager);
		
		entityManager.merge(adherent);
		
		DatabaseHelper.commitTxAndClose(entityManager);
		return adherent;
	}
	
	
	public List<Adherent> searchAdherentsById(int id) {
		EntityManager entityManager = DatabaseHelper.createEntityManager();
		
		TypedQuery<Adherent> query = entityManager.createQuery("SELECT a "
															+ "FROM Adherent a "
															+ "WHERE a.id = :id ", Adherent.class);
		query.setParameter("id", id);
		List<Adherent> adherents = query.getResultList();
		
		return adherents;
	}
	
	public List<Adherent> searchAdherentsByName(String name) {
		EntityManager entityManager = DatabaseHelper.createEntityManager();
		
		TypedQuery<Adherent> query = entityManager.createQuery("SELECT a "
															+ "FROM Adherent a "
															+ "WHERE concat(a.nom, ' ', a.prenom) LIKE :name "
															+ "OR concat(a.prenom, ' ', a.nom) LIKE :name ", Adherent.class);
		query.setParameter("name", "%" + name + "%");
		List<Adherent> adherents = query.getResultList();
		
		return adherents;
	}
	
	public List<Adherent> allAdherents(){
		EntityManager entityManager = DatabaseHelper.createEntityManager();
		
		TypedQuery<Adherent> query = entityManager.createQuery("SELECT a "
															+ "FROM Adherent a ", Adherent.class);
		List<Adherent> adherents = query.getResultList();
		
		return adherents;
	}
	
	public Adherent infoAdherent(String id){
		EntityManager entityManager = DatabaseHelper.createEntityManager();
		
		TypedQuery<Adherent> query = entityManager.createQuery("SELECT a "
															+ "FROM Adherent a "
															+ "JOIN fetch a.emprunts e "
															+ "JOIN fetch e.media "
															+ "WHERE a.identifiant=:id ", Adherent.class);
		query.setParameter("id", id );
		Adherent adherents = query.getSingleResult();
		
		return adherents;
	}
	
}