package deleplanque.dylan.restaurant.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numero;
	private String nomRestaurant;
	private ArrayList<Salle> listeDesSalles;
	private int capaciteRestaurant;
	
	public Restaurant() {}
	
	public Restaurant(int numero, String nomRestaurant, ArrayList<Salle> listeDesSalles, int capaciterRestaurant) {
		this.setNumero(numero);
		this.nomRestaurant = nomRestaurant;
		this.listeDesSalles = listeDesSalles;
		this.capaciteRestaurant = capaciterRestaurant;
	}
	

	public int getCapaciteRestaurant() {
		return capaciteRestaurant;
	}

	public void setCapaciteRestaurant(int capaciteRestaurant) {
		this.capaciteRestaurant = capaciteRestaurant;
	}

	public String getNomRestaurant() {
		return nomRestaurant;
	}

	public void setNomRestaurant(String nomRestaurant) {
		this.nomRestaurant = nomRestaurant;
	}

	public ArrayList<Salle> getListeDesSalles() {
		return listeDesSalles;
	}

	public void setListeDesSalles(ArrayList<Salle> listeDesSalles) {
		this.listeDesSalles = listeDesSalles;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
