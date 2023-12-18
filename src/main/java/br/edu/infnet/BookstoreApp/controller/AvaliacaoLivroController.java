package br.edu.infnet.BookstoreApp.controller;

import br.edu.infnet.BookstoreApp.model.domain.Avaliacao;
import br.edu.infnet.BookstoreApp.model.service.AvaliacaoLivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/avaliacao")
public class AvaliacaoLivroController {

    @Autowired
    private AvaliacaoLivroService avaliacaoLivroService;

    @GetMapping(value = "/listar")
    public List<Avaliacao> obterLista() {
        return (List<Avaliacao>) avaliacaoLivroService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Avaliacao avaliacao) {
        avaliacaoLivroService.incluir(avaliacao);
    }

    @GetMapping(value = "/{id}")
    public Avaliacao obterPorId(@PathVariable Integer id) {
        return avaliacaoLivroService.obterPorId(id);
    }
    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        avaliacaoLivroService.excluir(id);
    }
}