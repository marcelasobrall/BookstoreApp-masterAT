package br.edu.infnet.BookstoreApp.controller;

import br.edu.infnet.BookstoreApp.model.domain.Pedido;
import br.edu.infnet.BookstoreApp.model.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping(value = "/listar")
    public Collection<Pedido> obterLista() {
        return pedidoService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Pedido pedido) {
        pedidoService.incluir(pedido);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        pedidoService.excluir(id);
    }
}