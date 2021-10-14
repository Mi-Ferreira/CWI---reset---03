package br.com.cwi.reset.micheleferreira;

public class AnoInicioAtividadeInvalidoException extends Exception{
    public AnoInicioAtividadeInvalidoException(){
        super("Ano de inicio da atividade inválido oara ator cadastrado");
    }
}
