package br.edu.infnet.BookstoreApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.BookstoreApp.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.BookstoreApp.model.domain.Livro;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public void incluir(Livro livro) {
        livroRepository.save(livro);
    }

    public Livro obterPorTituloIgnoreCase(String titulo) {
        return livroRepository.findByTituloIgnoreCase(titulo);
    }

    public Collection<Livro> obterLista() {
        return (Collection<Livro>) livroRepository.findAll();
    }

    public Livro obterPorTitulo(String titulo) {
        return livroRepository.findByTitulo(titulo);
    }
    public void excluir(Integer id) {
        livroRepository.deleteById(id);
    }
}