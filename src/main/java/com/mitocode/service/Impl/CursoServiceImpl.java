package com.mitocode.service.Impl;

import com.mitocode.model.Curso;
import com.mitocode.repo.ICursoRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl extends CRUDImpl<Curso, String> implements ICursoService {

    private final ICursoRepo cursoRepo;

    @Override
    protected IGenericRepo<Curso, String> getRepo() { return cursoRepo; }
}