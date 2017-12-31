package deleplanque.dylan.restaurant.services;

import java.util.List;

import deleplanque.dylan.restaurant.entity.Plat_Addition;
import deleplanque.dylan.restaurant.entity.Tables;

public interface IPlat_additionService {

	List<Plat_Addition> addPlat(int idTable, int idPlat);

	List<Plat_Addition> removePlat(int idTable, int idPlat);

	List<Plat_Addition> getPlatsAddition(int idTable);

	Tables addPlatAdditionToAdditionProvisoire(int idTable, int idPlat);

	List<Plat_Addition> getPlatsProvisoire(int idAddition);

	Tables addPlatAdditionProvisoireToAddition(int idTable, int idPlat);

}
