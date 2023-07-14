package com.org.crudspringweb.services;

import com.org.crudspringweb.entities.Ciudad;

import java.util.List;

public interface ICiudadService {

    List<Ciudad> findAll();
    void save(Ciudad ciudad);
    Ciudad findOne(Integer id);
    void delete(Integer id);

}
