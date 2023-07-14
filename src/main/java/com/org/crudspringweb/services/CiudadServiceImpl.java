package com.org.crudspringweb.services;

import com.org.crudspringweb.entities.Ciudad;
import com.org.crudspringweb.repositories.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServiceImpl implements ICiudadService{

    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public List<Ciudad> findAll() {
        return (List<Ciudad>) ciudadRepository.findAll();
    }

    @Override
    public void save(Ciudad ciudad) {
        ciudadRepository.save(ciudad);
    }

    @Override
    public Ciudad findOne(Integer id) {
        return ciudadRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        ciudadRepository.deleteById(id);
    }
}
