package br.univille.projfabsoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft.entity.Curso;
import br.univille.projfabsoft.repository.CursoRepository;
import br.univille.projfabsoft.service.CursoService;


@Service
public class CursoServiceImpl implements CursoService{

    @Autowired
    private CursoRepository repository;

    @Override
    public Curso save(Curso curso){
        repository.save(curso);
        return curso;
    }

    @Override
    public List<Curso> getAll(){
        return repository.findAll();
    }

    @Override
    public Curso getById(Long id){
        var retorno = repository.findById(id);
        if(retorno.isPresent()){
            return retorno.get();
        }
        return null;
    }

    @Override
    public Curso delete(Long id){
        var cliente = getById(id);
        if (cliente != null)
            repository.deleteById(id);
        return cliente;
    }
}
