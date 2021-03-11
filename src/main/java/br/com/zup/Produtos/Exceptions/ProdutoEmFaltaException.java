package br.com.zup.Produtos.Exceptions;

public class ProdutoEmFaltaException extends RuntimeException{
    public ProdutoEmFaltaException(String nome){
        super("Produto em falta no sistema");
    }
}
