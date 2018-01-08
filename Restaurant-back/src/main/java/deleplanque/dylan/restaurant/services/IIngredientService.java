package deleplanque.dylan.restaurant.services;

import java.util.List;

import deleplanque.dylan.restaurant.entity.Ingredient;

public interface IIngredientService {

	List<Ingredient> getIngredients();

	Ingredient findBylibelleIngredient(String libelleIngredient);

}
