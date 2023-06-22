package com.example.EstudioWposs.service;

import com.example.EstudioWposs.dao.PersonaDao;
import com.example.EstudioWposs.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired //Se usa para inyectar Servicios de una clase en otra
    private PersonaDao personaDao;

    //Sobrescribimos los metos de la interface PersonaService

    @Override
    public List<Persona> listarPersona() { //Se encarga de llamar todos los datos de la base de datos
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    public void guardar(Persona persona) { //Se encarga de guardar los datos
        personaDao.save(persona);
    }

    @Override
    public void eliminar(Persona persona) { //Se encarga de eliminar los datos
        personaDao.delete(persona);
    }

    @Override
    public Persona buscarPersona(Persona persona) { //Se encarga de encontrar una persona por id
        return personaDao.findById(persona.getId_persona()).orElse(null); //en caso que no la encuetre es null
    }
}

//Creamos la carpeta "controllers" Creamos la clase "PersonaController"
