package Exercicio_Aula02;

import java.time.LocalDate;
import java.time.Period;

public class Aplicacao {
    public static void main(String[] args) {

        Diretor diretor = new Diretor("Jon Watts",01,10,1996, Genero.MASCULINO, 7);
        diretor.imprimirInformacoes();

        Ator ator = new Ator("Tom Holland",01,10,1980, Genero.MASCULINO, 7);
        ator.imprimirInformacoes();

        try{
            Filme filme= new Filme("Homem Aranha de volta ao Lar", "SuperHeroi", 133, 2017, 7.0, diretor);
        }
        catch (AvaliacaoForaDoPadraoException e){
            System.out.print(e.getMessage());
        }

       /* Filme f2 = new Filme("Homem Aranha Longe de Casa", "SuperHeroi", 250, 2029, 4.2, diretor);
        f2.reproduzir();*/


    }
}
