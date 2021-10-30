package br.com.cwi.reset.projeto1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Exercicio1Test {
    @Test
    public void testSomaNumerosInteirosPositivos(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> soma = new ArrayList<>();
       soma.add(1);
       soma.add(2);
       soma.add(3);
       soma.add(4);
       soma.add(5);
       Integer expected = 15;

        // Action
        Integer result = exercicios.somarLista(soma);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSomaNumerosInteirosPositivosNegativos(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> soma2 = new ArrayList<>();
        soma2.add(1);
        soma2.add(2);
        soma2.add(3);
        soma2.add(4);
        soma2.add(-1);
        Integer expected = 9;

        // Action
        Integer result = exercicios.somarLista(soma2);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSomaNumerosInteirosNegativos(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> soma3 = new ArrayList<>();
        soma3.add(-1);
        soma3.add(-2);
        soma3.add(-3);

        Integer expected = -6;

        // Action
        Integer result = exercicios.somarLista(soma3);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSomaNumerosZero(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> soma4 = new ArrayList<>();
        soma4.add(0);
        soma4.add(0);
        soma4.add(0);

        Integer expected = 0;

        // Action
        Integer result = exercicios.somarLista(soma4);

        // Assert
        Assertions.assertEquals(expected, result);
    }


    @Test
    public void testSomaVazia(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> soma5 = new ArrayList<>();

        Integer expected = 0;

        // Action
        Integer result = exercicios.somarLista(soma5);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    //Media

    @Test
    public void testMediaNumerosInteirosPositivos(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> media = new ArrayList<>();
        media.add(1);
        media.add(2);
        media.add(3);
        media.add(4);
        media.add(5);
       Double expected = 3.0;

        // Action
       Double result = exercicios.calcularMedia(media);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMediaNumerosInteirosPositivosNegativos(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer>media2 = new ArrayList<>();
        media2.add(1);
        media2.add(2);
        media2.add(3);
        media2.add(4);
        media2.add(-1);
        Double expected = 1.8;

        // Action
        Double result = exercicios.calcularMedia(media2);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMediaNumerosInteirosNegativos(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> media3 = new ArrayList<>();
        media3.add(-1);
        media3.add(-2);
        media3.add(-3);

        Double expected = -2.0;

        // Action
       Double result = exercicios.calcularMedia(media3);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMediaNumerosZero(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> media4 = new ArrayList<>();
        media4.add(0);
        media4.add(0);
        media4.add(0);

        Double expected = 0.0;

        // Action
       Double result = exercicios.calcularMedia(media4);

        // Assert
        Assertions.assertEquals(expected, result);
    }


    @Test
    public void testMediaVazia(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> media5 = new ArrayList<>();

     Double expected = null;

        // Action
       Double result = exercicios.calcularMedia(media5);

        // Assert
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void testInvertePalavra() {
        // Arrange
       Exercicios1 exercicios = new Exercicios1();
        String palavra1 = "abacate";
        String expected1 = "etacaba";
        String palavra2 = "banana";
        String expected2 = "ananab";
        String palavra3= "pessego";
        String expected3 = "ogessep";
        String palavra4="morango";
        String expected4 = "ognarom";

        // Action
        String result1 = exercicios.obterPalavraInvertida(palavra1);
        String result2 = exercicios.obterPalavraInvertida(palavra2);
        String result3 = exercicios.obterPalavraInvertida(palavra3);
        String result4 = exercicios.obterPalavraInvertida(palavra4);
        // Assert
        Assertions.assertEquals(expected1, result1);
        Assertions.assertEquals(expected2, result2);
        Assertions.assertEquals(expected3, result3);
        Assertions.assertEquals(expected4, result4);
    }
}
