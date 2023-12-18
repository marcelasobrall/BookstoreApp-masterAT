package br.edu.infnet.BookstoreApp;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.BookstoreApp.model.domain.Livro;
import br.edu.infnet.BookstoreApp.model.service.LivroService;

@Order(3)
@Component
public class LivroLoader implements ApplicationRunner {

    @Autowired
    private LivroService livroService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/livros.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        while (linha != null) {
            String[] campos = linha.split(";");

            Livro livro = new Livro();
            livro.setTitulo(campos[0]);
            livro.setAutor(campos[1]);
            livro.setGenero(campos[2]);
            livro.setSinopse(campos[3]);
            livro.setPreco(Double.parseDouble(campos[4]));

            livroService.incluir(livro);

            linha = leitura.readLine();
        }

        for (Livro livro : livroService.obterLista()) {
            System.out.println("[LIVRO] " + livro);
        }

        leitura.close();
    }
}
