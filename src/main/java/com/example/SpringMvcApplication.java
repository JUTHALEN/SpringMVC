package com.example;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.Estudiante;
import com.example.entities.Facultad;
import com.example.entities.Telefono;
import com.example.entities.Estudiante.Genero;
import com.example.services.EstudianteService;
import com.example.services.FacultadService;
import com.example.services.TelefonoService;

@SpringBootApplication
public class SpringMvcApplication implements CommandLineRunner{

	@Autowired
	private FacultadService facultadService;

	@Autowired
	private EstudianteService estudianteService;

	@Autowired
	private TelefonoService telefonoService;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);

		//Aquí podemos meter los datos de usuarios
	}

	@Override
	public void run(String... args) throws Exception {
		/**
		 * Queremos agregar registros a la BBDD de prueba para Facultad, Estudiante y Telefono.
		 * Esto puede servir para meter un administrador y que nunca se borre.
		 */

		 facultadService.save(
			Facultad.builder()
			.nombre("Informática")
			.build()
		);
		
		facultadService.save(
			Facultad.builder()
			.nombre("Biología")
			.build()
		);

		estudianteService.save(
			Estudiante.builder()
			.id(1)
			.nombre("Iván")
			.primerApellido("Fernández")
			.segundoApellido("Rico")
			.fechaNacimiento(LocalDate.of(1989, Month.APRIL, 21))
			.fechaAlta(LocalDate.of(2022, Month.APRIL, 3))
			.genero(Genero.HOMBRE)
			.beca(6000.50)
			.facultad(facultadService.findById(1))
			.build()
		);

		estudianteService.save(
			Estudiante.builder()
			.id(2)
			.nombre("Elisabet")
			.primerApellido("Agulló")
			.segundoApellido("García")
			.fechaNacimiento(LocalDate.of(1998, Month.JULY, 21))
			.fechaAlta(LocalDate.of(2022, Month.APRIL, 3))
			.genero(Genero.MUJER)
			.beca(3900.50)
			.facultad(facultadService.findById(2))
			.build()
		);

		telefonoService.save(
			Telefono.builder()
			.id(1)
			.telefono("603410362")
			.estudiante(estudianteService.findById(1))
			.build()
			);
		
		telefonoService.save(
			Telefono.builder()
			.id(2)
			.telefono("698782341")
			.estudiante(estudianteService.findById(1))
			.build()
			);		

	}
}
