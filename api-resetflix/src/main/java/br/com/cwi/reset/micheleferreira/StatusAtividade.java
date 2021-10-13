package br.com.cwi.reset.micheleferreira;

public enum StatusAtividade {
    EM_ATIVIDADE("Em atividade"),
    ENCERRADO("Encerrado");

    private String statusAtividade;

    StatusCarreira(String statusAtividade){
        this.statusAtividade = statusAtividade;
    }

    public String getStatusAtividade(){
        return statusAtividade;
    }
}
