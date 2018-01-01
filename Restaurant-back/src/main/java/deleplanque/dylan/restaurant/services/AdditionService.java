package deleplanque.dylan.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deleplanque.dylan.restaurant.entity.Boisson_Addition;
import deleplanque.dylan.restaurant.entity.Plat_Addition;
import deleplanque.dylan.restaurant.entity.Tables;
import deleplanque.dylan.restaurant.repository.IAdditionRepository;
import deleplanque.dylan.restaurant.repository.IBoisson_AdditionRepository;
import deleplanque.dylan.restaurant.repository.IPlat_AdditionRepository;
import deleplanque.dylan.restaurant.repository.ITableRepository;

@Service
public class AdditionService implements IAdditionService{

	
	@Autowired
	IAdditionRepository additionRepository;
	
	@Autowired
	ITableRepository tableRepository;
	
	@Autowired
	IBoisson_AdditionRepository boisson_AdditionRepository;
	
	@Autowired
	IPlat_AdditionRepository plat_AdditionRepository;


	@Override
	public Tables resetAdditionProvisoire(int idTable) {
		Tables table = tableRepository.findByIdTable(idTable);
		List<Boisson_Addition> ba = boisson_AdditionRepository
				.findByAdditionIdAddition(table.getAdditionProvisoire().getIdAddition());
		for (int i=0; i<ba.size(); i++) {
			boisson_AdditionRepository.delete(ba.get(i));
		}
		
		List<Plat_Addition> listPlat = plat_AdditionRepository.findByAdditionIdAddition(table.getAdditionProvisoire().getIdAddition());
		for (int i=0; i<listPlat.size(); i++) {
			plat_AdditionRepository.delete(listPlat.get(i));
		}
		return table;
	}
	
	@Override
	public Tables resetAddition(int idTable) {
		Tables table = tableRepository.findByIdTable(idTable);
		List<Boisson_Addition> ba = boisson_AdditionRepository
				.findByAdditionIdAddition(table.getAddition().getIdAddition());
		for (int i=0; i<ba.size(); i++) {
			boisson_AdditionRepository.delete(ba.get(i));
		}
		
		List<Plat_Addition> listPlat = plat_AdditionRepository.findByAdditionIdAddition(table.getAddition().getIdAddition());
		for (int i=0; i<listPlat.size(); i++) {
			plat_AdditionRepository.delete(listPlat.get(i));
		}
		return table;
	}
	
}
