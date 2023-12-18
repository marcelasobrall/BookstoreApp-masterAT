package br.edu.infnet.BookstoreApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.BookstoreApp.model.domain.ItemDeCarrinho;
import br.edu.infnet.BookstoreApp.model.domain.Pedido;
import br.edu.infnet.BookstoreApp.model.domain.StatusPedido;
import br.edu.infnet.BookstoreApp.model.domain.Usuario;
import br.edu.infnet.BookstoreApp.model.service.PedidoService;
import br.edu.infnet.BookstoreApp.model.service.UsuarioService;

@Order(2)
@Component
public class PedidoLoader implements ApplicationRunner {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/pedidos.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        while (linha != null) {
            String[] campos = linha.split(";");

            Pedido pedido = new Pedido();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

            try {
                pedido.setDataPedido(LocalDateTime.parse(campos[1], formatter));

                String statusString = campos[2].toUpperCase();
                StatusPedido statusPedido = StatusPedido.valueOf(statusString);
                pedido.setStatus(statusPedido);

                Usuario cliente = usuarioService.obterPorEmail(campos[3]);
                pedido.setCliente(cliente);

                List<ItemDeCarrinho> itensCarrinho = obterItensCarrinho(campos[0]);
                pedido.setItensCarrinho(itensCarrinho);

                pedidoService.incluir(pedido);
            } catch (DateTimeParseException e) {
                System.err.println("Erro ao fazer parsing da data. Formato inválido: " + campos[1]);
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                System.err.println("Erro ao converter StatusPedido: " + campos[2]);
                e.printStackTrace();
            }

            linha = leitura.readLine();
        }

        for (Pedido pedido : pedidoService.obterLista()) {
            System.out.println("[PEDIDO] " + pedido);
        }

        leitura.close();
    }


    private List<ItemDeCarrinho> obterItensCarrinho(String identificador) {

        return new ArrayList<>();
    }
}