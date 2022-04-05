package com.pragma.personamicroservicio.client;

import com.pragma.personamicroservicio.model.ImagenModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "imagen-microservicio", path = "/api/img")
public interface ImagenClient {

     @GetMapping("/{id}")
     List<ImagenModel> buscarImagen (@PathVariable("id") int id);
}
