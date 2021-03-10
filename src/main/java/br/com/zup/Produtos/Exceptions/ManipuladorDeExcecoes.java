package br.com.zup.Produtos.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ManipuladorDeExcecoes extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        RespostaDeErro respostaDeErro= new RespostaDeErro(
                "Validação de dados",
                status.value(),
                status.getReasonPhrase(),
                getObjetosDeErro(ex)
        );
        return ResponseEntity.status(status).body(respostaDeErro);
    }

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private List<ObjetoDeErro> getObjetosDeErro(MethodArgumentNotValidException ex) {
        List<ObjetoDeErro> objetoDeErros = ex.getBindingResult()
                .getFieldErrors().stream()
                .map(error -> new ObjetoDeErro(error.getDefaultMessage(), error.getField()))
                .collect(Collectors.toList());
        return objetoDeErros;
    }

}
