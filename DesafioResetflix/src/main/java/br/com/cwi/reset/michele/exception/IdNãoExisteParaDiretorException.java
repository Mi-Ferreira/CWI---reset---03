package br.com.cwi.reset.michele.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdN√£oExisteParaDiretorException extends Exception {
    public IdN√£oExisteParaDiretorException() {
        super("N√£o existe Diretor com esse id");
    }
}



