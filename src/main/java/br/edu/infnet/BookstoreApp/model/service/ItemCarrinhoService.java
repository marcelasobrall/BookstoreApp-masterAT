package br.edu.infnet.BookstoreApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.BookstoreApp.repositories.ItemCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.BookstoreApp.model.domain.ItemDeCarrinho;

@Service
public class ItemCarrinhoService {

    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;

    public void incluir(ItemDeCarrinho itemCarrinho) {
        itemCarrinhoRepository.save(itemCarrinho);
    }

    public Collection<ItemDeCarrinho> obterLista() {
        return (Collection<ItemDeCarrinho>) itemCarrinhoRepository.findAll();
    }
    public void excluir(Integer id) {
        itemCarrinhoRepository.deleteById(id);
    }
}