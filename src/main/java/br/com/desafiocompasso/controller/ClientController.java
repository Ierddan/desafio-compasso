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

import br.com.desafiocompasso.model.Client;
import br.com.desafiocompasso.repository.ClientRepository;
import br.com.desafiocompasso.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	ClientService service;
	
	@Autowired
	ClientRepository repository;

	@GetMapping
	public List<Client> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	public Client findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping(value = "/findName")
	public List<Client> findByName(@RequestParam(value="name") String name) {
		return service.findByName(name);
	}

	@PostMapping
	public Client create(@RequestBody Client client) {
		return service.create(client);
	}

	@PutMapping
	public Client update(@RequestBody Client client) {
		return service.update(client);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
