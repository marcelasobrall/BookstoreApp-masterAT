package br.edu.infnet.BookstoreApp.controller;

import br.edu.infnet.BookstoreApp.model.domain.CarrinhoDeCompras;
import br.edu.infnet.BookstoreApp.model.service.CarrinhoDeComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoDeComprasController {

    @Autowired
    private CarrinhoDeComprasService carrinhoDeComprasService;

    @GetMapping(value = "/listar")
    public Collection<CarrinhoDeCompras> obterLista() {
        return carrinhoDeComprasService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody CarrinhoDeCompras carrinho) {
        carrinhoDeComprasService.incluir(carrinho);
    }

    @GetMapping(value = "/{id}")
    public Optional<CarrinhoDeCompras> obterPorId(@PathVariable Integer id) {
        return carrinhoDeComprasService.obterPorId(id);
    }
    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        carrinhoDeComprasService.excluir(id);
    }
}