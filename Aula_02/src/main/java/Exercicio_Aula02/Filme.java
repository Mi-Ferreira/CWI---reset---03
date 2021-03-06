package Exercicio_Aula02;

import java.time.LocalDate;
import java.time.Period;

public class Filme {
    public Filme(String nome, String descricao, Integer duracao, Integer anoLancamento, Double avaliacao, Diretor diretor) throws AvaliacaoForaDoPadraoException {
        if (avaliacao<1 || avaliacao>5){
            throw new AvaliacaoForaDoPadraoException();
        }

        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String nome;
    private String descricao;
    private Integer duracao;
    private Integer anoLancamento;
    private Double avaliacao;
    private Diretor diretor;

    public String getNome(){
        return nome;
    }

    public void reproduzir(){
        System.out.println("Nome Filme: "+nome);
        System.out.println("Descricao: "+descricao);
        System.out.println("Duracao: "+duracao);
        System.out.println("Diretor: "+diretor.getNome());

    }
}
