package br.edu.infnet.BookstoreApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;

import br.edu.infnet.BookstoreApp.model.domain.ItemDeCarrinho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.BookstoreApp.model.domain.CarrinhoDeCompras;
import br.edu.infnet.BookstoreApp.model.service.CarrinhoDeComprasService;
import br.edu.infnet.BookstoreApp.model.service.UsuarioService;

@Order(4)
@Component
public class CarrinhoDeComprasLoader implements ApplicationRunner {

    @Autowired
    private CarrinhoDeComprasService carrinhoService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/carrinhos.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        while (linha != null) {
            String[] campos = linha.split(";");

            CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

            try {
                BigDecimal total = new BigDecimal(campos[1]);
                carrinho.setTotal(total);

                String emailCliente = campos[2];
                carrinho.setCliente(usuarioService.obterPorEmail(emailCliente));

                carrinhoService.incluir(carrinho);
            } catch (NumberFormatException e) {
                System.err.println("Erro ao converter Total para BigDecimal: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Erro ao processar linha: " + linha + ". Detalhes: " + e.getMessage());
                e.printStackTrace();
            }

            linha = leitura.readLine();
        }

        for (CarrinhoDeCompras carrinho : carrinhoService.obterLista()) {
            System.out.println("[CARRINHO DE COMPRAS] " + carrinho);
        }

        leitura.close();
    }
}