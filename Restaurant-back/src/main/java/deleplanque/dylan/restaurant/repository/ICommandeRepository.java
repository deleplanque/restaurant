package deleplanque.dylan.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import deleplanque.dylan.restaurant.entity.Commande;

public interface ICommandeRepository extends JpaRepository<Commande, Long>{

}
