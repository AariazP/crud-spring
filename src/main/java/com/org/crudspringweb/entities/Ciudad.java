package com.org.crudspringweb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.io.Serializable;

@Entity
@Table(name = "ciudades")
@Data
public class Ciudad implements Serializable {

    @Id
    private int id;
    private String ciudad;

}
