package deleplanque.dylan.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import deleplanque.dylan.restaurant.entity.Tables;
import deleplanque.dylan.restaurant.services.IAdditionService;

@Controller
@RequestMapping("/api")
public class AdditionController {

	@Autowired
	IAdditionService additionService;
	
	@RequestMapping(value="/resetAddition/{idTable}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> resetAddition(@PathVariable("idTable") int idAddition){
		return new ResponseEntity<Tables>(additionService.resetAddition(idAddition), HttpStatus.OK);
	}
	
	@RequestMapping(value="/resetAdditionProvisoire/{idTable}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> resetAdditionProvisoire(@PathVariable("idTable") int idAddition){
		return new ResponseEntity<Tables>(additionService.resetAdditionProvisoire(idAddition), HttpStatus.OK);
	}
}
