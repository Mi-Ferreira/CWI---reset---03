package br.com.cwi.reset.michele.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResumoNaoInformadoException extends Exception{
    public ResumoNaoInformadoException() {
        super("Resumo não informado");
    }
}





