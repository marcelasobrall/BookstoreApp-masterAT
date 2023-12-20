package br.edu.infnet.BookstoreApp.model.service;

import java.util.Collection;

import br.edu.infnet.BookstoreApp.clients.IEnderecoClient;
import br.edu.infnet.BookstoreApp.model.domain.Endereco;
import br.edu.infnet.BookstoreApp.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.BookstoreApp.model.domain.Usuario;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private IEnderecoClient enderecoClient;

    public void incluir(Usuario usuario) {
        String cep = usuario.getEndereco().getCep();

        Endereco endereco = enderecoClient.buscarCep(cep);
        usuario.setEndereco(endereco);
        usuarioRepository.save(usuario);
    }
    public Usuario obterPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Collection<Usuario> obterLista() {
        return (Collection<Usuario>) usuarioRepository.findAll();
    }

    public void excluir(Integer id) {
        usuarioRepository.deleteById(id);
    }

}