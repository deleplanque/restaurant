package deleplanque.dylan.restaurantHistorique.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Plat_Addition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JsonIgnore
	private Addition addition;
	
	@ManyToOne
	private Plat plat;

	public Plat_Addition() {
	}
	
	public Plat_Addition(Addition addition, Plat plat) {
		this.addition = addition;
		this.plat = plat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Addition getAddition() {
		return addition;
	}

	public void setAddition(Addition addition) {
		this.addition = addition;
	}

	public Plat getPlat() {
		return plat;
	}

	public void setPlat(Plat plat) {
		this.plat = plat;
	}
}
