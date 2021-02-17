package br.com.desafiocompasso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.desafiocompasso.model.Client;
import br.com.desafiocompasso.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository repository;

	public Client create(Client client) {
		return repository.save(client);
	}

	public List<Client> findAll() {
		return repository.findAll();
	}

	public Client findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public List<Client> findByName(String name) {
		List<Client> clients = repository.findByFullName(name);
		return clients;	
	}

	public Client update(Client client) {
		Client clientDB = repository.findById(client.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		clientDB.setFullName(client.getFullName());
		clientDB.setGenre(client.getGenre());

		return repository.save(clientDB);
	}

	public void delete(Long id) {
		Client clientDB = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		repository.delete(clientDB);
	}

}
