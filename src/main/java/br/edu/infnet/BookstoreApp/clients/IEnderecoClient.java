package br.edu.infnet.BookstoreApp.clients;

import br.edu.infnet.BookstoreApp.model.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoClient")
public interface IEnderecoClient {

    @GetMapping(value = "/{cep}/json/")
    public Endereco buscarCep(@PathVariable String cep);
}