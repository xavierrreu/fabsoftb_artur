package br.univille.projfabsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoft.entity.ProdutorDeConteudo;
import br.univille.projfabsoft.entity.Usuario;
import br.univille.projfabsoft.service.ProdutorDeConteudoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/produtores")
public class ProdutorDeConteutoController {
    @Autowired
    private ProdutorDeConteudoService service;

    @GetMapping
    public ResponseEntity<List<ProdutorDeConteudo>> getProdutor() {
        var listaProdutores = service.getAll();

        return new ResponseEntity<List<ProdutorDeConteudo>>(listaProdutores, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProdutorDeConteudo> postProdutor(@RequestBody ProdutorDeConteudo produtor){
        if (produtor == null){
            return ResponseEntity.badRequest().build();
        }
        if (produtor.getId() == 0){
            service.save(produtor);
            return new ResponseEntity<ProdutorDeConteudo>(produtor, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}") 
    public ResponseEntity<ProdutorDeConteudo> putProdutor (@PathVariable long id, @RequestBody ProdutorDeConteudo produtor){ 
        if (id <= 0 || produtor == null){ 
            return ResponseEntity.badRequest().build();
        } 
        var produtorAntigo = service.getById(id);
        if (produtorAntigo==null){ 
            return ResponseEntity.notFound().build(); 
        }


        produtorAntigo.setNome(produtor.getNome());


        service.save(produtorAntigo);
        return new ResponseEntity<ProdutorDeConteudo>(produtorAntigo,HttpStatus.OK); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutorDeConteudo> deleteProdutor(@PathVariable long id){
        if(id <=0){
            return ResponseEntity.badRequest().build();
        }

        var produtorExcluido = service.getById(id);
        if(produtorExcluido == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);

        return new ResponseEntity<ProdutorDeConteudo>(produtorExcluido,
                HttpStatus.OK);
    }
    
}
