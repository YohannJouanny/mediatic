package Model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Emprunt {
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	@JoinColumn(unique=true)
	private Media media;
	@ManyToOne
	private Adherent adherent;
	@Column
	private Date dateEmprunt;
	
	public Emprunt(){}
	
	public Emprunt(Media media,Adherent adherent,Date date){
		this.media = media;
		this.adherent = adherent;
		this.dateEmprunt = date;
	}
	
	public Date getDateEmprunt(){
		return dateEmprunt;
	}
}
