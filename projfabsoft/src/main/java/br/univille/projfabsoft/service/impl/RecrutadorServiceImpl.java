package br.univille.projfabsoft.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft.entity.Recrutador;
import br.univille.projfabsoft.repository.RecrutadorRepository;
import br.univille.projfabsoft.service.RecrutadorService;

@Service
public class RecrutadorServiceImpl implements RecrutadorService{

    @Autowired
    private RecrutadorRepository repository;

    @Override
    public Recrutador save(Recrutador recrutador){
        repository.save(recrutador);
        return recrutador;
    }

    @Override
    public List<Recrutador> getAll(){
        return repository.findAll();
    }

    @Override
    public Recrutador getById(Long id){
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public Recrutador delete(Long id){
        var recrutador = getById(id);
        if (recrutador != null)
            repository.deleteById(id);
        return recrutador;
    }
}
