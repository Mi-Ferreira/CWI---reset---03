package br.com.cwi.reset.micheleferreira;

public class NomeeSobrenomeException extends Exception{
    public NomeeSobrenomeException (){
        super ("Deve ser informado o nome e sobrenome para o ator");
    }
}
