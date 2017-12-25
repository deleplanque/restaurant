package deleplanque.dylan.restaurant.entity;

public class Supplement {

	private Ingredient ingredient;
	private float prix;
	
	public Supplement() {}
	
	public Supplement(Ingredient ingredient, float prix) {
		this.ingredient = ingredient;
		this.prix = prix;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	
}
