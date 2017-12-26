package deleplanque.dylan.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import deleplanque.dylan.restaurant.entity.Plat_Addition;

public interface IPlat_AdditionRepository extends JpaRepository<Plat_Addition, Long>{

	List<Plat_Addition> findByAdditionIdAddition(int idTable);

	List<Plat_Addition> findByAdditionIdAdditionAndPlatIdPlat(int idAddition, int idPlat);

}
