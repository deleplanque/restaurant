package deleplanque.dylan.restaurant.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Addition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAddition;
	private float montantTotal;
	
	@Transient
	private List<Boisson> boissons;
	
	@OneToMany(mappedBy="addition", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Boisson_Addition> listBoissons;
	
	@ManyToMany(mappedBy="additions")
	private List<Plat> plats;
	
	@OneToOne(mappedBy="addition")
	private Tables table;
	
	
	public Addition() {
		this.montantTotal = 0;
	}

	public float getMontantTotal() {
		for(int i=0; i< getBoissons().size();i++) {
			montantTotal = montantTotal + getBoissons().get(i).getPrix();
		}
		return montantTotal;
	}



	public void setMontantTotal(float montantTotal) {
		this.montantTotal = montantTotal;
	}


	public List<Plat> getPlats() {
		return plats;
	}

	public void setPlats(List<Plat> plats) {
		this.plats = plats;
	}

	public List<Boisson> getBoissons() {
		if (this.boissons == null) {
			this.boissons = new ArrayList<Boisson>();
		}
		return boissons;
	}

	public void setBoissons(List<Boisson> boissons) {
		this.boissons = boissons;
	}

	public List<Boisson_Addition> getListBoissons() {
		return listBoissons;
	}

	public void setListBoissons(List<Boisson_Addition> listBoissons) {
		this.listBoissons = listBoissons;
	}

	public int getIdAddition() {
		return idAddition;
	}

	public void setIdAddition(int idAddition) {
		this.idAddition = idAddition;
	}
	
	

}
