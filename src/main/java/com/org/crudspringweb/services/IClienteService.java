package com.org.crudspringweb.services;

import com.org.crudspringweb.entities.Cliente;

import java.util.List;

public interface IClienteService {

     List<Cliente> findAll();
     void save(Cliente cliente);
     Cliente findOne(Integer id);
     void delete(Integer id);

}
