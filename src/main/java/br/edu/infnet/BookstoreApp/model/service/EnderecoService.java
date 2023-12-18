package br.edu.infnet.BookstoreApp.model.service;

import br.edu.infnet.BookstoreApp.clients.IEnderecoClient;
import br.edu.infnet.BookstoreApp.model.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class EnderecoService {

    @Autowired
    private IEnderecoClient enderecoClient;

    private final Collection<Endereco> listaEnderecos = new ArrayList<>();

    public Endereco buscarCep(String cep) {
        return enderecoClient.buscarCep(cep);
    }

    public Collection<Endereco> obterLista() {
        return listaEnderecos;
    }

    public Endereco obterPorId(Integer id) {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void incluir(Endereco endereco) {
        listaEnderecos.add(endereco);
    }

    public void atualizar(Integer id, Endereco endereco) {
        listaEnderecos.removeIf(e -> e.getId().equals(id));
        endereco.setId(id);
        listaEnderecos.add(endereco);
    }

    public void excluir(Integer id) {
        listaEnderecos.removeIf(endereco -> endereco.getId().equals(id));
    }
}