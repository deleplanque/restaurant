package deleplanque.dylan.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deleplanque.dylan.restaurant.entity.Plat;
import deleplanque.dylan.restaurant.repository.IPlatRepository;

@Service
public class PlatService implements IPlatService{

	@Autowired
	IPlatRepository platRepository;
	
	@Override
	public List<Plat> getPlats() {
		return platRepository.findAll();
	}

}
