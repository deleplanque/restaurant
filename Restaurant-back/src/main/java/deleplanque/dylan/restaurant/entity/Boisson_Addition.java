package deleplanque.dylan.restaurant.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Boisson_Addition implements Serializable{

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
	private Boisson boisson;

	public Boisson_Addition() {
	}

	public Boisson_Addition(Addition addition, Boisson boisson) {
		this.addition = addition;
		this.boisson = boisson;
	}


	public Addition getAddition() {
		return addition;
	}


	public void setAddition(Addition addition) {
		this.addition = addition;
	}


	public Boisson getBoisson() {
		return boisson;
	}


	public void setBoisson(Boisson boisson) {
		this.boisson = boisson;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	

}
