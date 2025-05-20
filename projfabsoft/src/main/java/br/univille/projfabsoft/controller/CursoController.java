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

import br.univille.projfabsoft.entity.Curso;
import br.univille.projfabsoft.service.CursoService;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {
    @Autowired
    private CursoService service;

    //ABAIXO ESTÁ O CÓDIGO PARA 'SELECT' DE NOVOS USUÁRIOS VIA HTTP REQUEST
    @GetMapping 
    public ResponseEntity<List<Curso>> getCurso(){
        var listaCursos = service.getAll();

        return new ResponseEntity<List<Curso>>(listaCursos, HttpStatus.OK);
    }

    //ABAIXO ESTÁ O CÓDIGO PARA 'INSERT' DE NOVOS USUÁRIOS VIA HTTP REQUEST
    @PostMapping
    public ResponseEntity<Curso> postCurso(@RequestBody Curso curso){
        if (curso == null){
            return ResponseEntity.badRequest().build();
        }
        if (curso.getId() == 0){
            service.save(curso);
            return new ResponseEntity<Curso>(curso, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    //ABAIXO ESTÁ O CÓDIGO PARA 'UPDATE' DE NOVOS USUÁRIOS VIA HTTP REQUEST
    @PutMapping("/{id}") // demonstra que será necessário repassar o ID do usuário a ser atualizado no caminho http
    public ResponseEntity<Curso> putCurso (@PathVariable long id, @RequestBody Curso curso){ //recebe o ID de atualiação e o objeto usuário
        if (id <= 0 || curso == null){ //para o caso de IDs não válidos
            return ResponseEntity.badRequest().build();
        } 
        var cursoAntigo = service.getById(id);
        if (cursoAntigo==null){ //para o caso de IDs não nulos mas que não existem no banco
            return ResponseEntity.notFound().build(); 
        }

        // após validações, atualizaremos o usuário campo a campo com os novos dados(ou não)
        cursoAntigo.setTitulo(curso.getTitulo());
        cursoAntigo.setDescricao(curso.getDescricao());
        cursoAntigo.setConteudo(curso.getConteudo());

        service.save(cursoAntigo);
        return new ResponseEntity<Curso>(cursoAntigo,HttpStatus.OK); //salva no banco via service e retorna OK ao usuário
    }

	@DeleteMapping("/{id}")
    public ResponseEntity<Curso> deletecurso(@PathVariable long id){
        if(id <=0){
            return ResponseEntity.badRequest().build();
        }

        var cursoExcluido = service.getById(id);
        if(cursoExcluido == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);

        return new ResponseEntity<Curso>(cursoExcluido,HttpStatus.OK);
    }
}
