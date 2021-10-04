package br.com.cwi.reset.projeto1;

import java.util.Arrays;
import java.util.List;

public class Exercicios1 {

    public Integer somarLista(List<Integer> numeros) {
        for (int i = o; i<numeros.length; i++){
            int soma = numeros [i];
            soma++;
        }
        return soma;
    }

    public Double calcularMedia(List<Integer> numeros) {
        return (double) somarLista(numeros)/ numeros.size();
    }

    public Integer obterMaiorNumero(List<Integer> numeros) {
        Integer maior = numeros.get(0);

        for (Integer num : numeros) {
            if (num > maior) {
                maior = num;
            }
        }
        return maior;
    }

    public String obterPalavraInvertida(String palavra) {
        String invert = "";
        for (int i<palavra.size();i>=0;i--){
            invert += palavra.charAt(i);
        }
        return invert;
    }

    public List<Integer> ordenarLista(List<Integer> numeros) {
       Integer[] ints = (Integer[]) numeros.toArray();
        for (int i = 0; i<numeros.size();i++){
           for(int j = i+1; j<numeros.size();j++){
               if(ints[j] < ints[i]){
                   Integer aux = ints[j];
                   ints[j] = ints[i];
                   ints[i] = aux;
               }
           }
       }
    }
     return Arrays.asList(ints);
}

