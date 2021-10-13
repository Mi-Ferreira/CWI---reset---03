package br.com.cwi.reset.micheleferreira;

import java.time.LocalDate;

public class AtorService {

    public FakeDataBase fakeDataBase;
    public Ator ator;

    public AtorService(FakeDataBase fakeDataBase) {
        this.fakeDataBase = fakeDataBase;
    }

    public void criarAtor(AtorRequest atorRequest) {
    }
}
