package br.univille.projfabsoft.service;

import java.util.List;

import br.univille.projfabsoft.entity.Curso;

public interface CursoService {
    Curso save(Curso curso);
    List<Curso> getAll();
    Curso getById(Long id);
    Curso delete(Long id);

}
