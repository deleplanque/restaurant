package deleplanque.dylan.restaurant.services;

import java.util.List;

import deleplanque.dylan.restaurant.entity.Addition;
import deleplanque.dylan.restaurant.entity.Boisson;

public interface IBoissonService {

	List<Boisson> getBoissons();

	Addition addBoisson(int idTable, int idBoisson);


}
