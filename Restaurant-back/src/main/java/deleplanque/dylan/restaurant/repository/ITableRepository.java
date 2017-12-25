package deleplanque.dylan.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import deleplanque.dylan.restaurant.entity.Tables;

public interface ITableRepository extends JpaRepository<Tables, Long>{

	List<Tables> findBySalleIdSalle(int id);

	Tables findByIdTable(int id);

}
