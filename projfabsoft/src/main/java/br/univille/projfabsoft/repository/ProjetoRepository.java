package br.univille.projfabsoft.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.univille.projfabsoft.entity.Projeto;

public interface ProjetoRepository 
    extends JpaRepository<Projeto,Long>{

}
