package br.univille.projfabsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoft.entity.Projeto;
import br.univille.projfabsoft.service.ProjetoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/v1/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoService service;
    
    @GetMapping
    public ResponseEntity<List<Projeto>> getProjetos(){
        var listaProjetos = service.getAll();

        return new ResponseEntity<List<Projeto>>(listaProjetos, HttpStatus.OK);
    }

    @PostMapping
    public Projeto postProjetos(@RequestBody Projeto projeto) {
        if(projeto == null){
            return ResponseEntity.badRequest().build();
        }
        if (projeto.getId()==0){
            service.save(projeto);
            return new ResponseEntity<Projeto>(projeto, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
    /* 
    @PutMapping("{id}")
    public Projeto putProjetos(@PathVariable String id, @RequestBody String entity) {
        //TODO: process PUT request
        
        return entity;
    }
    */
}
