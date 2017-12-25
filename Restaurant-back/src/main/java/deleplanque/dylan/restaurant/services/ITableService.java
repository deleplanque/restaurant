package deleplanque.dylan.restaurant.services;

import java.util.List;

import deleplanque.dylan.restaurant.entity.Tables;

public interface ITableService {

	List<Tables> getTables();

	List<Tables> getTablesByIdSalle(int id);

	Tables getTablesById(int id);
}
