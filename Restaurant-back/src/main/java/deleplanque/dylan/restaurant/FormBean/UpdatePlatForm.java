package deleplanque.dylan.restaurant.FormBean;

import java.util.List;

import deleplanque.dylan.restaurant.entity.Ingredient;
import deleplanque.dylan.restaurant.entity.Plat;

public class UpdatePlatForm {

	private Plat plat;

	private List<Ingredient> listIngredients;

	public UpdatePlatForm() {
	}
	
	public UpdatePlatForm(Plat plat, List<Ingredient> listIngredients) {
		this.plat = plat;
		this.listIngredients = listIngredients;
	}

	public Plat getPlat() {
		return plat;
	}

	public void setPlat(Plat plat) {
		this.plat = plat;
	}

	public List<Ingredient> getListIngredients() {
		return listIngredients;
	}

	public void setListIngredients(List<Ingredient> listIngredients) {
		this.listIngredients = listIngredients;
	}

}
