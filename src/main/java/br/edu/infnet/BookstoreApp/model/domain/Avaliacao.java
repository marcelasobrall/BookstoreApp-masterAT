package br.edu.infnet.BookstoreApp.model.domain;

import br.edu.infnet.BookstoreApp.model.service.LivroService;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Avaliacao {
    private static int contadorIds = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int avaliacao;
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Avaliacao() {
        this.id = contadorIds++;
    }

    public Avaliacao(int avaliacao, String comentario, Livro livro, Usuario cliente) {
        this();
        this.avaliacao = avaliacao;
        this.comentario = comentario;
        this.livro = livro;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        String livroTitulo = (livro != null) ? livro.getTitulo() : "(livro não especificado)";
        return String.format("Avaliação - Livro: %s, Avaliação: %d", livroTitulo, avaliacao);
    }

    public void associarLivroPorTitulo(String tituloLivro, LivroService livroService) {
        Livro livro = livroService.obterPorTitulo(tituloLivro);

        if (livro != null) {
            setLivro(livro);
        } else {
            System.err.println("Livro não encontrado para a avaliação: " + tituloLivro);
        }
    }


    public int getId() {
        return id;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
}