package br.univille.projfabsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.projfabsoft.entity.Curso;

public interface CursoRepository 
    extends JpaRepository<Curso,Long>{

}
