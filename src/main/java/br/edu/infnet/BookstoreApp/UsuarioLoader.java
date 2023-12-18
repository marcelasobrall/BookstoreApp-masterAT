package br.edu.infnet.BookstoreApp;

import java.io.BufferedReader;
import java.io.FileReader;

import br.edu.infnet.BookstoreApp.model.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.BookstoreApp.model.domain.TipoUsuario;
import br.edu.infnet.BookstoreApp.model.domain.Usuario;
import br.edu.infnet.BookstoreApp.model.service.UsuarioService;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/usuarios.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        while (linha != null) {
            String[] campos = linha.split(";");

            Endereco endereco = new Endereco();

            Usuario usuario = new Usuario();
            usuario.setEmail(campos[0]);
            usuario.setSenha(campos[1]);
            usuario.setNome(campos[2]);
            usuario.setEndereco(new Endereco(campos[4]));

            String tipoUsuarioString = campos[3].toUpperCase().trim();

            if (TipoUsuario.exists(tipoUsuarioString)) {
                usuario.setTipo(TipoUsuario.valueOf(tipoUsuarioString));
            } else {

                System.out.println("Valor de TipoUsuario inválido: " + tipoUsuarioString);
                usuario.setTipo(TipoUsuario.CLIENTE);
            }
            usuarioService.incluir(usuario);

            linha = leitura.readLine();
        }

        for (Usuario usuario : usuarioService.obterLista()) {
            System.out.println("[USUÁRIO] " + usuario);

        }

        leitura.close();
    }
}