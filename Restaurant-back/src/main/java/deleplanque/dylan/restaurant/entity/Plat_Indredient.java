package deleplanque.dylan.restaurant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Plat_Indredient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Ingredient ingredient;
	
	@ManyToOne
	@JsonIgnore
	private Plat plat;
	
	public Plat_Indredient() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ingredient getIndredient() {
		return ingredient;
	}

	public void setIndredient(Ingredient indredient) {
		this.ingredient = indredient;
	}

	public Plat getPlat() {
		return plat;
	}

	public void setPlat(Plat plat) {
		this.plat = plat;
	}
	
	
}
