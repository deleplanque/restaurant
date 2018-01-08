package deleplanque.dylan.restaurant.services;

import java.util.List;

import deleplanque.dylan.restaurant.FormBean.UpdatePlatForm;
import deleplanque.dylan.restaurant.entity.Plat;

public interface IPlatService {

	List<Plat> getPlats();

	List<Plat> modifierPlat(UpdatePlatForm platForm);

}
