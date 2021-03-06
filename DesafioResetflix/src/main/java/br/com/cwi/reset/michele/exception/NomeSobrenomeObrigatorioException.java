package br.com.cwi.reset.michele.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NomeSobrenomeObrigatorioException extends Exception {
    public NomeSobrenomeObrigatorioException() {
        super("Deve ser informado no mínimo nome e sobrenome");
    }
}
