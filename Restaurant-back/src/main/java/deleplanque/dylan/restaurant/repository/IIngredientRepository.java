package deleplanque.dylan.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import deleplanque.dylan.restaurant.entity.Ingredient;

public interface IIngredientRepository extends JpaRepository<Ingredient, Long>{

	Ingredient findBylibelleIngredient(String libelleIngredient);

}
