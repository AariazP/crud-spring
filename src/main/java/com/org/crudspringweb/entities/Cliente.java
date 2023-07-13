package com.org.crudspringweb.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
public class Cliente implements Serializable {

    @Id
    private int id;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String email;
    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

}
