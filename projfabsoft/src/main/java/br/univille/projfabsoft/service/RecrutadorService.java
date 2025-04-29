package br.univille.projfabsoft.service;
import br.univille.projfabsoft.entity.Recrutador;
import java.util.List;

public interface RecrutadorService {
    Recrutador save(Recrutador recrutador);
    List<Recrutador> getAll();
    Recrutador getById(Long id);
    Recrutador delete(Long id);
}

