package br.com.zup.Produtos.Models;

import java.util.List;

public class Compras {
    private Cliente cliente;
    private List<Produto> produtos;

    public Compras() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
