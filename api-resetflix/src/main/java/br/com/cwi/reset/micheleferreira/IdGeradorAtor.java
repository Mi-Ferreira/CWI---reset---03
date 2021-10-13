package br.com.cwi.reset.micheleferreira;

public class IdGeradorAtor {
    public static int id = 1;

    public static Integer getProximoId(){
        return id++;
    }
}
