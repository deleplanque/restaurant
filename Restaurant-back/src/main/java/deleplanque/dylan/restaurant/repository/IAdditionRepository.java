package deleplanque.dylan.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import deleplanque.dylan.restaurant.entity.Addition;

public interface IAdditionRepository extends JpaRepository<Addition, Long>{

}
