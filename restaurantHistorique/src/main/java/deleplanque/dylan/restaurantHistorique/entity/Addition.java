package deleplanque.dylan.restaurantHistorique.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

	@OneToMany(mappedBy="addition", cascade=CascadeType.ALL)
	private List<Boisson_Addition> listBoissons;
	
	@OneToMany(mappedBy="addition", cascade=CascadeType.ALL)
	private List<Plat_Addition> listPlats;	
	
	private String paiement;
	

	
	public Addition() {
	}
	
	public Addition(float montantTotal, List<Boisson_Addition> listBoissons, List<Plat_Addition> listPlats, String paiement) {
		this.montantTotal = montantTotal;
		this.listBoissons = listBoissons;
		this.listPlats = listPlats; 
		this.paiement = paiement;
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

	public float getMontantTotal() {
		return montantTotal;
	}
	
	
		

}
