package deleplanque.dylan.restaurant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import deleplanque.dylan.restaurant.FormBean.CreateCommandeForm;
import deleplanque.dylan.restaurant.entity.Commande;
import deleplanque.dylan.restaurant.services.ICommandeService;

@Controller
@RequestMapping("/api")
public class CommandeController {
	
	@Autowired
	ICommandeService commandeService;

	@RequestMapping(value = "/creerCommande", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Commande>> creerCommande(@RequestBody CreateCommandeForm creerCommandeForm) {
		return new ResponseEntity<List<Commande>>(commandeService.creerCommande(creerCommandeForm), HttpStatus.OK);
	}
}
