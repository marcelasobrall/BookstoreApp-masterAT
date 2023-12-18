package br.edu.infnet.BookstoreApp.controller;

import br.edu.infnet.BookstoreApp.model.domain.Endereco;
import br.edu.infnet.BookstoreApp.model.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/listar")
    public Collection<Endereco> obterListaEnderecos() {
        return enderecoService.obterLista();
    }

    @GetMapping("/{id}")
    public Endereco obterEnderecoPorId(@PathVariable Integer id) {
        return enderecoService.obterPorId(id);
    }

    @PostMapping("/incluir")
    public void incluirEndereco(@RequestBody Endereco endereco) {
        enderecoService.incluir(endereco);
    }

    @PutMapping("/{id}/atualizar")
    public void atualizarEndereco(@PathVariable Integer id, @RequestBody Endereco endereco) {
        enderecoService.atualizar(id, endereco);
    }

    @DeleteMapping("/{id}/excluir")
    public void excluirEndereco(@PathVariable Integer id) {
        enderecoService.excluir(id);
    }
}

