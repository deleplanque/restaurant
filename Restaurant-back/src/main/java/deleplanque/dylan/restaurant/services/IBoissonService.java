package deleplanque.dylan.restaurant.services;

import java.util.List;

import deleplanque.dylan.restaurant.entity.Boisson;
import deleplanque.dylan.restaurant.entity.Tables;

public interface IBoissonService {

	List<Boisson> getBoissons();

	Tables addBoisson(int idTable, int idBoisson);

	List<Boisson> getBoissonsAddition(int idTable);

	Tables removeBoisson(int idTable, int idBoisson);

	Boisson setNomBoissons(int idBoisson);



}
