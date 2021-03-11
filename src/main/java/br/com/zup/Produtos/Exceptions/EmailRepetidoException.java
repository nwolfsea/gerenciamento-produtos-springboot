package br.com.zup.Produtos.Exceptions;


import org.springframework.http.HttpStatus;

public class EmailRepetidoException extends RuntimeException {
    public EmailRepetidoException() {
        super("Email repetido!");
    }
}