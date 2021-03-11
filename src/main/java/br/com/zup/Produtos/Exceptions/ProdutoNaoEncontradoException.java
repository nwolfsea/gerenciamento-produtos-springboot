package br.com.zup.Produtos.Exceptions;

public class ProdutoNaoEncontradoException extends RuntimeException{
    public ProdutoNaoEncontradoException (){
        super ("Produto não encontrado!");
    }
}
