package Model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Emprunt {
	@Id
	@GeneratedValue
	private long id;
	@OneToOne
	private Media media;
	@Column
	private Date dateEmprunt;
	
	public Emprunt(){}
	
	public Emprunt(Media media,Date date){
		this.media = media;
		this.dateEmprunt = date;
	}
	
	public Date getDateEmprunt(){
		return dateEmprunt;
	}
}
