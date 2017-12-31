package deleplanque.dylan.restaurantHistorique.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Plat implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPlat;
	private String libellePlat;
	private float prix;
	private String categorie;
	private String sousCategorie;
	private String photo;	
	@OneToMany(mappedBy="plat", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Plat_Addition> plats;
	
	public Plat() {}
	
	public Plat(int idPlat, String libellePlat, float prix, String categorie, String sousCategorie, String photo) {
		this.setIdPlat(idPlat);
		this.libellePlat = libellePlat;
		this.prix = prix;
		this.categorie = categorie;
		this.sousCategorie = sousCategorie;
		this.photo = photo;
	}

	public String getLibellePlat() {
		return libellePlat;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setLibellePlat(String libellePlat) {
		this.libellePlat = libellePlat;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getSousCategorie() {
		return sousCategorie;
	}

	public void setSousCategorie(String sousCategorie) {
		this.sousCategorie = sousCategorie;
	}

	public int getIdPlat() {
		return idPlat;
	}

	public void setIdPlat(int idPlat) {
		this.idPlat = idPlat;
	}

	public List<Plat_Addition> getPlats() {
		return plats;
	}

	public void setPlats(List<Plat_Addition> plats) {
		this.plats = plats;
	}
	
	
	
}
