package com.pragma.personamicroservicio.model;

import lombok.*;
import org.bson.types.Binary;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class ImagenModel {

    private String id;
    private int personaId;
    //@JsonProperty("image")
    private Binary image;

}
