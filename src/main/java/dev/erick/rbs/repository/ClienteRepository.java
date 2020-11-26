package dev.erick.rbs.repository;

import org.springframework.data.repository.CrudRepository;

import dev.erick.rbs.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    
}
