package br.com.cwi.reset.micheleferreira;

import java.time.LocalDate;

public class AtorRequest {
    private String nome;
    private LocalDate dataNascimento;
    private StatusCarreira statusCarreira;
    private Integer anoInicioAtividade;

    public AtorRequest(String nome, Integer dia, Integer mes, Integer ano, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento= LocalDate.of(ano, mes,dia);
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }

}
