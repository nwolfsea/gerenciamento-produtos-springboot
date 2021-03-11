package br.com.zup.Produtos.Exceptions;


public class EmailRepetidoException extends RuntimeException {
    public EmailRepetidoException() {
        super("Email repetido!");
    }
}