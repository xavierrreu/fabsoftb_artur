package br.univille.projfabsoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft.entity.ProdutorDeConteudo;
import br.univille.projfabsoft.repository.ProdutorDeConteudoRepository;
import br.univille.projfabsoft.service.ProdutorDeConteudoService;

@Service
public class ProdutorDeConteudoServiceImpl implements ProdutorDeConteudoService{

    @Autowired
    private ProdutorDeConteudoRepository repository;

    @Override
    public ProdutorDeConteudo save(ProdutorDeConteudo produtor){
        repository.save(produtor);
        return produtor;
    }

    @Override
    public List<ProdutorDeConteudo> getAll(){
        return repository.findAll();
    }

    @Override
    public ProdutorDeConteudo getById(Long id){
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public ProdutorDeConteudo delete(Long id){
        var produtor = getById(id);
        if (produtor != null)
            repository.deleteById(id);
        return produtor;
    }
}

    
