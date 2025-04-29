package br.univille.projfabsoft.service;

import java.util.List;

import br.univille.projfabsoft.entity.ProdutorDeConteudo;

public interface ProdutorDeConteudoService {
    ProdutorDeConteudo save(ProdutorDeConteudo produtor);
    List<ProdutorDeConteudo> getAll();
    ProdutorDeConteudo getById(Long id);
    ProdutorDeConteudo delete(Long id);
}
