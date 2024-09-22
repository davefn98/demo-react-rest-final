package com.mitocode.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
public class Estudiante {
    @Id
    private String idEstudiante;

    @Field
    @NotNull(message = "Ingresar un nombre")
    @Length(max = 50, message = "El nombre ingresado debe tener menos de 50 caracteres")
    private String nombresEstudiante;

    @Field
    @NotNull(message = "Ingresar un apellido")
    @Length(max = 100, message = "El apellido ingresado debe tener menos de 100 caracteres")
    private String apellidoEstudiante;

    @Field
    @NotNull(message = "Ingresar un DNI")
    @Length(min = 8, max = 8, message = "El DNI debe tener 8 caracteres")
    private String dniEstudiante;

    @Field
    @NotNull(message = "Ingresar una edad")
    @Min(value = 0, message = "La edad debe ser mayor a 0")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int edadEstudiante;
}