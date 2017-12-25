package deleplanque.dylan.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deleplanque.dylan.restaurant.entity.Tables;
import deleplanque.dylan.restaurant.repository.ITableRepository;

@Service
public class TableService implements ITableService{

	@Autowired
	ITableRepository tableRepository;

	@Override
	public List<Tables> getTables() {
		return tableRepository.findAll();
	}

	@Override
	public List<Tables> getTablesByIdSalle(int id) {
		return tableRepository.findBySalleIdSalle(id);
	}

	@Override
	public Tables getTablesById(int id) {
		return tableRepository.findByIdTable(id);
	}

}
