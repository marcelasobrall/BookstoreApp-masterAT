package br.edu.infnet.BookstoreApp.model.domain;

import javax.persistence.*;

@Entity
public class ItemDeCarrinho {
    private static int proximoId = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private CarrinhoDeCompras carrinho;
  
    public ItemDeCarrinho() {
        this.id = proximoId++;
      
    }
    public ItemDeCarrinho(Livro livro, int quantidade) {
        this();
        this.livro = livro;
        this.quantidade = quantidade;
    }
    
    @Override
    public String toString() {
        return String.format("Item - ID:%s, Livro: %s, Quantidade: %d",id, livro.getTitulo(), quantidade);
    }
    public int getId() {
        return id;
    }


	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}