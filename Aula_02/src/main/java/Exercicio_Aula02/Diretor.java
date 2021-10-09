package Exercicio_Aula02;

public class Diretor {
    public String nome;
    public Integer idade;
    public Integer quantidadeFilmes;

    public Diretor(String nome, Integer idade, Integer quantidadeFilmes) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeFilmes = quantidadeFilmes;
    }

    public String getNome() {
        return nome;
    }
}
