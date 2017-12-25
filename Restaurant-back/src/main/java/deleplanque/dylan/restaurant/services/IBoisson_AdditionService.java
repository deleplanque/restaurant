package deleplanque.dylan.restaurant.services;

import deleplanque.dylan.restaurant.entity.Tables;

public interface IBoisson_AdditionService {

	Tables getBoissonsAddition(int idTable);

	Tables addBoisson(int idTable, int idBoisson);

	Tables removeBoisson(int idTable, int idBoisson);

}
