package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.TelefonoDao;
import com.example.entities.Estudiante;
import com.example.entities.Telefono;

@Service
public class TelefonoServiceImpl implements TelefonoService {

    @Autowired
    public TelefonoDao telefonoDao;

    @Override 
    public List<Telefono> findAll() {
        return telefonoDao.findAll();
    }

    @Override
    public Telefono findById(int idTelefono) {
        return telefonoDao.findById(idTelefono).get();
    }

    @Override
    @Transactional
    public void save(Telefono telefono) {
        telefonoDao.save(telefono);
    }

    @Override
    @Transactional
    public void deleteBy(int idTelefono) {
        telefonoDao.deleteById(idTelefono);
    }

    @Override
    @Transactional
    public void deleteByEstudiante(Estudiante estudiante) {
        telefonoDao.deleteByEstudiante(estudiante);
    }

    @Override
    @Transactional //No es necesario ponerlo en las select, pero no pasa nada si se pone
    public List<Telefono> findByEstudiante(Estudiante estudiante) {
        return telefonoDao.findByEstudiante(estudiante);
    }
    
}
