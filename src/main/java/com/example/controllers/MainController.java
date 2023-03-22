package com.example.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.Estudiante;
import com.example.entities.Facultad;
import com.example.entities.Telefono;
import com.example.services.EstudianteService;
import com.example.services.FacultadService;
import com.example.services.TelefonoService;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private FacultadService facultadService; //Para tener acceso a FacultadService

    @Autowired
    private TelefonoService telefonoService;


    private static final Logger LOG = Logger.getLogger("MainController");


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

        List<Facultad> facultades = facultadService.findAll();

        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("facultades", facultades);

        return "Views/formularioAltaEstudiante";
     }
     
     //Vamos a crear un método POST que recibe los datos procedentes de los controllers del formulario
    @PostMapping("/altaEstudiante")
    public String altaEstudiante(@ModelAttribute Estudiante estudiante, @RequestParam(name= "numTelefono") String telefonosRecibidos){
        
        LOG.info("Telefonos recibidos: " + telefonosRecibidos);

        List<String> listaNumTelefonos = null;

        if(telefonosRecibidos != null) {
        String[]  arrayTelefonos = telefonosRecibidos.split(";"); //; es lo que separa y hay que señalarlo con split

        listaNumTelefonos = Arrays.asList(arrayTelefonos);

        } //SI telefono fuera requeido en el formulario esto no sería necesario

        estudianteService.save(estudiante);

        if(listaNumTelefonos != null){
            listaNumTelefonos.stream().forEach(n -> { //Lo convertimos en un flujo para recorrer la lista 
                Telefono telefonoObject = Telefono
                .builder()
                .telefono(n)
                .estudiante(estudiante)
                .build();            
            telefonoService.save(telefonoObject);
            });
        }

        //Otra forma:
        //return new RedirectView("/list");
        return "redirect:/listar";

     }
     
}
