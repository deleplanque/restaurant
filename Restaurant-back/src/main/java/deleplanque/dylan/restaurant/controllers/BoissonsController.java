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

import deleplanque.dylan.restaurant.entity.Boisson;
import deleplanque.dylan.restaurant.entity.Tables;
import deleplanque.dylan.restaurant.services.IBoissonService;
import deleplanque.dylan.restaurant.services.IBoisson_AdditionService;

@Controller
@RequestMapping("/api")
public class BoissonsController {

	@Autowired
	IBoissonService boissonService;
	
	@Autowired
	IBoisson_AdditionService boisson_addition;
	
	@RequestMapping(value="/getBoissons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Boisson>> getBoissons(){
		return new ResponseEntity<List<Boisson>>(boissonService.getBoissons(), HttpStatus.OK);
	}

	
	@RequestMapping(value="/addBoisson/{idTable}/{idBoisson}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> addBoisson(@PathVariable("idTable") int idTable ,@PathVariable("idBoisson") int idBoisson){
		return new ResponseEntity<Tables>(boisson_addition.addBoisson(idTable, idBoisson), HttpStatus.OK);
	}

	@RequestMapping(value="/removeBoisson/{idTable}/{idBoisson}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> removeBoisson(@PathVariable("idTable") int idTable ,@PathVariable("idBoisson") int idBoisson){
		return new ResponseEntity<Tables>(boisson_addition.removeBoisson(idTable, idBoisson), HttpStatus.OK);
	}

	
	@RequestMapping(value="/getBoissons/{idTable}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> getBoissonsAddition(@PathVariable("idTable") int idTable){
		return new ResponseEntity<Tables>(boisson_addition.getBoissonsAddition(idTable), HttpStatus.OK);
	}
	
	@RequestMapping(value="/getBoissonsProvisoire/{idTable}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> getBoissonsProvisoire(@PathVariable("idTable") int idTable){
		return new ResponseEntity<Tables>(boisson_addition.getBoissonsProvisoire(idTable), HttpStatus.OK);
	}
	
	@RequestMapping(value="/setNomBoisson/{idBoisson}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boisson> setNomBoissons(@PathVariable("idBoisson") int idBoisson){
		return new ResponseEntity<Boisson>(boissonService.setNomBoissons(idBoisson), HttpStatus.OK);
	}
	
	@RequestMapping(value="/addBoissonAdditionToAdditionProvisoire/{idTable}/{idBoisson}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> addBoissonAdditionToAdditionProvisoire(@PathVariable("idTable") int idTable ,@PathVariable("idBoisson") int idBoisson){
		return new ResponseEntity<Tables>(boisson_addition.addBoissonAdditionToAdditionProvisoire(idTable, idBoisson), HttpStatus.OK);
	}
	
	@RequestMapping(value="/addBoissonAdditionProvisoireToAddition/{idTable}/{idBoisson}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> addBoissonAdditionProvisoire(@PathVariable("idTable") int idTable ,@PathVariable("idBoisson") int idBoisson){
		return new ResponseEntity<Tables>(boisson_addition.addBoissonAdditionProvisoireToAddition(idTable, idBoisson), HttpStatus.OK);
	}
	
}
