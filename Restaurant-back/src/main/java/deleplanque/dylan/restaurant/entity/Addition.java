package deleplanque.dylan.restaurant.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	
	public float getMontantTotal() {
		return montantTotal;
	}

	@OneToMany(mappedBy="addition", cascade=CascadeType.ALL)
	private List<Boisson_Addition> listBoissons;
	
	@OneToMany(mappedBy="addition", cascade=CascadeType.ALL)
	private List<Plat_Addition> listPlats;
	
	@OneToOne(mappedBy="addition")
	private Tables table;
	
	@OneToOne(mappedBy="additionProvisoire")
	private Tables tableProvisoire;
	
	@JsonIgnore
	private String paiement;
	
	public Addition() {
		this.montantTotal = 0;
	}
	
	
	public void setMontantTotal(float montantTotal) {
		this.montantTotal = montantTotal;
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

	public String getPaiement() {
		return paiement;
	}

	public void setPaiement(String paiement) {
		this.paiement = paiement;
	}


	public List<Plat_Addition> getListPlats() {
		return listPlats;
	}


	public void setListPlats(List<Plat_Addition> listPlats) {
		this.listPlats = listPlats;
	}
		

}
