package br.com.zup.Produtos.Exceptions;


public class EmailRepetidoException extends RuntimeException {

    public EmailRepetidoException(String message) {
        super(message);
    }
}