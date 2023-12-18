package br.edu.infnet.BookstoreApp.model.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import br.edu.infnet.BookstoreApp.repositories.CarrinhoDeComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.BookstoreApp.model.domain.CarrinhoDeCompras;

import javax.transaction.Transactional;


@Service
public class CarrinhoDeComprasService {

    @Autowired
    private CarrinhoDeComprasRepository carrinhoDeComprasRepository;

    public void incluir(CarrinhoDeCompras carrinho) {
        carrinhoDeComprasRepository.save(carrinho);
    }

    public Collection<CarrinhoDeCompras> obterLista() {
        return (Collection<CarrinhoDeCompras>) carrinhoDeComprasRepository.findAll();
    }

    public Optional<CarrinhoDeCompras> obterPorId(Integer id) {
        return carrinhoDeComprasRepository.findById(id);
    }

    public void excluir(Integer id) {
        carrinhoDeComprasRepository.deleteById(id);
    }
}