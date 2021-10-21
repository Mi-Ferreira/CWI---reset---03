package br.com.cwi.reset.michele.service;

import br.com.cwi.reset.michele.exception.*;
import br.com.cwi.reset.michele.model.*;
import br.com.cwi.reset.michele.request.FilmeRequest;
import br.com.cwi.reset.michele.request.PersonagemRequest;
import br.com.cwi.reset.michele.validator.FakeDatabase;

import java.util.List;

public class FilmeService {
    private FakeDatabase fakeDatabase;
    private AtorService atorService;
    private DiretorService diretorService;
    private EstudioService estudioService;
    private PersonagemAtorService personagemAtorService;

    public FilmeService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
        this.atorService = new AtorService(FakeDatabase.getInstance());
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
        this.estudioService = new EstudioService(FakeDatabase.getInstance());
        this.personagemAtorService =new PersonagemAtorService(FakeDatabase.getInstance());
    }

    public void criarFilme(FilmeRequest filmeRequest) throws Exception {
        if (filmeRequest.getNome() == null) {
            throw new NomeNaoInformadoException();
        }

        if (filmeRequest.getAnoLancamento() == null) {
            throw new AnoLacamentoNaoInformadoException();
        }

        if (filmeRequest.getCapaFilme() == null) {
            throw new CapaFilmeNaoInformadoException();
        }

        if (filmeRequest.getGeneros() == null) {
            throw new GeneroNaoInformadoException();
        }

       DiretorService diretorService = new DiretorService();
        diretorService.consultarDiretor(filmeRequest.getIdDiretor());

        EstudioService estudioService = new EstudioService();
       estudioService.consultarEstudio(filmeRequest.getIdEstudio());


        if (filmeRequest.getResumo() == null) {
            throw new ResumoNaoInformadoException();
        }

        PersonagemAtorService personagemService = new PersonagemAtorService();
        personagemService.criarPersonagem();

        final List<Filme> filmes = fakeDatabase.recuperaFilmes();

        final Integer idGerado = filmes.size() + 1;

        final Filme filme = new Filme(idGerado, filmeRequest.getNome(), filmeRequest.getAnoLancamento(), filmeRequest.getCapaFilme(), filmeRequest.getGeneros(),filmeRequest.getCapaFilme(), filmeRequest.getCapaFilme(), estudioService.consultarEstudio(filmeRequest.getIdEstudio()), diretorService.consultarDiretor(filmeRequest.getIdDiretor()),personagemService.criarPersonagem(),filmeRequest.getResumo());

        fakeDatabase.persisteAtor(filme);


}
