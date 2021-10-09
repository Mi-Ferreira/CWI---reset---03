package Exercicio_Aula02;

public enum Genero {
    MASCULINO("masculino"),
    FEMININO("feminino"),
    NAO_BINARIO("Não Binario");

    private String descricao;

    Genero(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
