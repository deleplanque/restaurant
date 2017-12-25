package deleplanque.dylan.restaurant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import deleplanque.dylan.restaurant.entity.Plat;
import deleplanque.dylan.restaurant.services.IPlatService;

@Controller
@RequestMapping("/api")
public class PlatsController {
	

	@Autowired
	IPlatService platService;
	
	@RequestMapping(value="/getPlats", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Plat>> getPlats(){
		return new ResponseEntity<List<Plat>>(platService.getPlats(), HttpStatus.OK);
	}


}
