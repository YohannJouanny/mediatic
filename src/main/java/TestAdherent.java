import java.sql.Date;
import java.util.GregorianCalendar;

import DataAccessObject.AdherentDAO;
import Model.Adherent;

public class TestAdherent {
	
	private static AdherentDAO adherentDAO = new AdherentDAO();
	
	
	public static void main() {
		testAdherent();
	}
	
	
	public static void testAdherent() {
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
		
		
		a1.setIdentifiant("Test");
		a1.setAdresse("20 rue des bananes");
		a1.setCodePostal("75007");
		a1.setCodePostal("Paris");
		adherentDAO.update(a1);
		
		
		System.out.println(adherentDAO.searchAdherentsById("Te"));
		System.out.println(adherentDAO.searchAdherentsByName("ean"));
	}
}

