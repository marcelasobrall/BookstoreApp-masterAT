package br.edu.infnet.BookstoreApp.model.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
public class Pedido {
	private static int proximoId = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dataPedido;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;
    @ManyToMany
    @JoinTable(name = "pedido_item",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<ItemDeCarrinho> itensCarrinho;

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private CarrinhoDeCompras carrinho;

    public Pedido() {
        this.id = proximoId++;
    }

    public Pedido(LocalDateTime dataPedido, StatusPedido status, Usuario cliente, List<ItemDeCarrinho> itensCarrinho) {
        this();
        this.dataPedido = dataPedido;
        this.status = status;
        this.cliente = cliente;
        this.itensCarrinho = itensCarrinho;
    }

    @Override
    public String toString() {
        return String.format("Pedido - ID:%s, Data: %s, Status: %s",id, dataPedido, status);
    }

    public int getId() {
        return id;
    }
    
    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public List<ItemDeCarrinho> getItensCarrinho() {
        return itensCarrinho;
    }

    public void setItensCarrinho(List<ItemDeCarrinho> itensCarrinho) {
        this.itensCarrinho = itensCarrinho;
    }
}