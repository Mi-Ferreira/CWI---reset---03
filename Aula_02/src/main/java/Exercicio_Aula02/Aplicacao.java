package Exercicio_Aula02;

import java.util.List;
import java.util.ArrayList;


public class Aplicacao {
    public static void main(String[] args) {

        Diretor diretor = new Diretor("Jon Watts",01,10,1996, Genero.MASCULINO, 7);
        diretor.imprimirInformacoes();

        Ator ator = new Ator("Tom Holland",01,10,1980, Genero.MASCULINO, 7);
        ator.imprimirInformacoes();

           try {
                Filme filme = new Filme("Homem Aranha de volta ao Lar", "SuperHeroi", 133, 2017, 4.0, diretor);
           } catch (AvaliacaoForaDoPadraoException e) {
              System.out.print(e.getMessage());
            }


            try {
                Filme filme2 = new Filme("Homem Aranha Longe de Casa", "SuperHeroi", 250, 2029, 4.2, diretor);
            } catch (AvaliacaoForaDoPadraoException e) {
               System.out.print(e.getMessage());
           }


        List<Diretor> diretores = new ArrayList<>();
        diretores.add(diretor);

            for(int i=0;i<diretores.size();i++){
                System.out.println(diretores.get(i).getNome());
            }

    }
}
