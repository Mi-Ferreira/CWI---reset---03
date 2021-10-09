package Exercicio_Aula02;

public class Diretor extends Pessoa {

    public Integer quantidadeFilmes;

    public Diretor(String nome, Integer idade, Genero genero, Integer quantidadeFilmes) {
        super(nome, idade, genero);
        this.quantidadeFilmes = quantidadeFilmes;
    }

}

