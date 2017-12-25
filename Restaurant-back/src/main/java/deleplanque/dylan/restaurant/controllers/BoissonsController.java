package deleplanque.dylan.restaurant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import deleplanque.dylan.restaurant.entity.Addition;
import deleplanque.dylan.restaurant.entity.Boisson;
import deleplanque.dylan.restaurant.services.IBoissonService;

@Controller
@RequestMapping("/api")
public class BoissonsController {

	@Autowired
	IBoissonService boissonService;
	
	@RequestMapping(value="/getBoissons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Boisson>> getBoissons(){
		return new ResponseEntity<List<Boisson>>(boissonService.getBoissons(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/addBoisson/{idTable}/{idBoisson}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Addition> addBoisson(@PathVariable("idTable") int idTable ,@PathVariable("idBoisson") int idBoisson){
		return new ResponseEntity<Addition>(boissonService.addBoisson(idTable, idBoisson), HttpStatus.OK);
	}

}
