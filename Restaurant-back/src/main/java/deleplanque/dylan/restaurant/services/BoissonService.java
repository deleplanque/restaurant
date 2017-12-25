package deleplanque.dylan.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deleplanque.dylan.restaurant.entity.Addition;
import deleplanque.dylan.restaurant.entity.Boisson;
import deleplanque.dylan.restaurant.repository.IAdditionRepository;
import deleplanque.dylan.restaurant.repository.IBoissonRepository;
import deleplanque.dylan.restaurant.repository.ITableRepository;

@Service
public class BoissonService implements IBoissonService{
	
	@Autowired
	IBoissonRepository boissonRepository;
	
	@Autowired
	ITableRepository tableRepository;
	
	@Autowired
	IAdditionRepository additionRepository;


	@Override
	public List<Boisson> getBoissons() {
		return boissonRepository.findAll();
	}

	@Override
	public Addition addBoisson(int idTable, int idBoisson) {
		Addition addition = tableRepository.findByIdTable(idTable).getAddition();
		Boisson boisson = boissonRepository.findByIdBoisson(idBoisson);
		addition.addBoisson(boisson);
		boissonRepository.save(boisson);
		additionRepository.save(addition);
		return addition;
	}
	

}
