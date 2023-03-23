package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Estudiante;
import com.example.entities.Telefono;

public interface TelefonoDao extends JpaRepository<Telefono, Integer> {

    // //Aparte de las consultas que se crea con JPA podemos crear las nuestras propias
    // @Query(value = "delete from telefonos where estudiante_id =: idEstudiante", nativeQuery = true);
    // long deleteByEstudiante(@Param("idEstudiante") Integer idEstudiante);

    long deleteByEstudiante(Estudiante estudiante);

   // List<Telefono> findByEstudiante(Estudiante estudiante);
}
