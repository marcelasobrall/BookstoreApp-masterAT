package br.edu.infnet.BookstoreApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.BookstoreApp.model.domain.Avaliacao;
import br.edu.infnet.BookstoreApp.model.domain.Usuario;
import br.edu.infnet.BookstoreApp.model.service.AvaliacaoLivroService;
import br.edu.infnet.BookstoreApp.model.service.LivroService;
import br.edu.infnet.BookstoreApp.model.service.UsuarioService;

@Order(6)
@Component
public class AvaliacaoLivroLoader implements ApplicationRunner {

    @Autowired
    private AvaliacaoLivroService avaliacaoService;

    @Autowired
    private LivroService livroService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/avaliacoesLivro.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        while (linha != null) {
            String[] campos = linha.split(";");

            Avaliacao avaliacao = new Avaliacao();

            try {
                avaliacao.setAvaliacao(Integer.parseInt(campos[0]));
                avaliacao.setComentario(campos[1]);

                String tituloLivro = campos[3];


                avaliacao.associarLivroPorTitulo(tituloLivro, livroService);

                String emailCliente = campos[4];
                Usuario cliente = usuarioService.obterPorEmail(emailCliente);
                avaliacao.setCliente(cliente);

                avaliacaoService.incluir(avaliacao);
            } catch (NumberFormatException e) {
                System.err.println("Erro ao converter Avaliação para inteiro: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Erro ao processar linha: " + linha + ". Detalhes: " + e.getMessage());
                e.printStackTrace();
            }

            linha = leitura.readLine();
        }

        for (Avaliacao avaliacao : avaliacaoService.obterLista()) {
            System.out.println("[AVALIAÇÃO] " + avaliacao);
        }

        leitura.close();
    }
}