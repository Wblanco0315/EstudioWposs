package com.example.EstudioWposs.dao;

import com.example.EstudioWposs.models.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*Esta interface extenderá de CrudRepository
  CrudRepository traerá los metodos para realizar el crud*/

@Repository //se usa en las clases que se encargan de acceder y gestionar el acceso a datos (consultas a la base de datos como un CRUD)
public interface PersonaDao extends CrudRepository<Persona, Long> { //A CrudRepository le pasamos <La_clase, El_tipo_de_dato_id>
}

//creamos la carpeta "service" y creamos la interface "PersonaService"
