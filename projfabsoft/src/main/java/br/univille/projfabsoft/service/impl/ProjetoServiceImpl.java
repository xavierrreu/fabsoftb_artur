package br.univille.projfabsoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft.entity.Projeto;
import br.univille.projfabsoft.repository.ProjetoRepository;
import br.univille.projfabsoft.service.ProjetoService;

@Service
public class ProjetoServiceImpl implements ProjetoService{

    @Autowired
    private ProjetoRepository repository;
    
    @Override
    public Projeto save(Projeto projeto){
        repository.save(projeto);
        return projeto;
    }

    @Override
    public List<Projeto> getAll(){
        return repository.findAll();
    }

    @Override
    public Projeto getById(Long id){
        var retorno = repository.findById(id);
        if (retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public Projeto delete(Long id){
        var projeto = getById(id);
        if(projeto != null)
            repository.deleteById(id);
        return projeto;
    }
}
