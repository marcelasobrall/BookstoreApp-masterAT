package br.edu.infnet.BookstoreApp.controller;

import br.edu.infnet.BookstoreApp.model.domain.Usuario;
import br.edu.infnet.BookstoreApp.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/listar")
    public List<Usuario> obterLista(){
        return (List<Usuario>) usuarioService.obterLista();
    }
    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Usuario usuario){
        usuarioService.incluir(usuario);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id){
        usuarioService.excluir(id);
    }
}
