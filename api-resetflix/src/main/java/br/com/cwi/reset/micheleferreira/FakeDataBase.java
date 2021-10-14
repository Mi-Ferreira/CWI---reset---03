package br.com.cwi.reset.micheleferreira;

import java.util.ArrayList;
import java.util.List;

public class FakeDataBase {

    public List<Ator> atores = new ArrayList<>();
    public List<Diretor> diretores = new ArrayList<>();

    public boolean verificacaoAtorExiste(AtorRequest atorRequest){
        for(int i = 0;i< atores.size();i++){
            if (atores.get(i).toString()==atorRequest.getNome()) {
                return true;}
        }
    }

    public void persisteAtor(Ator ator) {
        atores.add(ator);
    }

    public List<Ator> recuperaAtores() {
        return atores;
    }

  public void persisteDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

  public List<Diretor> recuperaDiretores() {
        return diretores;
    }
}