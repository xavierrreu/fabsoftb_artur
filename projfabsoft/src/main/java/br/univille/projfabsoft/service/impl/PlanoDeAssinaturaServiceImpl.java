package br.univille.projfabsoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft.entity.PlanoDeAssinatura;
import br.univille.projfabsoft.repository.PlanoDeAssinaturaRepository;
import br.univille.projfabsoft.service.PlanoDeAssinaturaService;

@Service
public class PlanoDeAssinaturaServiceImpl implements PlanoDeAssinaturaService {

    @Autowired
    private PlanoDeAssinaturaRepository repository;

    @Override
    public PlanoDeAssinatura save(PlanoDeAssinatura plano){
        repository.save(plano);
        return plano;
    }

    @Override
    public List<PlanoDeAssinatura> getAll(){
        return repository.findAll();
    } 

    @Override
    public PlanoDeAssinatura getById(Long id){
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public PlanoDeAssinatura delete(Long id){
        var plano = getById(id);
        if(plano != null)
            repository.deleteById(id);
        return plano;
    }
}
