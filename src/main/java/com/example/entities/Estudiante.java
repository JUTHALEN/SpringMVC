package com.example.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity 
@Table(name = "Estudiantes") //Cuando creemos la tabla se creará llamandose Estudiantes.
public class Estudiante implements Serializable{

    private static final long serialVersionUID = 1L;
    //Serializar es convertir un objeto de java a un flujo. 

    //Datos que va a tener la tabla estudiantes: tienen que tener un id OBLIGATORIAMENTE PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Hacemos que sea Primary Key y autoincremental.
    private int id;

    @NotNull(message = "El nombre no puede dejarse en blanco")
    //@Size(max = 25, min = 4)
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Genero genero;
    private double beca;
    //private int idFacultad; -> NO hace falta porq le hemos dicho que la pk de facultad es una columna que se llama idFacultad
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaAlta;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) //De uno a muchos Una facultad tiene muchos estudiantes
    @JoinColumn(name = "idFacultad") //Por esto hemos podido eliminar lo de private NO ES NECESARIO PONERLO
    private Facultad facultad;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "estudiante") 
    private List<Telefono> telefonos;

    public enum Genero{
        HOMBRE, MUJER, OTRO
    }

   

    
}
