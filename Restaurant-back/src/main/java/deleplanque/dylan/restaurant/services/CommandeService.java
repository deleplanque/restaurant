package deleplanque.dylan.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deleplanque.dylan.restaurant.FormBean.CreateCommandeForm;
import deleplanque.dylan.restaurant.entity.Addition;
import deleplanque.dylan.restaurant.entity.Commande;
import deleplanque.dylan.restaurant.repository.ICommandeRepository;

@Service
public class CommandeService implements ICommandeService{
	
	@Autowired
	ICommandeRepository commandeReposity;

	@Override
	public List<Commande> creerCommande(CreateCommandeForm creerCommandeForm) {
		Commande commande = new Commande();
		commande.setAddition(new Addition());
		commande.setAdditionProvisoire(new Addition());
		//TODO finir la methode
		return null;
	}
	
	

}
