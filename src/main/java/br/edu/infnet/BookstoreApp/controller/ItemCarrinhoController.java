package br.edu.infnet.BookstoreApp.controller;

import br.edu.infnet.BookstoreApp.model.domain.ItemDeCarrinho;
import br.edu.infnet.BookstoreApp.model.service.ItemCarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/itemcarrinho")
public class ItemCarrinhoController {

    @Autowired
    private ItemCarrinhoService itemCarrinhoService;

    @GetMapping(value = "/listar")
    public Collection<ItemDeCarrinho> obterLista() {
        return itemCarrinhoService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody ItemDeCarrinho itemCarrinho) {
        itemCarrinhoService.incluir(itemCarrinho);
    }
    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        itemCarrinhoService.excluir(id);
    }
}