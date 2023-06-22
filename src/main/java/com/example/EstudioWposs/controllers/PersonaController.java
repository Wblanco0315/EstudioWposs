package com.example.EstudioWposs.controllers;

import com.example.EstudioWposs.models.Persona;
import com.example.EstudioWposs.service.PersonaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/*Se encarga de las operaciones entre la vista y la capa de servicios*/

@Controller //Establece la clase como controlador
@Slf4j //NO se pa que pero toca ponerlo
public class PersonaController {

    @Autowired //Se usa para inyectar Servicios de una clase en otra
    private PersonaService personaService;

    //Funcion encargada de imprimir la base de datos y mostrar el index
    @GetMapping("/") //establecemos el path del index
    public String inicio(Model model){ //Funcion encargada de mostrar la lista de la base de datos
        var personas = personaService.listarPersona();
        model.addAttribute("personas", personas);//clave que se usará en la vista y el valor
        return "index"; //retorna la vista de index
    }

    @GetMapping("/agregar") //establecemos el path de agregar
    public String agregar(Persona persona){ //Funcion encargada de redirigir a la ventana de agregar datos
        return "modificar";
    }


    @PostMapping("/guardar") //establecemos el path de guardar | es Post porque envia datos
    public String guardar(@Valid Persona persona, Errors errores){ //Funcion encargada de guardar la información en la base de datos
        if(errores.hasErrors()){ //en el caso que haya error al ingresar los datos
            return "modificar"; //si hay errores vuelve a la vista de modificar
        }
        personaService.guardar(persona); //Guarda los datos de la persona
        return "redirect:/"; //redirecciona al index
    }

    @GetMapping("/eliminar/{id_persona}") //path de eliminar con el path del id de la persona a eliminar
    public String eliminar(Persona persona){ //funicion encargada de eliminar personas
        personaService.eliminar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{id_persona}") //path de editar con el path del id de la persona a editar
    public String editar(Model model,Persona persona){ //Funcion encargada de editar datos de la persona
        var encontrado=personaService.buscarPersona(persona);
        model.addAttribute("persona",encontrado); //usamos persona como clave para no confundirnos en la vista
        return "modificar"; //retorna la vista de modificar
    }
}
