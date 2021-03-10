package br.com.zup.Produtos.Exceptions;

import org.springframework.http.HttpStatus;

public class CPFRepetidoException extends RespostaDeErro {
    public CPFRepetidoException() {
        super(HttpStatus.BAD_REQUEST, "cliente", "CPF repetido");
    }
}
