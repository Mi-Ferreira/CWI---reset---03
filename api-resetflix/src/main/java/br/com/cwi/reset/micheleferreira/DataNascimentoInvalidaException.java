package br.com.cwi.reset.micheleferreira;

public class DataNascimentoInvalidaException extends Exception {
    public DataNascimentoInvalidaException  (){
        super("Não é possivel cadastrar atores não nascidos");
    }
}
