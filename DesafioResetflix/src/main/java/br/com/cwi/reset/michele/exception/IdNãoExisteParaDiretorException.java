package br.com.cwi.reset.michele.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdNãoExisteParaDiretorException extends Exception {
    public IdNãoExisteParaDiretorException() {
        super("Não existe Diretor com esse id");
    }
}



