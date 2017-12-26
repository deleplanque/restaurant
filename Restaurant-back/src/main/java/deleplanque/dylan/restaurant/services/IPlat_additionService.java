package deleplanque.dylan.restaurant.services;

import deleplanque.dylan.restaurant.entity.Tables;

public interface IPlat_additionService {

	Tables addPlat(int idTable, int idPlat);

	Tables removePlat(int idTable, int idPlat);

	Tables getPlatsAddition(int idTable);

}
