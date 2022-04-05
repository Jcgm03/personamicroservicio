package com.pragma.personamicroservicio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persona")
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    private String nombres;
    private String apellidos;
    private int tipoIdentificacion;
    private int numeroIdentificacion;
    private int edad;
    private String ciudadNacimiento;


}
