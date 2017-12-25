package deleplanque.dylan.restaurant.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tables implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTable;
	
	private int numero;

	private int capaciteTable;
	@OneToOne
	private Addition addition;
	@Transient
	private Addition additionProvisoire;

	boolean estLibre;

	@ManyToOne
	@JsonIgnore
	private Salle salle;

	public Tables() {
	}

	public Tables(int idTable, int numero, int capaciteTable, boolean estLibre, Salle salle) {
		this.idTable = idTable;
		this.numero = numero;
		this.capaciteTable = capaciteTable;
		this.addition = new Addition();
		this.estLibre = estLibre;
		additionProvisoire = new Addition();
		this.salle = salle;
	}

	public Addition getAdditionProvisoire() {
		if (this.additionProvisoire == null) {
			this.additionProvisoire = new Addition();
		}
		return additionProvisoire;
	}

	public void setAdditionProvisoire(Addition additionProvisoire) {
		this.additionProvisoire = additionProvisoire;
	}

	public int getIdTable() {
		return idTable;
	}

	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCapaciteTable() {
		return capaciteTable;
	}

	public void setCapaciteTable(int capaciteTable) {
		this.capaciteTable = capaciteTable;
	}

	public Addition getAddition() {
		if (this.addition == null) {
			this.addition = new Addition();
		}
		return addition;
	}

	public void setAddition(Addition addition) {
		this.addition = addition;
	}

	public boolean isEstLibre() {
		return estLibre;
	}

	public void setEstLibre(boolean estLibre) {
		this.estLibre = estLibre;
	}


	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

}
