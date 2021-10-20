package br.com.cwi.reset.michele.service;

import br.com.cwi.reset.michele.exception.*;
import br.com.cwi.reset.michele.model.Ator;
import br.com.cwi.reset.michele.model.Estudio;
import br.com.cwi.reset.michele.model.StatusCarreira;
import br.com.cwi.reset.michele.request.AtorRequest;
import br.com.cwi.reset.michele.request.EstudioRequest;
import br.com.cwi.reset.michele.response.AtorEmAtividade;
import br.com.cwi.reset.michele.validator.FakeDatabase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        
        LocalDate dataAtual = LocalDate.now();
        if (dataAtual.isBefore(estudioRequest.getDataCriacao())){
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

    public List<Estudio> consultarEstudios() throws Exception {

        final List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        if (estudios.isEmpty()) {
            throw new ListaVaziaException();
        }
        String filtroNome= null;

        if (filtroNome != null) {
            final List<Estudio> retorno = new ArrayList<>();
            for (Estudio estudio : estudios) {
                final boolean containsFilter = estudio.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
                if (containsFilter) {
                    retorno.add(new Estudio(estudio.getId(), estudio.getNome(), estudio.getDescricao(), estudio.getDataCriacao(), estudio.getStatusAtividade());
                }
                else{
                throw new FiltroNomeNaoEncontrado("Estudio","Filtro");
                }
            }
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
                return estudio;
            }
        }

        throw new ConsultaIdInvalidoException();
    }

}
