package deleplanque.dylan.restaurant.FormBean;

import java.util.List;

import deleplanque.dylan.restaurant.entity.Boisson;
import deleplanque.dylan.restaurant.entity.Plat;

public class CreateCommandeForm {
	
	private String nomCommande;
	private String heure;
	private List<Plat> listePlats;
	private List<Boisson> listeBoissons;
	private String commentaire;
	
	public CreateCommandeForm() {}
	
	public String getNomCommande() {
		return nomCommande;
	}
	public void setNomCommande(String nomCommande) {
		this.nomCommande = nomCommande;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public List<Plat> getListePlats() {
		return listePlats;
	}
	public void setListePlats(List<Plat> listePlats) {
		this.listePlats = listePlats;
	}
	public List<Boisson> getListeBoissons() {
		return listeBoissons;
	}
	public void setListeBoissons(List<Boisson> listeBoissons) {
		this.listeBoissons = listeBoissons;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

}
