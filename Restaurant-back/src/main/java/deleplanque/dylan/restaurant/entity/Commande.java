package deleplanque.dylan.restaurant.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Commande implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCommmande;
	
	@OneToOne
	private Addition addition;
	
	@OneToOne
	private Addition additionProvisoire;
	private boolean estTermine;
	private String heure;
	private boolean estEmporter;
	private String commentaire;
	
	public Commande() {
		addition = new Addition();
		additionProvisoire = new Addition();
	}
	
	
	public Addition getAdditionProvisoire() {
		return additionProvisoire;
	}


	public void setAdditionProvisoire(Addition additionProvisoire) {
		this.additionProvisoire = additionProvisoire;
	}


	public Addition getAddition() {
		return addition;
	}
	public void setAddition(Addition addition) {
		this.addition = addition;
	}
	public boolean isEstTermine() {
		return estTermine;
	}
	public void setEstTermine(boolean estTermine) {
		this.estTermine = estTermine;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}


	public int getIdCommmande() {
		return idCommmande;
	}


	public void setIdCommmande(int idCommmande) {
		this.idCommmande = idCommmande;
	}


	public boolean isEstEmporter() {
		return estEmporter;
	}


	public void setEstEmporter(boolean estEmporter) {
		this.estEmporter = estEmporter;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}	
}
