package com.example.services;

import java.util.List;

import com.example.entities.Estudiante;


public interface EstudianteService {

    public List<Estudiante> findAll();
    public Estudiante findById(int idEstudiante);
    public void save(Estudiante estudiante);
    public void deleteBy(int idEstudiante);
    public void delete(Estudiante estudiante);
    
    /**
     * No es necesario el método Update, por que si al guardar un estudiante, ese existe, lo actualiza y si no, lo crea, 
     * en dependencia de que el idEstudiante exista o no. 
     */

}
