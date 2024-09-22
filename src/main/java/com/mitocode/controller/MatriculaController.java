package com.mitocode.controller;

import com.mitocode.model.Matricula;
import com.mitocode.service.IMatriculaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {
    private final IMatriculaService matriculaService;

    @GetMapping
    public Mono<ResponseEntity<Flux<Matricula>>> getAll() {
        Flux<Matricula> fx = matriculaService.findAll();

        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fx)
        );
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Matricula>> getById(@PathVariable String id) {
        return matriculaService.findById(id)
                .map(e -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e)
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<Matricula>> create(@Valid @RequestBody Matricula matricula, final ServerHttpRequest req) {
        return matriculaService.save(matricula)
                .map(e -> ResponseEntity.created(
                                        URI.create(req.getURI().toString().concat("/").concat(e.getIdMatricula()))
                                )
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(e)
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Matricula>> update(@PathVariable("id") String id,@Valid @RequestBody Matricula matricula) {
        return Mono.just(matricula)
                .map(e -> {
                    matricula.setIdMatricula(id);
                    return e;
                })
                .flatMap(e -> matriculaService.update(id, e))
                .map(e -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e)
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable("id") String id) {
        return matriculaService.delete(id)
                .flatMap(result -> {
                    if(result){
                        return Mono.just(ResponseEntity.noContent().build());
                    }else {
                        return Mono.just(ResponseEntity.notFound().build());
                    }
                });
    }
}