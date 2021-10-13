package br.com.cwi.reset.micheleferreira;

public class AtorService {

    private FakeDataBase fakeDataBase;
    public AtorService(FakeDataBase fakeDataBase) {
        this.fakeDataBase = fakeDataBase;
    }

    public void criarAtor(){

        Ator.getId();
    }


}
