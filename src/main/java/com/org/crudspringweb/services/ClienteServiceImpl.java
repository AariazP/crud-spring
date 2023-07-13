package com.org.crudspringweb.services;

import com.org.crudspringweb.entities.Cliente;
import com.org.crudspringweb.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public Cliente findOne(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }

}
