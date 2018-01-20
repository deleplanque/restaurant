package deleplanque.dylan.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import deleplanque.dylan.restaurant.entity.Boisson;

public interface IBoissonRepository extends JpaRepository<Boisson, Long>{

	Boisson findByIdBoisson(int idBoisson);

	Boisson findByLibelleBoisson(String libelleBoisson);

}
