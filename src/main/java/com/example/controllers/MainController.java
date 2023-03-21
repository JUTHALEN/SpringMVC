package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.Estudiante;
import com.example.services.EstudianteService;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private EstudianteService estudianteService;


    /**
     * El método siguiente devuelve un listado de estudiantes
     */

     @GetMapping("/listar")
    public ModelAndView listar() {

        List<Estudiante> estudiantes = estudianteService.findAll();

        ModelAndView mav = new ModelAndView("Views/listarEstudiantes");
        mav.addObject("estudiantes", estudiantes);        
        //mav.addObject("saludo", "Hola y hasta mañana!");        
        return mav;
    }

    //Un controlador en el patron MVC responde a una peticion(request) concreta, y la delega psodteriormente en un
    //método que tiene en cuenta el verbo utilzado del protocolo http para realizar la petición.
    //Los verbos son get, post, put, option, delete -> a través de ellos se envia la información. 



    /**
     * Muestra el formulario de alta de estudiante
     */
    
     @GetMapping("/formEstudiante")
     public String formularioAltaEstudiante(Model model){

        model.addAttribute("estudiante", new Estudiante());

        return "Views/formularioAltaEstudiante";
     }
     
}
