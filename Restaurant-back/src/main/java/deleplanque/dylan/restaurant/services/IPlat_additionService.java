package deleplanque.dylan.restaurant.services;

import java.util.List;

import deleplanque.dylan.restaurant.entity.Plat_Addition;
import deleplanque.dylan.restaurant.entity.Tables;

public interface IPlat_additionService {

	List<Plat_Addition> addPlat(int idAddition, int idPlat);

	List<Plat_Addition> removePlat(int idAddition, int idPlat);

	List<Plat_Addition> getPlatsAddition(int idAddition);

	Tables addPlatAdditionToAdditionProvisoire(int idAddition, int idPlat);

	List<Plat_Addition> getPlatsProvisoire(int idAddition);

	Tables addPlatAdditionProvisoireToAddition(int idAddition, int idPlat);

}
