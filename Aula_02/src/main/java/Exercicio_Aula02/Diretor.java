package Exercicio_Aula02;

import java.time.LocalDate;
import java.time.Period;


public class Diretor extends Pessoa {

    public Integer quantidadeFilmes;

    public Diretor(String nome, int dia, int mes, int ano, Genero genero, Integer quantidadeFilmes) {
        super(nome, dia, mes, ano, genero);
        this.quantidadeFilmes = quantidadeFilmes;
    }
}

