package br.com.cwi.reset.micheleferreira;

public class NomesIguaisInvalidoException extends Exception{
    public NomesIguaisInvalidoException(){
        super("Já existe nome cadastrado para o nome");
    }
}
