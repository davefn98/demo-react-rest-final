package com.mitocode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "matriculas")
public class Matricula {
    @Id
    private String idMatricula;
    @Field
    private LocalDate fechaMatricula;
    @Field
    private Estudiante estudiante;
    @Field
    private List<MatriculaDetalle> detalleMatricula;
    @Field
    private Boolean estadoMatricula;
}