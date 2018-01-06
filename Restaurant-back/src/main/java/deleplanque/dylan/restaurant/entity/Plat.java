package deleplanque.dylan.restaurant.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

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
	
	@OneToMany(mappedBy="plat")
	private List<Plat_Indredient> listeIngredients;
	
	@Transient
	@JsonIgnore
	private ArrayList<Supplement> listeSupplements;
	private String photo;	
	
	@OneToMany(mappedBy="plat", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Plat_Addition> plats;
	
	public Plat() {}
	
	public Plat(int idPlat, String libellePlat, float prix, String categorie, String sousCategorie, ArrayList<Plat_Indredient> listeIngredients, ArrayList<Supplement> listeSupplements, String photo) {
		this.setIdPlat(idPlat);
		this.libellePlat = libellePlat;
		this.prix = prix;
		this.categorie = categorie;
		this.sousCategorie = sousCategorie;
		this.listeIngredients = listeIngredients;
		this.listeSupplements = listeSupplements;
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

	public List<Plat_Indredient> getListeIngredients() {
		return listeIngredients;
	}

	public void setListeIngredients(List<Plat_Indredient> listeIngredients) {
		this.listeIngredients = listeIngredients;
	}

	public ArrayList<Supplement> getListeSupplements() {
		return listeSupplements;
	}

	public void setListeSupplements(ArrayList<Supplement> listeSupplements) {
		this.listeSupplements = listeSupplements;
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
