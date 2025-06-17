package br.univille.projfabsoft.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoft.entity.Usuario;
import br.univille.projfabsoft.service.UsuarioService;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    //ABAIXO ESTÁ O CÓDIGO PARA 'SELECT' DE NOVOS USUÁRIOS VIA HTTP REQUEST
    @GetMapping 
    public ResponseEntity<List<Usuario>> getUsuarios(){
        var listaUsuarios = service.getAll();

        return new ResponseEntity<List<Usuario>>(listaUsuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}") //////////////// NECESSÁRIO ALTERAR EM TODOS OS OBJETOS
    public ResponseEntity<Usuario> getClienteId(@PathVariable Long id){
        var usuario = service.getById(id);

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    //ABAIXO ESTÁ O CÓDIGO PARA 'INSERT' DE NOVOS USUÁRIOS VIA HTTP REQUEST
    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario){
        if (usuario == null){
            return ResponseEntity.badRequest().build();
        }
        if (usuario.getId() == 0){
            service.save(usuario);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    //ABAIXO ESTÁ O CÓDIGO PARA 'UPDATE' DE NOVOS USUÁRIOS VIA HTTP REQUEST
    @PutMapping("/{id}") // demonstra que será necessário repassar o ID do usuário a ser atualizado no caminho http
    public ResponseEntity<Usuario> putUsuario (@PathVariable long id, @RequestBody Usuario usuario){ //recebe o ID de atualiação e o objeto usuário
        if (id <= 0 || usuario == null){ //para o caso de IDs não válidos
            return ResponseEntity.badRequest().build();
        } 
        var usuarioAntigo = service.getById(id);
        if (usuarioAntigo==null){ //para o caso de IDs não nulos mas que não existem no banco
            return ResponseEntity.notFound().build(); 
        }

        // após validações, atualizaremos o usuário campo a campo com os novos dados(ou não)
        usuarioAntigo.setNome(usuario.getNome());
        usuarioAntigo.setQualificacoes(usuario.getQualificacoes());
        usuarioAntigo.setEmail(usuario.getEmail());
        usuarioAntigo.setAreasDeInteresse(usuario.getAreasDeInteresse());
        usuarioAntigo.setHistoricoProfissional(usuario.getHistoricoProfissional());

        service.save(usuarioAntigo);
        return new ResponseEntity<Usuario>(usuarioAntigo,HttpStatus.OK); //salva no banco via service e retorna OK ao usuário
    }

	@DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable long id){
        if(id <=0){
            return ResponseEntity.badRequest().build();
        }

        var usuarioExcluido = service.getById(id);
        if(usuarioExcluido == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);

        return new ResponseEntity<Usuario>(usuarioExcluido,
                HttpStatus.OK);
    }
}
