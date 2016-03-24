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
		


		Emprunt e1 = new Emprunt(media1, a1, new Date());
		Emprunt e2 = new Emprunt(media1, a2, new Date());
		Emprunt e3 = new Emprunt(media3, a3, new Date());
		Emprunt e4 = new Emprunt(media2, a4, new Date());
		
		empruntDAO.create(e1);
		empruntDAO.create(e2);
		empruntDAO.create(e3);
		empruntDAO.create(e4);
		
		
		System.out.println("-------------List des media emprunte ( Nom, titre, date_retour )------------");
		List<Media> mediaEmprunte = mediaDAO.MediaEmprunte();
		for (Media media : mediaEmprunte) {
			for (Emprunt emprunt : media.getEmprunt()) {
				System.out.println("Nom: "+emprunt.getAdherent().getNom()+" ,"+ media.getTitre()+" ,"+emprunt.getDateRetour());
			}
			
		}  
		
		
		System.out.println("-------------Visualisation Media ------------");
		Media visuMedia = mediaDAO.VisuMedia(media1);

			for (Emprunt emprunt : visuMedia.getEmprunt()) {
				System.out.println(visuMedia.getTitre()+ " ,"+visuMedia.getAuteur()+" ,"+ emprunt.getAdherent().getNom()+" ,"+ emprunt.getDateEmprunt()+" ," +emprunt.getDateRetour());
			}	
			
	}

}
