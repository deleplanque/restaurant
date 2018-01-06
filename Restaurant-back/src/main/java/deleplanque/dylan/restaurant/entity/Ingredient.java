package deleplanque.dylan.restaurant.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	public float prix;
	
	@ManyToOne
	@JsonIgnore
	private Plat plat;
	
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
	
}
