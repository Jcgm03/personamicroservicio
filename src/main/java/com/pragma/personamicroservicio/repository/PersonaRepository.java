package com.pragma.personamicroservicio.repository;

import com.pragma.personamicroservicio.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository <PersonaEntity, Integer> {

    @Query(value = "select * from persona WHERE numero_identificacion=?1", nativeQuery=true)
    Optional<PersonaEntity> findByDocumento(int documento);

}
