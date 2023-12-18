package br.edu.infnet.BookstoreApp.model.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class CarrinhoDeCompras {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL)
	private List<ItemDeCarrinho> itens;

	@Column(precision = 10, scale = 2)
	private BigDecimal total;

	@OneToOne(mappedBy = "carrinho", cascade = CascadeType.ALL)
	private Usuario cliente;

	@OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL)
	private List<Pedido> pedidos;
    
   
    public CarrinhoDeCompras() {
       
    }
    public CarrinhoDeCompras(List<ItemDeCarrinho> itens, BigDecimal total, Usuario cliente) {
        this.itens = itens;
        this.total = total;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return String.format("Carrinho de Compras - ID:%s, Total: %.2f",id, total);
    }

	public List<ItemDeCarrinho> getItens() {
		return itens;
	}

	public void setItens(List<ItemDeCarrinho> itens) {
		this.itens = itens;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
}