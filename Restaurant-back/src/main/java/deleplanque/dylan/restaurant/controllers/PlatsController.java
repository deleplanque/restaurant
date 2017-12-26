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

import deleplanque.dylan.restaurant.entity.Plat;
import deleplanque.dylan.restaurant.entity.Tables;
import deleplanque.dylan.restaurant.services.IPlatService;
import deleplanque.dylan.restaurant.services.IPlat_additionService;

@Controller
@RequestMapping("/api")
public class PlatsController {
	

	@Autowired
	IPlatService platService;
	
	@Autowired
	IPlat_additionService platAdditionService;
	
	@RequestMapping(value="/getPlats", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Plat>> getPlats(){
		return new ResponseEntity<List<Plat>>(platService.getPlats(), HttpStatus.OK);
	}

	@RequestMapping(value="/addPlat/{idTable}/{idPlat}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> addPlat(@PathVariable("idTable") int idTable ,@PathVariable("idPlat") int idPlat){
		return new ResponseEntity<Tables>(platAdditionService.addPlat(idTable, idPlat), HttpStatus.OK);
	}

	@RequestMapping(value="/removePlat/{idTable}/{idPlat}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> removePlat(@PathVariable("idTable") int idTable ,@PathVariable("idPlat") int idPlat){
		return new ResponseEntity<Tables>(platAdditionService.removePlat(idTable, idPlat), HttpStatus.OK);
	}

	
	@RequestMapping(value="/getPlats/{idTable}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> getPlatsAddition(@PathVariable("idTable") int idTable){
		return new ResponseEntity<Tables>(platAdditionService.getPlatsAddition(idTable), HttpStatus.OK);
	}
}
