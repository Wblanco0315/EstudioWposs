package com.example.EstudioWposs.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.io.Serializable;

/* Esta es la primer clase que vamos a crear
 estableceremos los atributos de la base de datos */


@Entity //Esta notación hace que spring reconozca esta clase como clase de entidad
@Data //Hace que se creen los metodos getter, setter y el constructor
@Table(name = "persona") //Se usa para diferenciar la tabla de la base de datos
public class Persona implements Serializable { //implementamos la interface Serializable

    private static final long serialVersionUID=1L; //no se pa que es pero toca ponerlo
    @Id //Establece el Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //indica que los valores del id se asignaran automaticamente
    private long id_persona;

    @NotEmpty //notacion usada para indicar que el campo no puede ser vacio
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotEmpty
    private String email;

    private String telefono;
}
//El siguiente paso será crear el paquete "dao" y al clase "PersonaDao"
