package br.com.cwi.reset.micheleferreira;

import java.time.LocalDate;

public class DiretorRequest {
    private String nome;
    private LocalDate dataNascimento;
    private Integer anoInicioAtividade;

    public DiretorRequest (String nome, Integer dia, Integer mes, Integer ano, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento= LocalDate.of(ano, mes,dia);
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }
}
