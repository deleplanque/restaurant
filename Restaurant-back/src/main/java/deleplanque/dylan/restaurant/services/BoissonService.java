package deleplanque.dylan.restaurant.services;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import deleplanque.dylan.restaurant.entity.Addition;
import deleplanque.dylan.restaurant.entity.Boisson;
import deleplanque.dylan.restaurant.entity.Tables;
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
	public Tables addBoisson(int idTable, int idBoisson) {
		Tables table = tableRepository.findByIdTable(idTable);
		Boisson boisson = boissonRepository.findByIdBoisson(idBoisson);
		Addition addition = table.getAddition();
		addition.getBoissons().add(boisson);
		addition.setBoissons(addition.getBoissons());
		return table;
	}

	@Override
	public List<Boisson> getBoissonsAddition(int idTable) {
		Tables table = tableRepository.findByIdTable(idTable);
		return table.getAddition().getBoissons();
	}

	@Override
	public Tables removeBoisson(int idTable, int idBoisson) {
		Tables table = tableRepository.findByIdTable(idTable);
		Boisson boisson = boissonRepository.findByIdBoisson(idBoisson);
		table.getAddition().getBoissons().remove(boisson);
		return table;
	}

	@Override
	public Boisson setNomBoissons(int idBoisson) {
		Boisson boisson = boissonRepository.findByIdBoisson(idBoisson);
		boisson.setLibelleBoisson("Coca cola zéro");
		return boisson;
	}

	

}
