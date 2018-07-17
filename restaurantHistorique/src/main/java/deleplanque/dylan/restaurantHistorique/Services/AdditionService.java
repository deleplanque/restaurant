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
		for(int i=0; i<addition.getListBoissons().size();i++)
		{
			addition.getListBoissons().get(i).setAddition(addition);
		}
		for(int i=0; i<addition.getListPlats().size();i++)
		{
			addition.getListPlats().get(i).setAddition(addition);
		}
		additionRepository.save(addition);
		return additionRepository.findFirstByOrderByIdAdditionDesc();
	}

	@Override
	public List<Addition> getAdditions() {
		return additionRepository.findAll();
	}

}
