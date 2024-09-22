package com.mitocode.service.Impl;

import com.mitocode.model.Estudiante;
import com.mitocode.repo.IEstudianteRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl extends CRUDImpl<Estudiante, String> implements IEstudianteService {

    private final IEstudianteRepo estudianteRepo;

    @Override
    protected IGenericRepo<Estudiante, String> getRepo() { return estudianteRepo; }
}