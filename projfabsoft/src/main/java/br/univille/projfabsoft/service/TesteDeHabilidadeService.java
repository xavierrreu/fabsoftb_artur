package br.univille.projfabsoft.service;

import java.util.List;

import br.univille.projfabsoft.entity.TesteDeHabilidade;

public interface TesteDeHabilidadeService {
    TesteDeHabilidade save(TesteDeHabilidade teste);
    List<TesteDeHabilidade> getAll();
    TesteDeHabilidade getById(Long id);
    TesteDeHabilidade delete(Long id);
    
}
