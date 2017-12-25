package deleplanque.dylan.restaurant.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	@Transient
	@JsonIgnore
	private ArrayList<Ingredient> listeIngredients;
	@Transient
	@JsonIgnore
	private ArrayList<Supplement> listeSupplements;
	private String photo;	
	@ManyToMany
	@JsonIgnore
	private List<Addition> additions;
	
	public Plat() {}
	
	public Plat(int idPlat, String libellePlat, float prix, String categorie, String sousCategorie, ArrayList<Ingredient> listeIngredients, ArrayList<Supplement> listeSupplements, String photo) {
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

	public ArrayList<Ingredient> getListeIngredients() {
		return listeIngredients;
	}

	public void setListeIngredients(ArrayList<Ingredient> listeIngredients) {
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
	
	
}
