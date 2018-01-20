package deleplanque.dylan.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deleplanque.dylan.restaurant.entity.Addition;
import deleplanque.dylan.restaurant.entity.Plat;
import deleplanque.dylan.restaurant.entity.Plat_Addition;
import deleplanque.dylan.restaurant.entity.Tables;
import deleplanque.dylan.restaurant.repository.IAdditionRepository;
import deleplanque.dylan.restaurant.repository.IPlatRepository;
import deleplanque.dylan.restaurant.repository.IPlat_AdditionRepository;
import deleplanque.dylan.restaurant.repository.ITableRepository;

@Service
public class Plat_AdditionService implements IPlat_additionService {

	@Autowired
	IPlat_AdditionRepository platAdditionRepository;

	@Autowired
	ITableRepository tableRepository;
	

	@Autowired
	IPlatRepository platRepository;
	
	@Autowired
	IAdditionRepository additionRepository;
	
	@Override
	public List<Plat_Addition> addPlat(int idAddition, int idPlat) {
		Addition addition = additionRepository.findByIdAddition(idAddition);
		Plat plat = platRepository.findByIdPlat(idPlat);
		Plat_Addition platAddition = new Plat_Addition(addition, plat);
		platAdditionRepository.saveAndFlush(platAddition);
		return addition.getListPlats();
	}

	@Override
	public List<Plat_Addition> removePlat(int idAddition, int idPlat) {
		Addition addition = additionRepository.findByIdAddition(idAddition);
		List<Plat_Addition> ba = platAdditionRepository.findByAdditionIdAdditionAndPlatIdPlat(addition.getIdAddition(), idPlat);
		if(ba.size() > 0) {
			platAdditionRepository.delete(ba.get(ba.size()-1));			
		}
		return addition.getListPlats();
	}

	@Override
	public List<Plat_Addition> getPlatsAddition(int idAddition) {
		return platAdditionRepository.findByAdditionIdAddition(idAddition);
	}

	
	@Override
	public Tables addPlatAdditionToAdditionProvisoire(int idTable, int idPlat) {
		Tables table = tableRepository.findByIdTable(idTable);
		Plat plat = platRepository.findByIdPlat(idPlat);
		platAdditionRepository.saveAndFlush(new Plat_Addition(table.getAdditionProvisoire(), plat));
		List<Plat_Addition> pa = platAdditionRepository
				.findByAdditionIdAdditionAndPlatIdPlat(table.getAddition().getIdAddition(), idPlat);
		if (pa.size() > 0) {
			platAdditionRepository.delete(pa.get(pa.size() - 1).getId());
		}
		return table;
	}

	@Override
	public Tables addPlatAdditionProvisoireToAddition(int idTable, int idPlat) {
		Tables table = tableRepository.findByIdTable(idTable);
		Plat plat = platRepository.findByIdPlat(idPlat);
		platAdditionRepository.saveAndFlush(new Plat_Addition(table.getAddition(), plat));
		List<Plat_Addition> pa = platAdditionRepository
				.findByAdditionIdAdditionAndPlatIdPlat(table.getAdditionProvisoire().getIdAddition(), idPlat);
		if (pa.size() > 0) {
			platAdditionRepository.delete(pa.get(pa.size() - 1).getId());
		}
		return table;
	}

	@Override
	public  List<Plat_Addition> getPlatsProvisoire(int idAddition) {
		return additionRepository.findByIdAddition(idAddition).getListPlats();
	}
	
}
