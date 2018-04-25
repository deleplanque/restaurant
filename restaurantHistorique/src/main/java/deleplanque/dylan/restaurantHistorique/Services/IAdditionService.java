package deleplanque.dylan.restaurantHistorique.Services;

import java.util.List;

import deleplanque.dylan.restaurantHistorique.entity.Addition;

public interface IAdditionService {

	Addition ajouterAddition(Addition addition);

	List<Addition> getAdditions();

}
