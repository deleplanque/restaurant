package deleplanque.dylan.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deleplanque.dylan.restaurant.entity.Ingredient;
import deleplanque.dylan.restaurant.repository.IIngredientRepository;

@Service
public class IngredientService implements IIngredientService{

	@Autowired
	IIngredientRepository ingredientRepository;

	@Override
	public List<Ingredient> getIngredients() {
		return ingredientRepository.findAll();
	}

	@Override
	public Ingredient findBylibelleIngredient(String libelleIngredient) {
		return ingredientRepository.findBylibelleIngredient(libelleIngredient);
	}
}
