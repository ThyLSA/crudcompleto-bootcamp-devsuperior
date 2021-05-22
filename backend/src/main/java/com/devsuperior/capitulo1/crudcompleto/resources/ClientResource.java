package com.devsuperior.capitulo1.crudcompleto.resources;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.capitulo1.crudcompleto.dto.ClientDTO;
import com.devsuperior.capitulo1.crudcompleto.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	ClientService service;
	
	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll(){
		List<ClientDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
		ClientDTO dto = service.findbyId(id);
		return ResponseEntity.ok(dto);
	}
}
