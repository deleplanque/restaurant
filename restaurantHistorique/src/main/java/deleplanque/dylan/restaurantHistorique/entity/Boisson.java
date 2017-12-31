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
public class Boisson implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idBoisson;
	private String libelleBoisson;
	private String categorie;
	private String sousCategorie;
	private float prix;
	private String logo;
	
	@OneToMany(mappedBy="boisson", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Boisson_Addition> boissons;

	public Boisson() {
	}

	public Boisson(int idBoisson, String libelleBoisson, String categorie, String sousCategorie, float prix,
			String logo) {
		this.idBoisson = idBoisson;
		this.libelleBoisson = libelleBoisson;
		this.categorie = categorie;
		this.setSousCategorie(sousCategorie);
		this.prix = prix;
		this.logo = logo;
	}

	public int getIdBoisson() {
		return idBoisson;
	}

	public void setIdBoisson(int idBoisson) {
		this.idBoisson = idBoisson;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getLibelleBoisson() {
		return libelleBoisson;
	}

	public void setLibelleBoisson(String libelleBoisson) {
		this.libelleBoisson = libelleBoisson;
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

}
