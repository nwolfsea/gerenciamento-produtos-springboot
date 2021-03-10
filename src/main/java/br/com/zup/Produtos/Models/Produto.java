package br.com.zup.Produtos.Models;


public class Produto {
    private String nome;
    private Double preco;
    private int quantidade;

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto adicionarQuantidade(int quantidade){
        this.quantidade += quantidade;
        return this;
    }
}
