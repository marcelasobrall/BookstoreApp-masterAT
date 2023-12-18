package br.edu.infnet.BookstoreApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.BookstoreApp.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.BookstoreApp.model.domain.Pedido;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public void incluir(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public Collection<Pedido> obterLista() {
        return (Collection<Pedido>) pedidoRepository.findAll();
    }

    public void excluir(Integer id) {
        pedidoRepository.deleteById(id);
    }
}
