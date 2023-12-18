package br.edu.infnet.BookstoreApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import br.edu.infnet.BookstoreApp.repositories.AvaliacaoLivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.BookstoreApp.model.domain.Avaliacao;

@Service
public class AvaliacaoLivroService {

    @Autowired
    private AvaliacaoLivroRepository avaliacaoRepository;

    public void incluir(Avaliacao avaliacao) {
        avaliacaoRepository.save(avaliacao);
    }

    public Collection<Avaliacao> obterLista() {
        return (Collection<Avaliacao>) avaliacaoRepository.findAll();
    }

    public Avaliacao obterPorId(Integer id) {
        return avaliacaoRepository.findById(id).orElse(null);
    }


    public void excluir(Integer id) {
        avaliacaoRepository.deleteById(id);
    }
}