package br.com.zup.Produtos.Exceptions;


import org.springframework.http.HttpStatus;

public class EmailRepetidoException extends RespostaDeErro {
    public EmailRepetidoException() {
        super(HttpStatus.BAD_REQUEST, "cliente", "E-mail do cliente já foi cadastrado no sistema");
    }
}