package br.univille.projfabsoft.service;

import java.util.List;

import br.univille.projfabsoft.entity.PlanoDeAssinatura;

public interface PlanoDeAssinaturaService {

    PlanoDeAssinatura save(PlanoDeAssinatura plano);
    List<PlanoDeAssinatura> getAll();
    PlanoDeAssinatura getById(Long id);
    PlanoDeAssinatura delete(Long id);
}
