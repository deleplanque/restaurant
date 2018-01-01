package deleplanque.dylan.restaurant.services;

import deleplanque.dylan.restaurant.entity.Tables;

public interface IAdditionService {

	Tables resetAdditionProvisoire(int idTable);

	Tables resetAddition(int idTable);

}
