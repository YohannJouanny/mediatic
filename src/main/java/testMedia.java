import java.util.Date;
import java.util.List;

import DataAccessObject.EmpruntDAO;
import DataAccessObject.MediaDAO;
import Model.Emprunt;
import Model.Media;

public class testMedia {

	public static void main(String[] args) {
		
		MediaDAO mediaDAO = new MediaDAO();
		EmpruntDAO empruntDAO = new EmpruntDAO();
		
		Media media1 = new Media("La neige eternelle","Marie Sophie",Media.Type.Livre);
		Media media2 = new Media("Thunder","Black Blue",Media.Type.Livre);
		Media media3 = new Media("Mad Max","Thierry Honnes",Media.Type.DVD);
		Media media4 = new Media("La suite","Julie Beau",Media.Type.CD);

		mediaDAO.create(media1);
		mediaDAO.create(media2);
		mediaDAO.create(media3);
		mediaDAO.create(media4);
		
		//Emprunt emprunt = new Emprunt(media1,,new Date());
		//Emprunt emprunt2 = new Emprunt(media4,,new Date());
		//empruntDAO.create(emprunt);
		//empruntDAO.create(emprunt2);
		
		mediaDAO.update(media1);
		
		System.out.println("-------------------------");
		List<Media> listType = mediaDAO.rechercheType(Media.Type.Livre);
		for(Media m:listType){
			System.out.println(m.getId()+", "+m.getTitre()+", "+m.getAuteur()+", "+m.getType() );
		}
		
		System.out.println("-------------------------");
		List<Media> listTitre = mediaDAO.rechercheTitre("L");
		for(Media m:listTitre){
			System.out.println(m.getId()+", "+m.getTitre()+", "+m.getAuteur()+", "+m.getType() );
		}
		
		System.out.println("-------------------------");
		List<Media> listAuteur = mediaDAO.rechercheAuteur("Thierry");
		for(Media m:listAuteur){
			System.out.println(m.getId()+", "+m.getTitre()+", "+m.getAuteur()+", "+m.getType() );
		}
		

		
	}

}
