package br.univille.projfabsoft.service;
import java.util.List;
import br.univille.projfabsoft.entity.Projeto;

public interface ProjetoService {
    Projeto save(Projeto projeto);
    List<Projeto> getAll();
    Projeto getById(Long id);
    Projeto delete(Long id);
}
