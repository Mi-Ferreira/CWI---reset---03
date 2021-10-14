package br.com.cwi.reset.micheleferreira;

public class CamposPreenchimentoObrigatorioException extends Exception {
    public CamposPreenchimentoObrigatorioException (){
        super("Campo Obrigatorio não informado. Favor informar o campo");
    }
}
