package br.com.cwi.reset.micheleferreira;

import java.time.LocalDate;

public class Diretor {
    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private LocalDate anoInicioAtividade;

    public Diretor(int id, String nome, LocalDate dataNascimento, LocalDate anoInicioAtividade) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.anoInicioAtividade = anoInicioAtividade;
    }
}
