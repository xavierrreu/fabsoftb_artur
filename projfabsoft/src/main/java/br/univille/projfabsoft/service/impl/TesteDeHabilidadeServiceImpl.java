package br.univille.projfabsoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft.entity.TesteDeHabilidade;
import br.univille.projfabsoft.repository.TesteDeHabilidadeRepository;
import br.univille.projfabsoft.service.TesteDeHabilidadeService;

@Service
public class TesteDeHabilidadeServiceImpl implements TesteDeHabilidadeService {
    
    @Autowired
    private TesteDeHabilidadeRepository repository;

    @Override
    public TesteDeHabilidade save(TesteDeHabilidade teste) {
        repository.save(teste);
        return teste;
    }

    @Override
    public List<TesteDeHabilidade> getAll() {
        return repository.findAll();
    }

    @Override
    public TesteDeHabilidade getById(Long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public TesteDeHabilidade delete(Long id) {
        var teste = getById(id);
        if(teste != null)
            repository.deleteById(id);
        return teste;
    }

}
