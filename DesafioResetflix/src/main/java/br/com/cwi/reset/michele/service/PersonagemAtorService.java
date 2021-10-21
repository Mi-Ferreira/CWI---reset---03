package br.com.cwi.reset.michele.service;

import br.com.cwi.reset.michele.exception.IdNaoInformado;
import br.com.cwi.reset.michele.exception.IdNãoExisteEstudioException;
import br.com.cwi.reset.michele.exception.NaoExisteIdAtorException;
import br.com.cwi.reset.michele.exception.NomeNaoInformadoException;
import br.com.cwi.reset.michele.model.Ator;
import br.com.cwi.reset.michele.model.Estudio;
import br.com.cwi.reset.michele.model.PersonagemAtor;
import br.com.cwi.reset.michele.request.AtorRequest;
import br.com.cwi.reset.michele.request.PersonagemRequest;
import br.com.cwi.reset.michele.validator.FakeDatabase;

import java.util.ArrayList;
import java.util.List;

public class PersonagemAtorService {
    private final FakeDatabase fakeDatabase;

    public PersonagemAtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }


    public void criarPersonagem(PersonagemRequest personagemRequest) throws Exception {

        AtorService atorService = new AtorService();
        atorService.consultarAtor(personagemRequest.getIdAtor());

        final List<PersonagemAtor> personagens = fakeDatabase.recuperaPersonagens();

        final Integer idGerado = personagens.size() + 1;

        final PersonagemAtor personagemAtor = new PersonagemAtor(idGerado,atorService.consultarAtor(personagemRequest.getIdAtor()), personagemRequest.getNomePersonagem(), personagemRequest.getDescricaoPersonagem(), personagemRequest.getTipoAtuacao());

        fakeDatabase.persistePersonagem(personagemAtor);

}
