package deleplanque.dylan.restaurant.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Salle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSalle;
	private String nomSalle;
	
	@OneToMany(mappedBy="salle")
	@JsonIgnore
	private List<Tables> listeTables;
	private int capaciteSalle;
	
	

	public Salle() {
	}

	public Salle(int idSalle, String nomSalle, List<Tables> listeTables, int capaciteSalle) {
		this.idSalle = idSalle;
		this.nomSalle = nomSalle;
		this.listeTables = listeTables;
		this.capaciteSalle = capaciteSalle;
	}

	public int getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	public String getNomSalle() {
		return nomSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}

	public List<Tables> getListeTables() {
		return listeTables;
	}

	public void setListeTables(List<Tables> listeTables) {
		this.listeTables = listeTables;
	}

	public int getCapaciteSalle() {
		return capaciteSalle;
	}

	public void setCapaciteSalle(int capaciteSalle) {
		this.capaciteSalle = capaciteSalle;
	}

}
