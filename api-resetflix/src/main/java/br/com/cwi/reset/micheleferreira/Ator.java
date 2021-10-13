package br.com.cwi.reset.micheleferreira;

import java.time.LocalDate;

public class Ator {
    private Integer id;
    private String nome;
    private LocalDate datanascimento;
    private StatusCarreira statusCarreira;
    private Integer anoInicioAtividade;

    public Ator(Integer id, String nome, LocalDate datanascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        this.id = id;
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public String getNome() {
        return nome;
    }

}

