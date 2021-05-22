package com.devsuperior.capitulo1.crudcompleto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.capitulo1.crudcompleto.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
