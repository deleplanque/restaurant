package deleplanque.dylan.restaurantHistorique.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deleplanque.dylan.restaurantHistorique.Repository.IAdditionRepository;
import deleplanque.dylan.restaurantHistorique.entity.Addition;

@Service
public class AdditionService implements IAdditionService{

	@Autowired
	IAdditionRepository additionRepository;
	
	@Override
	public Addition ajouterAddition(Addition addition) {
		additionRepository.save(addition);
			Addition ad = additionRepository.findFirstByOrderByIdAdditionDesc();
		for (int i=0; i<ad.getListBoissons().size(); i++) {
			ad.getListBoissons().get(i).setAddition(ad);
		}
		
		for (int i=0; i<ad.getListPlats().size(); i++) {
			ad.getListPlats().get(i).setAddition(ad);
		}
		additionRepository.save(ad);
		return additionRepository.findFirstByOrderByIdAdditionDesc();
	}

	@Override
	public List<Addition> getAdditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
