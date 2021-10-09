package Exercicio_Aula02;

public class Ator extends Pessoa {
    public Integer numeroOscars;

    public Ator(String nome, Integer idade, Genero genero, Integer numeroOscars) {
        super(nome, idade, genero);
        this.numeroOscars = numeroOscars;
    }

}

