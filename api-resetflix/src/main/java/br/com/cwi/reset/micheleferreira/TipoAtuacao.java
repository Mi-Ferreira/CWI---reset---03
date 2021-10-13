package br.com.cwi.reset.micheleferreira;

public enum TipoAtuacao {
    PRINCIPAL("Principal"),
    COADJUVANTE("Coadjuvante");

    private String tipoAtucao;

    TipoAtuacao(String tipoAtuacao){
        this.tipoAtuacao = tipoAtucao;
    }

    public String getTipoAtuacao(){
        return tipoAtuacao;
    }
}
