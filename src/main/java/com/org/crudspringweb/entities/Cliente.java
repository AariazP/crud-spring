package com.org.crudspringweb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "users")
@ToString
@Getter
@Setter
public class Cliente implements Serializable {

    @Id
    private int id;
    @NotEmpty(message = "El Nombre es requerido")
    private String nombres;
    @NotEmpty(message = "El Apellido es requerido")
    private String apellidos;
    @NotEmpty(message = "El Telefono es requerido")
    private String telefono;
    @NotEmpty(message = "El Email es requerido")
    @Email
    private String email;
    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

    public boolean isValid() {
        return this.nombres == null || this.nombres.isEmpty() ||
                this.apellidos == null || this.apellidos.isEmpty() ||
                this.telefono == null || this.telefono.isEmpty() ||
                this.email == null || this.email.isEmpty() ||
                this.ciudad == null || this.ciudad.getId() == 0;
    }
}
