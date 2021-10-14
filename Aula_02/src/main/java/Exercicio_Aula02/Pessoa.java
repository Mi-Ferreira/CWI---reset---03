package Exercicio_Aula02;

import java.time.LocalDate;
import java.time.Period;

public abstract class  Pessoa {

    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;



    public Pessoa(String nome, int dia, int mes, int ano, Genero genero) {
        this.nome = nome;
        this.dataNascimento = LocalDate.of(ano, mes,dia);
        this.genero = genero;
    }

    public String getNome(){
        return nome;
    }

    public LocalDate getDataNascimento(){
        return dataNascimento;
    }

    public void imprimirInformacoes (){
        System.out.println("Nome "+nome);
        System.out.println("Idade "+this.calcularIdade());
        System.out.println("Genero "+genero.getDescricao());
    }
    public Integer calcularIdade(){
        return Period.between(dataNascimento,LocalDate.now()).getYears();
                                                                  import java.time.Period;
    }                                              import java.time.Period;
}
