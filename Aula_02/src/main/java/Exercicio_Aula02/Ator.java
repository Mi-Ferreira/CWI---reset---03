package Exercicio_Aula02;

import java.time.LocalDate;
import java.time.Period;

public class Ator extends Pessoa {
    public Integer numeroOscars;

    public Ator(String nome, int dia, int mes, int ano, Genero genero, Integer numeroOscars) {
        super(nome, dia, mes, ano, genero);
        this.numeroOscars = numeroOscars;
    }
}

