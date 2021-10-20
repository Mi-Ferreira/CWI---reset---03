package br.com.cwi.reset.michele.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StatusAtividadenaoInformadoException extends Exception {
    public StatusAtividadenaoInformadoException() {
        super("Status Atividade não informado");}

}






