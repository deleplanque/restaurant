package deleplanque.dylan.restaurant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import deleplanque.dylan.restaurant.entity.Ingredient;
import deleplanque.dylan.restaurant.services.IIngredientService;

@Controller
@RequestMapping("/api")
public class IngredientsController {

	@Autowired
	IIngredientService ingredientService;
	
	@RequestMapping(value="/getIngredients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ingredient>> getIngredients(){
		return new ResponseEntity<List<Ingredient>>(ingredientService.getIngredients(), HttpStatus.OK);
	}
}
