package br.com.desafiocompasso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafiocompasso.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	List<City> findByName(String name);

	List<City> findByState(String state);
}
