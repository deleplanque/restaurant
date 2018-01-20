package deleplanque.dylan.restaurant.services;

import java.util.List;

import deleplanque.dylan.restaurant.FormBean.CreateCommandeForm;
import deleplanque.dylan.restaurant.entity.Commande;

public interface ICommandeService {

	List<Commande> creerCommande(CreateCommandeForm creerCommandeForm);

	List<Commande> getCommandes();

}
