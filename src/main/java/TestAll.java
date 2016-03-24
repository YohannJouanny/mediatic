import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import DataAccessObject.AdherentDAO;
import DataAccessObject.EmpruntDAO;
import DataAccessObject.MediaDAO;
import Model.Adherent;
import Model.Emprunt;
import Model.Media;

public class TestAll {

	public static void main(String[] args) {
		
		MediaDAO mediaDAO = new MediaDAO();
		EmpruntDAO empruntDAO = new EmpruntDAO();
		AdherentDAO adherentDAO = new AdherentDAO();
		
		Media media1 = new Media("La neige eternelle","Marie Sophie",Media.Type.Livre);
		Media media2 = new Media("Thunder","Black Blue",Media.Type.Livre);
		Media media3 = new Media("Mad Max","Thierry Honnes",Media.Type.DVD);
		Media media4 = new Media("La suite","Julie Beau",Media.Type.CD);
		mediaDAO.create(media1);
		mediaDAO.create(media2);
		mediaDAO.create(media3);
		mediaDAO.create(media4);
				
		
		Adherent a1 = new Adherent("Jean", "Bonneau", new Date(new GregorianCalendar(1991, 5, 12).getTimeInMillis()), "jeanbonneau@boucher.com");
		Adherent a2 = new Adherent("Jean", "Bonbeur", new Date(new GregorianCalendar(1985, 1, 17).getTimeInMillis()), "blabla@boucher.com");
		Adherent a3 = new Adherent("Paul", "Emayo", new Date(new GregorianCalendar(1978, 8, 5).getTimeInMillis()), "sand@witch.com");
		Adherent a4 = new Adherent("Paul", "Aicrudité", new Date(new GregorianCalendar(1987, 10, 21).getTimeInMillis()), "truc@bidule.com");
		Adherent a5 = new Adherent("Marie", "Aubin", new Date(new GregorianCalendar(1995, 4, 12).getTimeInMillis()), "machin@bidule.com");
		
		
		adherentDAO.create(a1);
		adherentDAO.create(a2);
		adherentDAO.create(a3);
		adherentDAO.create(a4);
		adherentDAO.create(a5);
		
		
		/*
		Emprunt emprunt1 = new Emprunt(media1,a2,new Date());
		Emprunt emprunt2 = new Emprunt(media2,a1,new Date());
		Emprunt emprunt3 = new Emprunt(media3,a2,new Date());
		
		empruntDAO.create(emprunt1);
		empruntDAO.create(emprunt2);
		empruntDAO.create(emprunt3);
		
		System.out.println("Date retour : " + emprunt1.getDateRetour());
		System.out.println("Date retour : " + emprunt2.getDateRetour());
		System.out.println("Date retour : " + emprunt3.getDateRetour());
		
		List<Adherent> list = adherentDAO.allAdherents();
		for (Adherent adherent : list) {	
				System.out.println(adherent.getNom()+" "+adherent.getPrenom());
		}
		
		Adherent add = adherentDAO.infoAdherent("Test22");
		System.out.println(add.getNom()+" "+add.getDateNaissance()+" "+add.getEmail());
		for (Emprunt em : add.getEmprunts()) {
			System.out.println(em.getMedia().getTitre() + " " + em.getDateEmprunt() + " " + em.getDateRetour());
		}*/
	}

}
