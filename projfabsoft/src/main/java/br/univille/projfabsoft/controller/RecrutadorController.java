package br.univille.projfabsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoft.entity.Recrutador;
import br.univille.projfabsoft.service.RecrutadorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/v1/recrutadores")
public class RecrutadorController {
    @Autowired
    private RecrutadorService service;

    @GetMapping
    public ResponseEntity<List<Recrutador>> getRecrutador() {
        var listaRecrutadores = service.getAll();

        return new ResponseEntity<List<Recrutador>>(listaRecrutadores,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Recrutador> postRecrutador(@RequestBody Recrutador recrutador) {
        if (recrutador == null){
            return ResponseEntity.badRequest().build();
        }
        if (recrutador.getId()==0){
            service.save(recrutador);
            return new ResponseEntity<Recrutador>(recrutador, HttpStatus.OK);
        }
        
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recrutador> putRecrutador(@PathVariable long id, @RequestBody Recrutador recrutador) {
        if (id<=0 || recrutador ==null){
            return ResponseEntity.badRequest().build();
        }

        var recrutadorAntigo = service.getById(id);
        if (recrutadorAntigo==null){
            return ResponseEntity.notFound().build();
        }

        recrutadorAntigo.setNome(recrutador.getNome());
        recrutadorAntigo.setNomeEmpresa(recrutador.getNomeEmpresa());
        
        service.save(recrutadorAntigo);
        return new ResponseEntity<Recrutador>(recrutadorAntigo,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Recrutador> deleteRecrutador(@PathVariable long id){
        if(id <=0){
            return ResponseEntity.badRequest().build();
        }

        var recrutadorExcluido = service.getById(id);
        if (recrutadorExcluido == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);

        return new ResponseEntity<Recrutador>(recrutadorExcluido, HttpStatus.OK);

    }

 
}
