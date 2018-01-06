package deleplanque.dylan.restaurant.entity;

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
public class Ingredient implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idIngredient;
	
	public String libelleIngredient;
	
	public double prix;
	

	@OneToMany(mappedBy="ingredient", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Plat_Indredient> listPlats;
	
	public Ingredient() {}
	
	public Ingredient(String libelleIngredient) {
		this.libelleIngredient = libelleIngredient;
	}

	public String getLibelleIngredient() {
		return libelleIngredient;
	}

	public void setLibelleIngredient(String libelleIngredient) {
		this.libelleIngredient = libelleIngredient;
	}

	public int getIdIngredient() {
		return idIngredient;
	}

	public void setIdIngredient(int idIngredient) {
		this.idIngredient = idIngredient;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public List<Plat_Indredient> getListPlats() {
		return listPlats;
	}

	public void setListPlats(List<Plat_Indredient> listPlats) {
		this.listPlats = listPlats;
	}
	
	
	
}
