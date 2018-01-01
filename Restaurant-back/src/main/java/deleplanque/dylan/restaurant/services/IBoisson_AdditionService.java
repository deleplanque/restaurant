package deleplanque.dylan.restaurant.services;

import java.util.List;

import deleplanque.dylan.restaurant.entity.Boisson_Addition;
import deleplanque.dylan.restaurant.entity.Tables;

public interface IBoisson_AdditionService {

	List<Boisson_Addition> getBoissonsAddition(int idAddition);

	List<Boisson_Addition> addBoisson(int idAddition, int idBoisson);

	List<Boisson_Addition> removeBoisson(int idAddition, int idBoisson);

	Tables addBoissonAdditionToAdditionProvisoire(int idTable, int idBoisson);

	Tables addBoissonAdditionProvisoireToAddition(int idTable, int idBoisson);

	List<Boisson_Addition> getBoissonsProvisoire(int idAddition);

}
