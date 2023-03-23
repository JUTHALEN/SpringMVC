package com.example.services;

import java.util.List;

import com.example.entities.Estudiante;
import com.example.entities.Telefono;

public interface TelefonoService { //En la interface no hace falta poner public, son metodos publicos y abstractos
    
    public List<Telefono> findAll();
    public Telefono findById(int idTelefono);
    public void save(Telefono telefono);
    public void deleteBy(int idTelefono);
    public void deleteByEstudiante(Estudiante estudiante);
    public List<Telefono> findByEstudiante(Estudiante estudiante);
    
}
