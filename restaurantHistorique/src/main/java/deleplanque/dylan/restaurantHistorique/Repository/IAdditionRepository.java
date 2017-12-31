package deleplanque.dylan.restaurantHistorique.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import deleplanque.dylan.restaurantHistorique.entity.Addition;

public interface IAdditionRepository extends JpaRepository<Addition, Long>{
	
	Addition findFirstByOrderByIdAdditionDesc();

}
