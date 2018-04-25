package deleplanque.dylan.restaurantHistorique.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import deleplanque.dylan.restaurantHistorique.Services.IAdditionService;
import deleplanque.dylan.restaurantHistorique.entity.Addition;
import deleplanque.dylan.restaurantHistorique.entity.Plat;

@Controller
@RequestMapping("/apiHistorique")
public class AdditionController {

	@Autowired
	IAdditionService additionService;

	@RequestMapping(value = "/ajouterAddition/{moyen}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Addition> ajouterAddition(@RequestBody Addition addition, @PathVariable("moyen") String moyen) {
		addition.setPaiement(moyen);
		Addition addtion = additionService.ajouterAddition(addition);
		
		if (addtion == null) {
			return new ResponseEntity<Addition>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Addition>(addtion, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getAdditions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Addition>> getAdditions() {
		return new ResponseEntity<List<Addition>>(additionService.getAdditions(), HttpStatus.OK);
	}

	
	@RequestMapping(value="/helloWorld", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Plat> getBoissons(){
		Plat plat = new Plat();
		plat.setLibellePlat("welsh");
		return new ResponseEntity<Plat>(plat, HttpStatus.OK);
	}
}