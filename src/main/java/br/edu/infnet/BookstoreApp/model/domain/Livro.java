package br.edu.infnet.BookstoreApp.model.domain;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String titulo;
    private String autor;
    private String genero;
    private String sinopse;
    private BigDecimal preco;
	@OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
	private List<Avaliacao> avaliacoes;
	@ElementCollection
	private List<String> autores;
	@ElementCollection
	private List<String> generos;

	@OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
	private List<ItemDeCarrinho> itensCarrinho;;
    
 
    public Livro() {
        
    }

    public Livro(String titulo, String autor, String genero, String sinopse) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.sinopse = sinopse;
    }
    
    @Override
    public String toString() {
        return String.format("Livro: %s, ID: %s, Autor: %s, Gênero: %s, Preço: %.2f", id,titulo, autor, genero, preco);
    }

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}




	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public List<String> getAutores() {
		return autores;
	}

	public void setAutores(List<String> autores) {
		this.autores = autores;
	}

	public List<String> getGeneros() {
		return generos;
	}

	public void setGeneros(List<String> generos) {
		this.generos = generos;
	}
	 public void setItensCarrinho(List<ItemDeCarrinho> itensCarrinho) {
	        this.itensCarrinho = itensCarrinho;
	    }

	public void setPreco(double parseDouble) {
	}
}