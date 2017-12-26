package deleplanque.dylan.restaurant.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deleplanque.dylan.restaurant.entity.Addition;
import deleplanque.dylan.restaurant.entity.Boisson;
import deleplanque.dylan.restaurant.entity.Boisson_Addition;
import deleplanque.dylan.restaurant.entity.Tables;
import deleplanque.dylan.restaurant.repository.IBoissonRepository;
import deleplanque.dylan.restaurant.repository.IBoisson_AdditionRepository;
import deleplanque.dylan.restaurant.repository.ITableRepository;

@Service
public class Boisson_AdditionService implements IBoisson_AdditionService{

	
	@Autowired
	IBoisson_AdditionRepository boissonAdditionRepository;

	@Autowired
	ITableRepository tableRepository;
	

	@Autowired
	IBoissonRepository boissonRepository;
	
	
	@Override
	public Tables getBoissonsAddition(int idTable) {
		List<Boisson_Addition> listeBoissonA = boissonAdditionRepository.findByAdditionIdAddition(idTable);
		Tables table = tableRepository.findByIdTable(idTable);
		List<Boisson> listBoisson = new ArrayList<Boisson>();
		for (int i=0; i<listeBoissonA.size();i++) {
			listBoisson.add(listeBoissonA.get(i).getBoisson());
		}
		table.getAddition().setBoissons(listBoisson);
		return table;
	}

	@Override
	public Tables addBoisson(int idTable, int idBoisson) {
		Tables table = tableRepository.findByIdTable(idTable);
		Addition addition = table.getAddition();
		Boisson boisson = boissonRepository.findByIdBoisson(idBoisson);
		boissonAdditionRepository.saveAndFlush(new Boisson_Addition(addition, boisson));
		getBoissonsAddition(idTable);
		return table;
	}
	
	@Override
	public Tables removeBoisson(int idTable, int idBoisson) {
		Tables table = tableRepository.findByIdTable(idTable);
		Addition addition = table.getAddition();
		List<Boisson_Addition> ba = boissonAdditionRepository.findByAdditionIdAdditionAndBoissonIdBoisson(addition.getIdAddition(), idBoisson);
		if(ba.size() > 0) {
			boissonAdditionRepository.delete(ba.get(ba.size()-1).getId());			
		}
		getBoissonsAddition(idTable);
		return table;
	}
}
