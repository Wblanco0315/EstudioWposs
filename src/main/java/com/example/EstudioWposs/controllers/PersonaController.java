package com.example.EstudioWposs.controllers;

import com.example.EstudioWposs.models.Persona;
import com.example.EstudioWposs.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    //Funcion encargada de imprimir la base de datos y mostrar el index
    @GetMapping("/")
    public String inicio(Model model){
        var personas = personaService.listarPersona();
        model.addAttribute("personas", personas);
        return "index";
    }
   //Funcion encargada de redirigir a la ventana de agregar datos
    @GetMapping("/agregar")
    public String agregar(Persona persona){

        return "modificar";
    }

    //Funcion encargada de guardar la información en la base de datos
    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id_persona}")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{id_persona}")
    public String editar(Model model,Persona persona){
        var encontrado=personaService.buscarPersona(persona);
        model.addAttribute("persona",encontrado);
        return "modificar";
    }
}
