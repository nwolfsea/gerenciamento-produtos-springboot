package br.com.zup.Produtos.Exceptions;

import org.springframework.http.HttpStatus;

public class CPFRepetidoException extends RuntimeException {
    public CPFRepetidoException() {
        super("CPF repetido!");
    }
}
