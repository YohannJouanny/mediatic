import java.util.ArrayList;
import java.util.List;

import DataAccessObject.UtilisateurDao;
import Model.Utilisateur;

public class Main {

	public static void main(String[] args) {

		UtilisateurDao userDAO = new UtilisateurDao();

		Utilisateur user1 = new Utilisateur("Yohanne", "azerty", true);
		Utilisateur user2 = new Utilisateur("Zino", "azerty", true);
		Utilisateur user3 = new Utilisateur("Rebecca", "azerty", true);

		userDAO.create(user1);
		userDAO.create(user2);
		userDAO.create(user3);

		user1.setDroits(false);
		userDAO.update(user1);

		System.out.println("Tous les Utilisateurs: " + userDAO.ListUser());

		
		System.out.println("********************Liste des utilisateurs***************************");
		List<Utilisateur> users = userDAO.ListUser();
		for (Utilisateur user : users) {
			System.out.println("Pseudo: " + user.getPseudo() + "  Mot de passe: " + user.getMotDePasse() + "  Droits: "
					+ user.getDroits());
		} 

		
		
	}
}
