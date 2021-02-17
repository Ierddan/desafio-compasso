package br.com.desafiocompasso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiocompasso.model.City;
import br.com.desafiocompasso.service.CityService;

@RestController
@RequestMapping("/citys")
public class CityController {

	@Autowired
	CityService service;


	
	@GetMapping(value = "/{id}")
	public City findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	//Ex: http://localhost:8081/citys/findState?state=Pernambuco
	@GetMapping(value = "/findState")
	public List<City> findByState(@RequestParam(value="state") String state) {
		return service.findByState(state);
	}
	
	//Ex: http://localhost:8081/citys/findCity?city=Paulista
	@GetMapping(value = "/findCity")
	public List<City> findByName(@RequestParam(value="city") String nameCity) {
		return service.findByName(nameCity);
	}
	
	@PostMapping
	public City create(@RequestBody City city) {
		return service.create(city);
	}

	@PutMapping
	public City update(@RequestBody City city) {
		return service.update(city);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
