package deleplanque.dylan.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deleplanque.dylan.restaurant.entity.Plat;
import deleplanque.dylan.restaurant.entity.Plat_Indredient;
import deleplanque.dylan.restaurant.repository.IPlatRepository;
import deleplanque.dylan.restaurant.repository.IPlat_IngredientRepository;

@Service
public class Plat_IngredientService implements IPlat_IngredientService{
	
	@Autowired
	IPlat_IngredientRepository platIngredientRepository;
	
	@Autowired
	IPlatRepository platRepository;

	public Plat removePlatIngredient(int idPlat){
		List<Plat_Indredient> pi = platIngredientRepository.findByPlatIdPlat(idPlat);
		platIngredientRepository.delete(pi);
		return platRepository.findByIdPlat(idPlat);
	}
}
