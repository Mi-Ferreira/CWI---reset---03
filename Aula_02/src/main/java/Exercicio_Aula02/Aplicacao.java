package Exercicio_Aula02;

public class Aplicacao {
    public static void main(String[] args) {
        Diretor diretor = new Diretor ("Jon Watts", 40,7);
        Filme f1 = new Filme ("Homem Aranha de volta ao Lar","SuperHeroi", 133,2017,5.0,diretor);
        f1.reproduzir();

        Filme f2 = new Filme ("Homem Aranha Longe de Casa","SuperHeroi", 250,2029,4.2,diretor);
        f2.reproduzir();

    }
}
