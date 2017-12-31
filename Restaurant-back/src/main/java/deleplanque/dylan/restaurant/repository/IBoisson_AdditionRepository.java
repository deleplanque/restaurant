package deleplanque.dylan.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import deleplanque.dylan.restaurant.entity.Boisson_Addition;

public interface IBoisson_AdditionRepository extends JpaRepository<Boisson_Addition, Long>{

	List<Boisson_Addition> findByAdditionIdAddition(int idAddition);

	List<Boisson_Addition> findByAdditionIdAdditionAndBoissonIdBoisson(int idAddition, int idBoisson);

}
