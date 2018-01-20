package deleplanque.dylan.restaurant.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deleplanque.dylan.restaurant.FormBean.CreateCommandeForm;
import deleplanque.dylan.restaurant.entity.Addition;
import deleplanque.dylan.restaurant.entity.Boisson;
import deleplanque.dylan.restaurant.entity.Boisson_Addition;
import deleplanque.dylan.restaurant.entity.Commande;
import deleplanque.dylan.restaurant.entity.Plat;
import deleplanque.dylan.restaurant.entity.Plat_Addition;
import deleplanque.dylan.restaurant.repository.IAdditionRepository;
import deleplanque.dylan.restaurant.repository.IBoissonRepository;
import deleplanque.dylan.restaurant.repository.IBoisson_AdditionRepository;
import deleplanque.dylan.restaurant.repository.ICommandeRepository;
import deleplanque.dylan.restaurant.repository.IPlatRepository;
import deleplanque.dylan.restaurant.repository.IPlat_IngredientRepository;

@Service
public class CommandeService implements ICommandeService{
	
	@Autowired
	ICommandeRepository commandeReposity;

	@Autowired 
	IPlat_IngredientRepository platIngredientRepository;
	
	@Autowired
	IBoisson_AdditionRepository boissonAdditionRepository;
	
	@Autowired
	IPlatRepository platRepository;
	
	@Autowired
	IBoissonRepository boissonRepository;
	
	@Autowired
	IAdditionRepository additionRepository;
	
	@Override
	public List<Commande> creerCommande(CreateCommandeForm creerCommandeForm) {
		Commande commande = new Commande();
		Addition addition = new Addition();
		additionRepository.saveAndFlush(addition);
		Addition additionProvisoire = new Addition();
		additionRepository.saveAndFlush(additionProvisoire);
		commande.setAddition(addition);
		commande.setAdditionProvisoire(additionProvisoire);
		List<Plat_Addition> listPlat = new ArrayList<Plat_Addition>();
		for (int i=0; i< creerCommandeForm.getListePlats().size(); i++) {
			Plat plat = platRepository.findByLibellePlat(creerCommandeForm.getListePlats().get(i).getLibellePlat());
			listPlat.add(new Plat_Addition(addition, plat));
			addition.setMontantTotal(addition.getMontantTotal()+plat.getPrix());
		}
		List<Boisson_Addition> listBoisson = new ArrayList<Boisson_Addition>();
		for (int i=0; i<creerCommandeForm.getListeBoissons().size(); i++) {
			Boisson boisson = boissonRepository.findByLibelleBoisson(creerCommandeForm.getListeBoissons().get(i).getLibelleBoisson());
			listBoisson.add(new Boisson_Addition(addition, boisson));
			addition.setMontantTotal(addition.getMontantTotal()+boisson.getPrix());
		}
		additionRepository.save(addition);
		commande.getAddition().setListPlats(listPlat);
		commande.getAddition().setListBoissons(listBoisson);
		commande.setCommentaire(creerCommandeForm.getCommentaire());
		commande.setNom(creerCommandeForm.getNomCommande());
		commande.setHeure(creerCommandeForm.getHeure());
		commandeReposity.saveAndFlush(commande);
		return commandeReposity.findAll();
	}

	@Override
	public List<Commande> getCommandes() {
		return commandeReposity.findAll();
	}
	
	

}
