package br.edu.infnet.BookstoreApp.controller;

import br.edu.infnet.BookstoreApp.model.domain.Livro;
import br.edu.infnet.BookstoreApp.model.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping(value = "/listar")
    public Collection<Livro> obterLista() {
        return livroService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Livro livro) {
        livroService.incluir(livro);
    }

    @GetMapping(value = "/{titulo}")
    public Livro obterPorTitulo(@PathVariable String titulo) {
        return livroService.obterPorTitulo(titulo);
    }
    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        livroService.excluir(id);
    }
}