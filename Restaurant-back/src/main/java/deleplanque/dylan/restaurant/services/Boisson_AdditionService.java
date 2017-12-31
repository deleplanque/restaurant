package deleplanque.dylan.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deleplanque.dylan.restaurant.entity.Addition;
import deleplanque.dylan.restaurant.entity.Boisson;
import deleplanque.dylan.restaurant.entity.Boisson_Addition;
import deleplanque.dylan.restaurant.entity.Tables;
import deleplanque.dylan.restaurant.repository.IAdditionRepository;
import deleplanque.dylan.restaurant.repository.IBoissonRepository;
import deleplanque.dylan.restaurant.repository.IBoisson_AdditionRepository;
import deleplanque.dylan.restaurant.repository.ITableRepository;

@Service
public class Boisson_AdditionService implements IBoisson_AdditionService {

	@Autowired
	IBoisson_AdditionRepository boissonAdditionRepository;

	@Autowired
	ITableRepository tableRepository;

	@Autowired
	IBoissonRepository boissonRepository;
	
	@Autowired
	IAdditionRepository additionRepository;

	@Override
	public List<Boisson_Addition> getBoissonsAddition(int idAddition) {
		return boissonAdditionRepository.findByAdditionIdAddition(idAddition);
	}

	@Override
	public List<Boisson_Addition> addBoisson(int idAddition, int idBoisson) {
		Addition addition= additionRepository.findByIdAddition(idAddition);
		boissonAdditionRepository.saveAndFlush(new Boisson_Addition(addition, boissonRepository.findByIdBoisson(idBoisson)));
		return addition.getListBoissons();
	}

	@Override
	public List<Boisson_Addition> removeBoisson(int idAddition, int idBoisson) {
		Boisson_Addition boisson = new Boisson_Addition();
		Addition addition= additionRepository.findByIdAddition(idAddition);
		List<Boisson_Addition> ba = boissonAdditionRepository
				.findByAdditionIdAdditionAndBoissonIdBoisson(addition.getIdAddition(), idBoisson);
		if (ba.size() > 0) {
			boisson = ba.get(ba.size() - 1);
			boissonAdditionRepository.delete(boisson);
		}
		return addition.getListBoissons();
	}


	@Override
	public Tables addBoissonAdditionToAdditionProvisoire(int idTable, int idBoisson) {
		Tables table = tableRepository.findByIdTable(idTable);
		Boisson boisson = boissonRepository.findByIdBoisson(idBoisson);
		boissonAdditionRepository.saveAndFlush(new Boisson_Addition(table.getAdditionProvisoire(), boisson));
		List<Boisson_Addition> ba = boissonAdditionRepository
				.findByAdditionIdAdditionAndBoissonIdBoisson(table.getAddition().getIdAddition(), idBoisson);
		if (ba.size() > 0) {
			boissonAdditionRepository.delete(ba.get(ba.size() - 1));
		}
		return table;
	}

	@Override
	public Tables addBoissonAdditionProvisoireToAddition(int idTable, int idBoisson) {
		Tables table = tableRepository.findByIdTable(idTable);
		Boisson boisson = boissonRepository.findByIdBoisson(idBoisson);
		boissonAdditionRepository.saveAndFlush(new Boisson_Addition(table.getAddition(), boisson));
		List<Boisson_Addition> ba = boissonAdditionRepository
				.findByAdditionIdAdditionAndBoissonIdBoisson(table.getAdditionProvisoire().getIdAddition(), idBoisson);
		if (ba.size() > 0) {
			boissonAdditionRepository.delete(ba.get(ba.size() - 1).getId());
		}
		return table;
	}

	@Override
	public List<Boisson_Addition> getBoissonsProvisoire(int idAddition) {
		return additionRepository.findByIdAddition(idAddition).getListBoissons();
	}
}
