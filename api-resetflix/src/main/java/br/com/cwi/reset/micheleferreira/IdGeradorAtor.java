package br.com.cwi.reset.micheleferreira;

public class IdGeradorAtor {
    private static int id = 0;

    public static Integer getProximoIdAtor(){
        return id++;
    }
}
