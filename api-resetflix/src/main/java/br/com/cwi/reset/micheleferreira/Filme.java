package br.com.cwi.reset.micheleferreira;

import java.util.ArrayList;
import java.util.List;

public class Filme {
    private Integer id;
    private String nome;
    private Integer anoLancamento;
    private String capaFilme;
    private List Genero = new ArrayList();
    Genero.add ("ACAO");
    Genero.add ("AVENTURA");
    Genero.add ("COMEDIA");
    Genero.add ("DOCUMENTARIO");
    Genero.add ("DRAMA");
    Genero.add ("ESPIONAGEM");
    Genero.add ("FICCAO CIENTIFICA");
    Genero.add ("GUERRA");
    Genero.add ("MISTERIO");
    Genero.add ("MUSICAL");
    Genero.add ("POLICIAL");
    Genero.add ("ROMANCE");
    Genero.add ("TERROR");
    private Diretor diretor;
    private PersonagemAtor personagens;
    private String resumo;
}
