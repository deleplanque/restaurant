package deleplanque.dylan.restaurant.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deleplanque.dylan.restaurant.entity.Addition;
import deleplanque.dylan.restaurant.entity.Plat;
import deleplanque.dylan.restaurant.entity.Plat_Addition;
import deleplanque.dylan.restaurant.entity.Tables;
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
	
	
	@Override
	public Tables addPlat(int idTable, int idPlat) {
		Tables table = tableRepository.findByIdTable(idTable);
		Addition addition = table.getAddition();
		Plat plat = platRepository.findByIdPlat(idPlat);
		platAdditionRepository.saveAndFlush(new Plat_Addition(addition, plat));
		getPlatsAddition(idTable);
		return table;
	}

	@Override
	public Tables removePlat(int idTable, int idPlat) {
		Tables table = tableRepository.findByIdTable(idTable);
		Addition addition = table.getAddition();
		List<Plat_Addition> ba = platAdditionRepository.findByAdditionIdAdditionAndPlatIdPlat(addition.getIdAddition(), idPlat);
		if(ba.size() > 0) {
			platAdditionRepository.delete(ba.get(ba.size()-1).getId());			
		}
		getPlatsAddition(idTable);
		return table;
	}

	@Override
	public Tables getPlatsAddition(int idTable) {
		List<Plat_Addition> listePlatA = platAdditionRepository.findByAdditionIdAddition(idTable);
		Tables table = tableRepository.findByIdTable(idTable);
		List<Plat> listPlats = new ArrayList<Plat>();
		for (int i=0; i<listePlatA.size();i++) {
			listPlats.add(listePlatA.get(i).getPlat());
		}
		table.getAddition().setPlats(listPlats);
		return table;
	}


	
}
