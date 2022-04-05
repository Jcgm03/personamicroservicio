package com.pragma.personamicroservicio.service;

import com.pragma.personamicroservicio.client.ImagenClient;
import com.pragma.personamicroservicio.config.exception.NotFoundException;
import com.pragma.personamicroservicio.entity.PersonaEntity;
import com.pragma.personamicroservicio.model.ImagenModel;
import com.pragma.personamicroservicio.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl  implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private ImagenClient imagenClient;

    @Override
    public List<PersonaEntity> listar() {
        List<PersonaEntity> all = personaRepository.findAll();
        return all;
    }

    public List<ImagenModel> infoImagen(int personaId) {
        return imagenClient.buscarImagen(personaId);
    }

    @Override
    public PersonaEntity save(PersonaEntity persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Optional<PersonaEntity> listarId(int id) {
        Optional<PersonaEntity> Opers = personaRepository.findById(id);
        if (!Opers.isPresent()) {
            throw new NotFoundException("La persona no existe");
        }
        return Opers;
    }

    @Override
    public Optional<PersonaEntity> listarDocumento(int documento) {
        Optional<PersonaEntity> byDocumento = personaRepository.findByDocumento(documento);
        if (!byDocumento.isPresent()) {
            throw new NotFoundException("La persona no existe");
        }
        return byDocumento;
    }

    @Override
    public Object delete(int id) {
        personaRepository.findById(id).orElseThrow(()
                -> new NotFoundException("La persona no existe"));

        personaRepository.deleteById(id);
        return null;
    }

    @Override
    public PersonaEntity update(PersonaEntity persona, int id) {
        Optional<PersonaEntity> oPersonaUpdate = personaRepository.findById(id);
        if (!oPersonaUpdate.isPresent()){
            throw new NotFoundException("La persona no existe");
        }
        oPersonaUpdate.get().setEdad(persona.getEdad());
        oPersonaUpdate.get().setNumeroIdentificacion(persona.getNumeroIdentificacion());
        oPersonaUpdate.get().setApellidos(persona.getApellidos());
        oPersonaUpdate.get().setNombres(persona.getNombres());
        oPersonaUpdate.get().setTipoIdentificacion(persona.getTipoIdentificacion());
        oPersonaUpdate.get().setCiudadNacimiento(persona.getCiudadNacimiento());
        return personaRepository.save(oPersonaUpdate.get());
    }
}
