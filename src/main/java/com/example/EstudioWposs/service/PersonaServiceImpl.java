package com.example.EstudioWposs.service;

import com.example.EstudioWposs.dao.PersonaDao;
import com.example.EstudioWposs.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaDao personaDao;
    @Override
    public List<Persona> listarPersona() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    public Persona buscarPersona(Persona persona) {
        return personaDao.findById(persona.getId_persona()).orElse(null);
    }
}
