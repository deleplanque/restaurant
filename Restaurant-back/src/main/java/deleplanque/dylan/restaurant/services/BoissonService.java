package deleplanque.dylan.restaurant.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return null;
	}

	@Override
	public List<Boisson> getBoissonsAddition(int idTable) {
		return null;
	}

	@Override
	public Tables removeBoisson(int idTable, int idBoisson) {
		return null;
	}

	@Override
	public Boisson setNomBoissons(int idBoisson) {
		Boisson boisson = boissonRepository.findByIdBoisson(idBoisson);
		boisson.setLibelleBoisson("Coca cola zéro");
		return boisson;
	}

	

}
