package com.mitocode.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cursos")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Curso {
    @Id
    private String idCurso;

    @Field
    @Length(max = 50, message = "El nombre ingresado debe tener menos de 50 caracteres")
    private String nombreCurso;

    @Field
    @Length(min = 3, max = 3, message = "Las siglas del curso deben contar con 3 caracteres")
    private String siglasCurso;

    @Field
    private Boolean estadoCurso;
}