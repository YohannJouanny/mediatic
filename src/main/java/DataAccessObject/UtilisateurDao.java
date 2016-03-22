package DataAccessObject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Model.Utilisateur;


public class UtilisateurDao {

	// creation de la table utilisateur
	public Utilisateur create(Utilisateur utilisateur) {
		// interaction bd
		EntityManager entitymanager = DatabaseHelper.createEntityManager();
		// commencer une transaction
		DatabaseHelper.beginTx(entitymanager);
		entitymanager.persist(utilisateur);
		DatabaseHelper.commitTxAndClose(entitymanager);
		return utilisateur;

	}

	public Utilisateur update(Utilisateur utilisateur) {
		EntityManager entitymanager = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(entitymanager);
		entitymanager.merge(utilisateur);
		DatabaseHelper.commitTxAndClose(entitymanager);
		return utilisateur;
	}

	public void afficheUtilisateur(Utilisateur utilisateur) {
		// interaction bd
		EntityManager entitymanager = DatabaseHelper.createEntityManager();
		// commencer une transaction
		DatabaseHelper.beginTx(entitymanager);
		Utilisateur findutilisateur = entitymanager.find(Utilisateur.class, utilisateur.getId());
		System.out.println(findutilisateur.getId() + " " + findutilisateur.getPseudo() + " "
				+ findutilisateur.getMotDePasse() + " " + findutilisateur.getDroits());
		entitymanager.close();
	}

	public void remove(Long id) {
		EntityManager entitymanager = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(entitymanager);
		entitymanager.remove(entitymanager.find(Utilisateur.class, id));
		DatabaseHelper.commitTxAndClose(entitymanager);
	}

	
	public List<Utilisateur> ListUser() {
		EntityManager entitymanager = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(entitymanager);
		// all Books
		TypedQuery<Utilisateur> query = entitymanager.createQuery("from Utilisateur", Utilisateur.class);
		List<Utilisateur> ListUsers = query.getResultList();
		entitymanager.close();
		return ListUsers; 
	}
	
	
}
