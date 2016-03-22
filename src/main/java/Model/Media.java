package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Media {

	@Id
	@GeneratedValue
	private long id;
	@Column
	private String titre;
	@Column
	private String auteur;
	@Enumerated(EnumType.STRING)
	private Type type;
	@OneToOne(mappedBy="media")
	private Emprunt emprunt;

	public enum Type {
		Livre, CD, DVD;
	}

	public Media() {
	}

	public Media(String titre, String auteur, Type type) {
		this.titre = titre;
		this.auteur = auteur;
		this.type = type;
	}

	public long getId() {
		return this.id;
	}

	// SETTER et GETTER du titre
	public void setTitre(String t) {
		this.titre = t;
	}
	public String getTitre() {
		return this.titre;
	}

	// SETTER et GETTER de l'auteur
	public void setAuteur(String a) {
		this.auteur = a;
	}
	public String getAuteur() {
		return this.auteur;
	}

	// SETTER et GETTER du type
	public void setType(Type ty) {
		this.type = ty;
	}
	public Type getType() {
		return this.type;
	}

	// SETTER et GETTER de l'emprunt
	public void setEmprunt(Emprunt em) {
		this.emprunt = em;
	}
	public Emprunt getEmprunt() {
		return this.emprunt;
	}
}
