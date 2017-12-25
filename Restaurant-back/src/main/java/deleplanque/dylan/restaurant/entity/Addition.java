package deleplanque.dylan.restaurant.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

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
	private HashMap<Boisson, Integer> listeBoisson;
	
	@Transient
	private HashMap<Plat, Integer> listePlat;
	
	@ManyToMany(mappedBy="additions", cascade=CascadeType.ALL)
	private List<Boisson> boissons;
	
	@ManyToMany(mappedBy="additions")
	private List<Plat> plats;
	
	@OneToOne(mappedBy="addition")
	private Tables table;
	
	public Addition() {
		this.montantTotal = 0;
		this.listeBoisson = new HashMap<Boisson, Integer>();
		this.listePlat = new HashMap<Plat, Integer>();
	}

	public float getMontantTotal() {
		montantTotal = 0;

		if (!listeBoisson.isEmpty()) {
			for (Boisson mapKey : listeBoisson.keySet()) {
				montantTotal += mapKey.getPrix() * listeBoisson.get(mapKey);
			}
		}

		if (!listePlat.isEmpty()) {
			for (Plat mapKey : listePlat.keySet()) {
				montantTotal += mapKey.getPrix() * listePlat.get(mapKey);
			}
		}
		return montantTotal;
	}

	public HashMap<Boisson, Integer> getListeBoisson() {
		if (listeBoisson == null) {
			this.listeBoisson = new HashMap<Boisson, Integer>();
		}
		return listeBoisson;
	}

	public void setListeBoisson(HashMap<Boisson, Integer> listeBoisson) {
		this.listeBoisson = listeBoisson;
	}

	public HashMap<Plat, Integer> getListePlat() {
		if (listePlat == null) {
			this.listePlat = new HashMap<Plat, Integer>();
		}
		return listePlat;
	}

	public void setListePlat(HashMap<Plat, Integer> listePlat) {
		this.listePlat = listePlat;
	}

	public void setMontantTotal(float montantTotal) {
		this.montantTotal = montantTotal;
	}

	public void addBoisson(Boisson boisson) {
		if (boissonContientCle(boisson.getLibelleBoisson())) {
			Boisson b = getCleBoisson(boisson.getLibelleBoisson());
			int quantite = listeBoisson.get(b);
			listeBoisson.put(b, ++quantite);
		} else {
			listeBoisson.put(boisson, 1);
		}
	}
	
	public void removeBoisson(Boisson boisson) {
		int quantite=0;
			Boisson b = getCleBoisson(boisson.getLibelleBoisson());
			quantite = listeBoisson.get(b);
			if(quantite>1) {
				listeBoisson.put(b, --quantite);
			}
			else {
				listeBoisson.remove(b);
			}
	}
	
	public void addPlat(Plat plat) {
		if (platContientCle(plat.getLibellePlat())) {
			Plat p = getClePlat(plat.getLibellePlat());
			int quantite = listePlat.get(p);
			listePlat.put(p, ++quantite);
		} else {
			listePlat.put(plat, 1);
		}
	}
	
	public void removePlat(Plat	plat) {
		int quantite=0;
			Plat p = getClePlat(plat.getLibellePlat());
			quantite = listePlat.get(p);
			if(quantite>1) {
				listePlat.put(p, --quantite);
			}
			else {
				listePlat.remove(p);
			}
	}
	
	public boolean boissonContientCle(String libelle) {
		for (Boisson mapKey : listeBoisson.keySet()) {
			if(mapKey.getLibelleBoisson().equals(libelle)) {
				return true;
			}
		}
		return false;
	}
	
	public Boisson getCleBoisson(String libelle) {
		Boisson boisson = new Boisson();
		for (Boisson mapKey : listeBoisson.keySet()) {
			if(mapKey.getLibelleBoisson().equals(libelle)){				
				return mapKey;
			}
		}
		return boisson;
	}
	
	public boolean platContientCle(String libelle) {
		for (Plat mapKey : listePlat.keySet()) {
			if(mapKey.getLibellePlat().equals(libelle)) {
				return true;
			}
		}
		return false;
	}
	
	public Plat getClePlat(String libelle) {
		Plat plat = new Plat();
		for (Plat mapKey : listePlat.keySet()) {
			if(mapKey.getLibellePlat().equals(libelle)){				
				return mapKey;
			}
		}
		return plat;
	}

	public List<Boisson> getBoissons() {
		return boissons;
	}

	public void setBoissons(List<Boisson> boissons) {
		this.boissons = boissons;
	}

	public List<Plat> getPlats() {
		return plats;
	}

	public void setPlats(List<Plat> plats) {
		this.plats = plats;
	}
	



}
