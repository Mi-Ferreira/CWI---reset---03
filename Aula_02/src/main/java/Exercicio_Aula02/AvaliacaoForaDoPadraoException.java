package Exercicio_Aula02;

import java.time.LocalDate;
import java.time.Period;

public class AvaliacaoForaDoPadraoException extends Exception{

    public AvaliacaoForaDoPadraoException () {
        super("Essa nota esta fora do range 1 a 5");
    }
}
