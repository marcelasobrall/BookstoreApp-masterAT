package br.edu.infnet.BookstoreApp;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.BookstoreApp.model.domain.ItemDeCarrinho;
import br.edu.infnet.BookstoreApp.model.domain.Livro;
import br.edu.infnet.BookstoreApp.model.service.ItemCarrinhoService;
import br.edu.infnet.BookstoreApp.model.service.LivroService;

@Order(5)
@Component
public class ItemDeCarrinhoLoader implements ApplicationRunner {

    @Autowired
    private ItemCarrinhoService itemCarrinhoService;

    @Autowired
    private LivroService livroService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/itensCarrinho.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        while (linha != null) {
            String[] campos = linha.split(";");

            ItemDeCarrinho itemCarrinho = new ItemDeCarrinho();

            Livro livro = livroService.obterPorTituloIgnoreCase(campos[1]);

            if (livro == null) {
                System.out.printf("Livro não encontrado: %s%n", campos[1]);
            } else {
                itemCarrinho.setLivro(livro);
                itemCarrinho.setQuantidade(Integer.parseInt(campos[2]));
                itemCarrinhoService.incluir(itemCarrinho);
            }

            linha = leitura.readLine();
        }


        for (ItemDeCarrinho itemCarrinho : itemCarrinhoService.obterLista()) {
            System.out.println("[ITEM DE CARRINHO] " + itemCarrinho);
        }

        leitura.close();
    }
}

