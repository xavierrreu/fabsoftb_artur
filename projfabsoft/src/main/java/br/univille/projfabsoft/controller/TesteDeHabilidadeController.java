package br.univille.projfabsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoft.entity.TesteDeHabilidade;
import br.univille.projfabsoft.service.TesteDeHabilidadeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1/testes")
public class TesteDeHabilidadeController {
    @Autowired
    private TesteDeHabilidadeService service;

    @GetMapping
    public ResponseEntity<List<TesteDeHabilidade>> getTestes(){
        var listaTestes = service.getAll();
        return new ResponseEntity<List<TesteDeHabilidade>>(listaTestes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TesteDeHabilidade> postTeste(@RequestBody TesteDeHabilidade teste) {
        if(teste == null){
            return ResponseEntity.badRequest().build();
        }
        if (teste.getId() == 0){
            service.save(teste);
            return new ResponseEntity<TesteDeHabilidade>(teste, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public  ResponseEntity<TesteDeHabilidade> putTeste(@PathVariable long id, @RequestBody TesteDeHabilidade teste) {
        if (id <= 0 || teste == null){
            return ResponseEntity.badRequest().build();
        }
        var testeAntigo = service.getById(id);
        if (testeAntigo==null){
            return ResponseEntity.notFound().build();
        }
        testeAntigo.setTitulo(teste.getTitulo());
        testeAntigo.setDescricao(teste.getDescricao());
        testeAntigo.setPontuacao(teste.getPontuacao());
        
        service.save(testeAntigo);
        return new ResponseEntity<TesteDeHabilidade>(testeAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TesteDeHabilidade> deleteTeste(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }

        var testeExcluido = service.getById(id);
        if (testeExcluido == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);

        return new ResponseEntity<TesteDeHabilidade>(testeExcluido, HttpStatus.OK);
    }
    
}
