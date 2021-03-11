package br.com.zup.Produtos.Exceptions;

public class ProdutoRepetidoException extends RuntimeException {
    public ProdutoRepetidoException(){
        super("Produto repetido!");
    }
}
