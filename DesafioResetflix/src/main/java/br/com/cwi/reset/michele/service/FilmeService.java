package br.com.cwi.reset.michele.service;

import br.com.cwi.reset.michele.exception.*;
import br.com.cwi.reset.michele.model.*;
import br.com.cwi.reset.michele.request.FilmeRequest;
import br.com.cwi.reset.michele.request.PersonagemRequest;
import br.com.cwi.reset.michele.validator.FakeDatabase;

import java.util.*;

import static java.util.Objects.isNull;

public class FilmeService {
    private FakeDatabase fakeDatabase;
    private AtorService atorService;
    private DiretorService diretorService;
    private EstudioService estudioService;
    private PersonagemAtorService personagemAtorService;

    public FilmeService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
        this.atorService = new AtorService(fakeDatabase);
        this.diretorService = new DiretorService(fakeDatabase);
        this.estudioService = new EstudioService(fakeDatabase);
        this.personagemAtorService = new PersonagemAtorService(fakeDatabase);
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


        if (filmeRequest.getResumo() == null) {
            throw new ResumoNaoInformadoException();
        }

        final Set<Genero> generoSet = new HashSet<>();

        Filme filme = new Filme();
        for (Genero genero : filme.getGeneros()) {
            if (generoSet.contains(genero)) {
                throw new GeneroDuplicadoException();
            } else {
                generoSet.add(genero);
            }
        }

        PersonagemAtorService personagemAtorService = new PersonagemAtorService();


        final List<Filme> filmesCadastrados = fakeDatabase.recuperaFilmes();

        final Integer idGerado = filmesCadastrados.size() + 1;
        final Filme filme = new Filme(idGerado, filmeRequest.getNome(), filmeRequest.getAnoLancamento(), filmeRequest.getCapaFilme(), filmeRequest.getGeneros(), estudioService.consultarEstudio(filmeRequest.getIdEstudio()), diretorService.consultarDiretor(filmeRequest.getIdDiretor()), personagemAtorService.criarPersonagem(filmeRequest.getPersonagens()), filmeRequest.getResumo());

        fakeDatabase.persisteAtor(filme);
    }

    public List<Filme> consultarFilmes(
            String nomeFilme,
            String nomeDiretor,
            String nomePersonagem,
            String nomeAtor) throws Exception {
        final List<Filme> filmesCadastrados = fakeDatabase.recuperaFilmes();

        if (filmesCadastrados.isEmpty()) {
            throw new ListaVaziaException();
        }

        final List<Filme> filtrarNomePersonagem = filtrarNomePersonagem(filmesCadastrados, nomePersonagem);
        final List<Filme> filtrarNomeAtor = filtrarNomeAtor(filtrarNomePersonagem, nomeAtor);
        final List<Filme> filtrarNomeDiretor = filtrarNomeDiretor(filtrarNomeAtor, nomeDiretor);
        final List<Filme> filtroFinal = filtrarNomeFilme(filtrarNomeDiretor, nomeFilme);

        if (filtroFinal.isEmpty()) {
            throw new FiltroNomeNaoEncontrado();
        }
        return filtroFinal;

        private List<Filme> filtrarNomeFilme(final List<Filme> listaOriginal, final String nome){
            if (isNull(nome)) {
                return listaOriginal;
            }

            final List<Filme> filmeFiltrado = new ArrayList<>();

            for (Filme filme : listaOriginal) {
                if (filme.getNome().toLowerCase(Locale.ROOT).equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))) {
                    filmeFiltrado.add(filme);
                }
            }

            return filmeFiltrado;
        }

        private List<Filme> filtrarNomeDiretor ( final List<Filme> listaOriginal, final String nome){
            if (isNull(nome)) {
                return listaOriginal;
            }

            final List<Filme> filmeFiltrado = new ArrayList<>();

            for (Filme filme : listaOriginal) {
                if (filme.getDiretor().getNome().toLowerCase(Locale.ROOT).equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))) {
                    filmeFiltrado.add(filme);
                }
            }

            return filmeFiltrado;
        }

        private List<Filme> filtrarNomeAtor ( final List<Filme> listaOriginal, final String nome){
            if (isNull(nome)) {
                return listaOriginal;
            }

            final List<Filme> filmeFiltrado = new ArrayList<>();

            for (Filme filme : listaOriginal) {
                for (PersonagemAtor personagens : filme.getPersonagens()) {
                    if (personagens.getAtor().getNome().toLowerCase(Locale.ROOT).equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))) {
                        filmeFiltrado.add(filme);
                        break;
                    }
                }
            }

            return filmeFiltrado;
        }

        private List<Filme> filtrarNomePersonagem ( final List<Filme> listaOriginal, final String nome){
            if (isNull(nome)) {
                return listaOriginal;
            }

            final List<Filme> filmeFiltrado = new ArrayList<>();

            for (Filme filme : listaOriginal) {
                for (PersonagemAtor personagens : filme.getPersonagens()) {
                    if (personagens.getNomePersonagem()
                            .toLowerCase(Locale.ROOT)
                            .equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))
                    ) {
                        filmeFiltrado.add(filme);
                        break;
                    }
                }
            }

            return filmeFiltrado;
        }
    }
}