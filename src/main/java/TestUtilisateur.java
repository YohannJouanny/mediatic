import java.util.List;

import DataAccessObject.UtilisateurDao;
import Model.Utilisateur;

public class TestUtilisateur {

	public static void main(String[] args) {

		UtilisateurDao userDAO = new UtilisateurDao();
		
		Utilisateur user1 = new Utilisateur("zino", "zino", true);
		Utilisateur user2 = new Utilisateur("rebecca", "rebacca", true);
		Utilisateur user3 = new Utilisateur("yohane", "yohane", true);
		Utilisateur user4 = new Utilisateur("eddy", "eddy", true);
		Utilisateur user5 = new Utilisateur("loulou", "loulou", false);
		
		
		userDAO.create(user1);
		userDAO.create(user2);
		userDAO.create(user3);
		userDAO.create(user4);
		userDAO.create(user5);
		
		
		user1.setPseudo("sirine");
		userDAO.update(user1);
		
		user5.setDroits(false);
		userDAO.update(user5);
		
						
		System.out.println("********************Liste des utilisateurs***************************");
  		List<Utilisateur> users = userDAO.ListUser();
 		System.out.println("nombre d'utilisateurs: "+users.size());
  		for (Utilisateur user : users) {
  			System.out.println("Pseudo: " + user.getPseudo() + "  Mot de passe: " + user.getMotDePasse() + "  Droits: "
  					+ user.getDroits());
  		} 
		
		
		
		
		
		
		
		
	}

}
