package br.com.desafiocompasso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.desafiocompasso.model.City;
import br.com.desafiocompasso.repository.CityRepository;

@Service
public class CityService {
	
	@Autowired
	CityRepository repository;
	
	public City create(City city) {
		return repository.save(city);
	}

	public List<City> findAll() {
		return repository.findAll();
	}

	public City findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public List<City> findByState(String state) {
		List<City> citys = repository.findByState(state);
		return citys;	
	}
	
	public List<City> findByName(String nameCity) {
		List<City> citys = repository.findByName(nameCity);
		return citys;	
	}


	public City update(City city) {
		City cityDB = repository.findById(city.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		cityDB.setName(city.getName());
		cityDB.setState(city.getState());

		return repository.save(cityDB);
	}

	public void delete(Long id) {
		City cityDB = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		repository.delete(cityDB);
	}

	
}
