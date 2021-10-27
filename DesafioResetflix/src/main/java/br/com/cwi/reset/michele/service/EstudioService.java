package br.com.cwi.reset.michele.service;

import br.com.cwi.reset.michele.exception.*;
import br.com.cwi.reset.michele.request.EstudioRequest;
import br.com.cwi.reset.michele.validator.FakeDatabase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.util.Objects.isNull;

public class EstudioService {
    private final FakeDatabase fakeDatabase;

    public EstudioService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {
        if (estudioRequest.getNome() == null) {
            throw new NomeNaoInformadoException();
        }

        if (estudioRequest.getDescricao() == null) {
            throw new DescricaoNaoInformadoException();
        }

        if (estudioRequest.getDataCriacao() == null) {
            throw new DataCriacaoNaoInformadoException();
        }

        if (estudioRequest.getStatusAtividade() == null) {
            throw new StatusAtividadenaoInformadoException();
        }

        if (LocalDate.now().isBefore(estudioRequest.getDataCriacao())){
            throw new EstudioNoFuturoException();
        }
        
        final List<Estudio> estudiosCadastrados = fakeDatabase.recuperaEstudios();

        for (Estudio estudioCadastrado : estudiosCadastrados) {
            if (estudioCadastrado.getNome().equalsIgnoreCase(estudioRequest.getNome())) {
                throw new CadastroDuplicadoException();
            }
        }
        
        final Integer idGerado = estudiosCadastrados.size() + 1;

        final Estudio estudio = new Estudio(idGerado, estudioRequest.getNome(), estudioRequest.getDescricao(), (LocalDate) estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade());

        fakeDatabase.persisteEstudio(estudio);

    }

    public List<Estudio> consultarEstudios(String filtroNome) throws Exception {

        final List<Estudio> estudiosCadastrados = fakeDatabase.recuperaEstudios();
        final List<Estudio> estudios = new ArrayList<>();

        if (estudiosCadastrados.isEmpty()) {
            throw new ListaVaziaException();
        }

        if (!isNull(filtroNome)) {
            for (Estudio estudio : estudiosCadastrados) {
                if (estudio.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT))) {
                    estudios.add(estudio);
                }
            }
        } else {
            estudios.addAll(estudiosCadastrados);
        }

        if (estudios.isEmpty()) {
            throw new FiltroNomeNaoEncontrado("Estúdio", filtroNome);
        }

        return estudios;
    }

    public List<Estudio> consultarEstudio(Integer id) throws Exception {
        if (id == null) {
            throw new IdNaoInformado();
        }

        final List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        for (Estudio estudio : estudios) {
            if (estudio.getId().equals(id)) {
                return estudios;
            }
        }

        throw new ConsultaIdInvalidoException();
    }

}
