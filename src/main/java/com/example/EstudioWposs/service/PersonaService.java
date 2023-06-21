package com.example.EstudioWposs.service;

import com.example.EstudioWposs.models.Persona;

import java.util.List;

public interface PersonaService {
    public List<Persona> listarPersona();

    public void guardar(Persona persona);

    public void eliminar(Persona persona);

    public Persona buscarPersona(Persona persona);
}
