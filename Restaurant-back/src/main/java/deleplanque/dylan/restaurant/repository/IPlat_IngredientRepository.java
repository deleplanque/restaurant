package deleplanque.dylan.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import deleplanque.dylan.restaurant.entity.Plat_Indredient;

public interface IPlat_IngredientRepository extends JpaRepository<Plat_Indredient, Long>{


	List<Plat_Indredient> findByPlatIdPlat(int idPlat);

}
