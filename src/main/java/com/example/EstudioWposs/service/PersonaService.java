package com.example.EstudioWposs.service;

import com.example.EstudioWposs.models.Persona;

import java.util.List;

//Aqui inicializaremos los metodos con los que interactuaremos con la base de datos

public interface PersonaService {
    public List<Persona> listarPersona();

    public void guardar(Persona persona);

    public void eliminar(Persona persona);

    public Persona buscarPersona(Persona persona);
}

//creamos la clase de "PersonaServiceImpl" (Implementation)
