package br.univille.projfabsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.univille.projfabsoft.entity.PlanoDeAssinatura;
import br.univille.projfabsoft.service.PlanoDeAssinaturaService;


public class PlanoDeAssinaturaController {
    @Autowired
    private PlanoDeAssinaturaService service;

    //ABAIXO ESTÁ O CÓDIGO PARA 'SELECT' DE NOVOS USUÁRIOS VIA HTTP REQUEST
    @GetMapping 
    public ResponseEntity<List<PlanoDeAssinatura>> getPlano(){
        var listaPlanos = service.getAll();

        return new ResponseEntity<List<PlanoDeAssinatura>>(listaPlanos, HttpStatus.OK);
    }

    //ABAIXO ESTÁ O CÓDIGO PARA 'INSERT' DE NOVOS USUÁRIOS VIA HTTP REQUEST
    @PostMapping
    public ResponseEntity<PlanoDeAssinatura> postPlano(@RequestBody PlanoDeAssinatura plano){
        if (plano == null){
            return ResponseEntity.badRequest().build();
        }
        if (plano.getId() == 0){
            service.save(plano);
            return new ResponseEntity<PlanoDeAssinatura>(plano, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    //ABAIXO ESTÁ O CÓDIGO PARA 'UPDATE' DE NOVOS USUÁRIOS VIA HTTP REQUEST
    @PutMapping("/{id}") // demonstra que será necessário repassar o ID do usuário a ser atualizado no caminho http
    public ResponseEntity<PlanoDeAssinatura> putPlano (@PathVariable long id, @RequestBody PlanoDeAssinatura plano){ //recebe o ID de atualiação e o objeto usuário
        if (id <= 0 || plano == null){ //para o caso de IDs não válidos
            return ResponseEntity.badRequest().build();
        } 
        var planoAntigo = service.getById(id);
        if (planoAntigo==null){ //para o caso de IDs não nulos mas que não existem no banco
            return ResponseEntity.notFound().build(); 
        }

        // após validações, atualizaremos o usuário campo a campo com os novos dados(ou não)
        planoAntigo.setNomePlano(plano.getNomePlano());
        planoAntigo.setBeneficios(plano.getBeneficios());
        planoAntigo.setPreco(plano.getPreco());

        service.save(planoAntigo);
        return new ResponseEntity<PlanoDeAssinatura>(planoAntigo,HttpStatus.OK); //salva no banco via service e retorna OK ao usuário
    }

	@DeleteMapping("/{id}")
    public ResponseEntity<PlanoDeAssinatura> deletePlano(@PathVariable long id){
        if(id <=0){
            return ResponseEntity.badRequest().build();
        }

        var planoExcluido = service.getById(id);
        if(planoExcluido == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);

        return new ResponseEntity<PlanoDeAssinatura>(planoExcluido,HttpStatus.OK);
    }
}
