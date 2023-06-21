package com.example.EstudioWposs.dao;

import com.example.EstudioWposs.models.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaDao extends CrudRepository<Persona, Long> {
}
