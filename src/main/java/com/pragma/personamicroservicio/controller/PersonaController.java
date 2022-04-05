package com.pragma.personamicroservicio.controller;

import com.pragma.personamicroservicio.entity.PersonaEntity;
import com.pragma.personamicroservicio.model.ImagenModel;
import com.pragma.personamicroservicio.service.PersonaService;
import com.pragma.personamicroservicio.service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaServiceImpl personaServiceImpl;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<PersonaEntity> allPersona() {
        return personaServiceImpl.listar();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PersonaEntity create(@RequestBody PersonaEntity persona){
        return personaServiceImpl.save(persona);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<PersonaEntity> obtenerPersonaId(@PathVariable("id") int id){
        return  personaServiceImpl.listarId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonaEntity updatePersona(@RequestBody PersonaEntity persona,@PathVariable("id") int id){
        return personaServiceImpl.update(persona,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> eliminarPersona(@PathVariable("id") int id){
        personaServiceImpl.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/info/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ImagenModel> info(@PathVariable("id") int id) {
    return personaServiceImpl.infoImagen(id);
    }

}
