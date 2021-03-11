package br.com.zup.Produtos.Exceptions;

public class ProdutoNaoEncontradoException extends RuntimeException{

    public ProdutoNaoEncontradoException(String message) {
        super(message);
    }
}
