package deleplanque.dylan.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deleplanque.dylan.restaurant.entity.Salle;
import deleplanque.dylan.restaurant.repository.ISalleRepository;

@Service
public class SalleService implements ISalleService{

	@Autowired
	ISalleRepository salleRepository;

	@Override
	public List<Salle> getSalles() {
		return salleRepository.findAll();
	}
}
