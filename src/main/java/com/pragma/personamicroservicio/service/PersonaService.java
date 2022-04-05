package com.pragma.personamicroservicio.service;

import com.pragma.personamicroservicio.entity.PersonaEntity;

import java.util.List;
import java.util.Optional;

public interface PersonaService {

    List<PersonaEntity> listar();
    PersonaEntity save(PersonaEntity persona);
    Optional<PersonaEntity> listarId(int id);
    Optional<PersonaEntity> listarDocumento (int documento);
    Object delete(int id);
    PersonaEntity update(PersonaEntity persona, int id);
}
