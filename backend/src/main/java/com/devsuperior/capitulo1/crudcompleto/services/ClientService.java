package com.devsuperior.capitulo1.crudcompleto.services;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.capitulo1.crudcompleto.dto.ClientDTO;
import com.devsuperior.capitulo1.crudcompleto.entities.Client;
import com.devsuperior.capitulo1.crudcompleto.repositories.ClientRepository;

@Service
public class ClientService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	ClientRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
		List<Client> list = repository.findAll();
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(Pageable pageable){
		Page<Client> page = repository.findAll(pageable);
		return page.map(x -> new ClientDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findbyId(Long id) {
		Client entity = repository.findById(id).get();
		return new ClientDTO(entity);
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO client) {
		Client entity = setAttributes(client);
		return new ClientDTO(repository.save(entity));
	}
	
	public ClientDTO update(ClientDTO client) {
		Client entity = repository.getOne(client.getId());
		return null;
	}
	
	private Client setAttributes(ClientDTO dto) {
		Client entity = new Client();
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		entity.setIncome(dto.getIncome());
		return entity;
	}
}
