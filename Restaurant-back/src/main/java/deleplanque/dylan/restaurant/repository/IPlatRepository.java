package deleplanque.dylan.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import deleplanque.dylan.restaurant.entity.Plat;

public interface IPlatRepository extends JpaRepository<Plat, Long>{

}
