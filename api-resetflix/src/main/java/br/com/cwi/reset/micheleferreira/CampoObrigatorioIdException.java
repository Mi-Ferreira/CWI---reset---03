package br.com.cwi.reset.micheleferreira;

public class CampoObrigatorioIdException extends Exception{
    public  CampoObrigatorioIdException (){
        super("Campo Obrigatorio não informado. Favor informar o campo");
    }
}
