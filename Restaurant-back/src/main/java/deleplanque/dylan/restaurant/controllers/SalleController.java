package deleplanque.dylan.restaurant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import deleplanque.dylan.restaurant.entity.Salle;
import deleplanque.dylan.restaurant.services.ISalleService;

@Controller
@RequestMapping("/api")
public class SalleController {


	@Autowired
	ISalleService salleService;
	
	@RequestMapping(value="/getSalles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Salle>> getSalles(){
		return new ResponseEntity<List<Salle>>(salleService.getSalles(), HttpStatus.OK);
	}
}
