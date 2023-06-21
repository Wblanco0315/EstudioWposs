package com.example.EstudioWposs.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Entity
@Data
@Table(name = "persona")
public class Persona implements Serializable {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_persona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
