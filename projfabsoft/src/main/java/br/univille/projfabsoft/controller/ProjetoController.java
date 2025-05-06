package br.univille.projfabsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoft.entity.Projeto;
import br.univille.projfabsoft.entity.Usuario;
import br.univille.projfabsoft.service.ProjetoService;

import org.springframework.web.bind.annotation.DeleteMapping;
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
    public ResponseEntity<Projeto> postProjetos(@RequestBody Projeto projeto) {
        if(projeto == null){
            return ResponseEntity.badRequest().build();
        }
        if (projeto.getId()==0){
            service.save(projeto);
            return new ResponseEntity<Projeto>(projeto, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }


    @PutMapping("/{id}") 
    public ResponseEntity<Projeto> putProjeto (@PathVariable long id, @RequestBody Projeto projeto){ 
        if (id <= 0 || projeto == null){ 
            return ResponseEntity.badRequest().build();
        } 
        var projetoAntigo = service.getById(id);
        if (projetoAntigo==null){ 
            return ResponseEntity.notFound().build(); 
        }


        projetoAntigo.setTitulo(projeto.getTitulo());
        projetoAntigo.setDescricao(projeto.getDescricao());
        projetoAntigo.setLink(projeto.getLink());

        service.save(projetoAntigo);
        return new ResponseEntity<Projeto>(projetoAntigo,HttpStatus.OK); //salva no banco via service e retorna OK ao usuário
    }

	@DeleteMapping("/{id}")
    public ResponseEntity<Projeto> deleteUsuario(@PathVariable long id){
        if(id <=0){
            return ResponseEntity.badRequest().build();
        }

        var projetoExcluido = service.getById(id);
        if(projetoExcluido == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);

        return new ResponseEntity<Projeto>(projetoExcluido, HttpStatus.OK);
    }
}
