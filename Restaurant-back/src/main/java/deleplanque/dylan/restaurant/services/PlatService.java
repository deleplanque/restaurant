package deleplanque.dylan.restaurant.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deleplanque.dylan.restaurant.FormBean.UpdatePlatForm;
import deleplanque.dylan.restaurant.entity.Ingredient;
import deleplanque.dylan.restaurant.entity.Plat;
import deleplanque.dylan.restaurant.entity.Plat_Indredient;
import deleplanque.dylan.restaurant.repository.IPlatRepository;
import deleplanque.dylan.restaurant.repository.IPlat_IngredientRepository;

@Service
public class PlatService implements IPlatService{

	@Autowired
	IPlatRepository platRepository;
	
	@Autowired
	IPlat_IngredientService platIngredientService;
	
	@Autowired
	IPlat_IngredientRepository platIngredientRepository;
	
	@Autowired
	IIngredientService ingredientService;
	
	@Override
	public List<Plat> getPlats() {
		return platRepository.findAll();
	}

	@Override
	public List<Plat> modifierPlat(UpdatePlatForm platForm) {
		platRepository.save(platForm.getPlat());
		platIngredientService.removePlatIngredient(platForm.getPlat().getIdPlat());
		List<Ingredient> listIngre = new ArrayList<>();
		for (int i=0; i<platForm.getListIngredients().size();i++) {
			listIngre.add(ingredientService.findBylibelleIngredient(platForm.getListIngredients().get(i).libelleIngredient));
		}
		for (int i=0; i<listIngre.size();i++) {
			platIngredientRepository.save(new Plat_Indredient(platForm.getPlat(), listIngre.get(i)));
		}
		return this.getPlats();
	}


}