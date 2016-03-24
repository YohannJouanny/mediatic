package DataAccessObject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Model.Emprunt;
import Model.Media;


public class MediaDAO {
	public Media create(Media media) {
		EntityManager entitymanager = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(entitymanager);

		entitymanager.persist(media);

		DatabaseHelper.commitTxAndClose(entitymanager);
		return media;
	}

	public Media update(Media media) {
		EntityManager entitymanager = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(entitymanager);

		entitymanager.merge(media);

		DatabaseHelper.commitTxAndClose(entitymanager);
		return media;
	}

	public List<Media> rechercheTitre(String titre) {
		EntityManager entitymanager = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(entitymanager);

		TypedQuery<Media> query = entitymanager.createQuery(
						"SELECT m " + 
						"FROM Media m " +  
						"WHERE m.titre LIKE :titre", Media.class);
		query.setParameter("titre", titre+"%");

		List<Media> list = query.getResultList();

		DatabaseHelper.commitTxAndClose(entitymanager);
		return list;
	}
	
	public List<Media> rechercheAuteur(String auteur) {
		EntityManager entitymanager = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(entitymanager);

		TypedQuery<Media> query = entitymanager.createQuery(
						"SELECT m " + 
						"FROM Media m " +  
						"WHERE m.auteur LIKE :auteur", Media.class);
		query.setParameter("auteur", auteur+"%");

		List<Media> list = query.getResultList();

		DatabaseHelper.commitTxAndClose(entitymanager);
		return list;
	}
	
	public List<Media> rechercheType(Media.Type type){
		EntityManager entitymanager = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(entitymanager);

		TypedQuery<Media> query = entitymanager.createQuery(
						"SELECT m " + 
						"FROM Media m " +  
						"WHERE m.type=:type", Media.class);
		query.setParameter("type", type);

		List<Media> list = query.getResultList();

		DatabaseHelper.commitTxAndClose(entitymanager);
		return list;
	}
	
	
	public List<Media> MediaEmprunte(){
		EntityManager entitymanager = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(entitymanager);

		TypedQuery<Media> query = entitymanager.createQuery(
						"SELECT m " +
						"FROM Media m " +
						"inner join fetch m.emprunt e " +
						"inner join fetch e.adherent ", Media.class);
	
		List<Media> list = query.getResultList();
		 
		DatabaseHelper.commitTxAndClose(entitymanager);
		return list;
	}
	

	public Media VisuMedia(Media media){
		EntityManager entitymanager = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(entitymanager);

		TypedQuery<Media> query = entitymanager.createQuery(
						"SELECT m " +
						"FROM Media m " +
						"inner join fetch m.emprunt e " +
						"inner join fetch e.adherent " +
						"where m.auteur=:auteur " +
						"and m.titre=:titre" , Media.class);

		query.setParameter("auteur", media.getAuteur());
		query.setParameter("titre", media.getTitre());
	
		Media list = query.getSingleResult();
		 
		DatabaseHelper.commitTxAndClose(entitymanager);
		return list;
	}

	 
	
}
