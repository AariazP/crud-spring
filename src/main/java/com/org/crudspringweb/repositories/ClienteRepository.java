package com.org.crudspringweb.repositories;

import com.org.crudspringweb.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}
