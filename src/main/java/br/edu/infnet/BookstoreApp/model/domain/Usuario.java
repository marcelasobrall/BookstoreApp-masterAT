package br.edu.infnet.BookstoreApp.model.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private String email;

	private String senha;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	private TipoUsuario tipo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carrinho_id", referencedColumnName = "id")
	private CarrinhoDeCompras carrinho;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Pedido> pedidos;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Avaliacao> avaliacoes;


    public Usuario() {
        
    }

    public Usuario(String nome, String email, String senha, TipoUsuario tipo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }


	@Override
	public String toString() {
		return String.format("Usuário: ID=%d, Nome=%s, Email=%s, Senha=%s, Tipo=%s",
				id, nome, email, senha, tipo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public CarrinhoDeCompras getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(CarrinhoDeCompras carrinho) {
		this.carrinho = carrinho;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}