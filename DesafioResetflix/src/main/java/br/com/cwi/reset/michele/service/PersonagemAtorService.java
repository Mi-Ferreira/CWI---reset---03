package br.com.cwi.reset.michele.service;

import br.com.cwi.reset.michele.exception.*;
import br.com.cwi.reset.michele.request.PersonagemRequest;
import br.com.cwi.reset.michele.validator.FakeDatabase;

public class PersonagemAtorService {
    private final FakeDatabase fakeDatabase;
    private AtorService atorService;

    public PersonagemAtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
        this.atorService = new AtorService(fakeDatabase);
    }


    public PersonagemAtor criarPersonagem(PersonagemRequest personagemRequest) throws Exception {

        if (personagemRequest.getIdAtor() == null) {
            throw new IdNaoInformado();
        }

        if (personagemRequest.getNomePersonagem() == null) {
            throw new PersonagemNaoInformado();
        }

        if (personagemRequest.getDescricaoPersonagem() == null) {
            throw new DescricaoNaoInformadoException();
        }

        if (personagemRequest.getTipoAtuacao() == null) {
            throw new GeneroNaoInformadoException();
        }

        final Integer idGerado = fakeDatabase.recuperaPersonagens().size() + 1;

        final Ator ator = atorService.consultarAtor(personagemRequest.getIdAtor());

        final PersonagemAtor personagemAtor = new PersonagemAtor(idGerado, ator, personagemRequest.getNomePersonagem(), personagemRequest.getDescricaoPersonagem(), personagemRequest.getTipoAtuacao());

        fakeDatabase.persistePersonagem(personagemAtor);

        return personagemAtor;
    }


}
