package br.com.cwi.reset.micheleferreira;

public class idGeradorDiretor {
    private static int id = 0;

    public static Integer getProximoIdDiretor(){
        return id++;
    }

}
