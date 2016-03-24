package DataAccessObject;

import javax.persistence.EntityManager;

import Model.Emprunt;

public class EmpruntDAO {
	public Emprunt create(Emprunt emprunt) {
		EntityManager entitymanager = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(entitymanager);

		entitymanager.persist(emprunt);

		DatabaseHelper.commitTxAndClose(entitymanager);
		return emprunt;
	}

	public Emprunt update(Emprunt emprunt) {
		EntityManager entitymanager = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(entitymanager);

		entitymanager.merge(emprunt);

		DatabaseHelper.commitTxAndClose(entitymanager);
		return emprunt;
	}
}
