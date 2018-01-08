package deleplanque.dylan.restaurant.controllers;

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

import deleplanque.dylan.restaurant.FormBean.UpdatePlatForm;
import deleplanque.dylan.restaurant.entity.Plat;
import deleplanque.dylan.restaurant.entity.Plat_Addition;
import deleplanque.dylan.restaurant.entity.Tables;
import deleplanque.dylan.restaurant.services.IPlatService;
import deleplanque.dylan.restaurant.services.IPlat_IngredientService;
import deleplanque.dylan.restaurant.services.IPlat_additionService;

@Controller
@RequestMapping("/api")
public class PlatsController {

	@Autowired
	IPlatService platService;

	@Autowired
	IPlat_additionService platAdditionService;

	@Autowired
	IPlat_IngredientService platIngredientService;

	@RequestMapping(value = "/getPlats", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Plat>> getPlats() {
		return new ResponseEntity<List<Plat>>(platService.getPlats(), HttpStatus.OK);
	}

	@RequestMapping(value = "/addPlat/{idAddition}/{idPlat}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Plat_Addition>> addPlat(@PathVariable("idAddition") int idAddition,
			@PathVariable("idPlat") int idPlat) {
		return new ResponseEntity<List<Plat_Addition>>(platAdditionService.addPlat(idAddition, idPlat), HttpStatus.OK);
	}

	@RequestMapping(value = "/removePlat/{idAddition}/{idPlat}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Plat_Addition>> removePlat(@PathVariable("idAddition") int idAddition,
			@PathVariable("idPlat") int idPlat) {
		return new ResponseEntity<List<Plat_Addition>>(platAdditionService.removePlat(idAddition, idPlat),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/getPlats/{idAddition}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Plat_Addition>> getPlatsAddition(@PathVariable("idAddition") int idAddition) {
		return new ResponseEntity<List<Plat_Addition>>(platAdditionService.getPlatsAddition(idAddition), HttpStatus.OK);
	}

	@RequestMapping(value = "/addPlatAdditionToAdditionProvisoire/{idTable}/{idPlat}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> addPlatAdditionToAdditionProvisoire(@PathVariable("idTable") int idTable,
			@PathVariable("idPlat") int idPlat) {
		return new ResponseEntity<Tables>(platAdditionService.addPlatAdditionToAdditionProvisoire(idTable, idPlat),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/addPlatAdditionProvisoireToAddition/{idTable}/{idPlat}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> addPlatAdditionProvisoireToAddition(@PathVariable("idTable") int idTable,
			@PathVariable("idPlat") int idPlat) {
		return new ResponseEntity<Tables>(platAdditionService.addPlatAdditionProvisoireToAddition(idTable, idPlat),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/getPlatsProvisoire/{idAddition}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Plat_Addition>> getsPlatProvisoire(@PathVariable("idAddition") int idAddition) {
		return new ResponseEntity<List<Plat_Addition>>(platAdditionService.getPlatsProvisoire(idAddition),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/modifierPlat", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Plat>> modifierPlat(@RequestBody UpdatePlatForm platForm) {
		return new ResponseEntity<List<Plat>>(platService.modifierPlat(platForm), HttpStatus.OK);
	}

	@RequestMapping(value = "/removePlatIngredient/{idPlat}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Plat> removePlatIngredient(@PathVariable("idPlat") int idPlat) {
		return new ResponseEntity<Plat>(platIngredientService.removePlatIngredient(idPlat), HttpStatus.OK);
	}

}
