package br.com.cwi.reset.michele.service;


import br.com.cwi.reset.michele.exception.*;
import br.com.cwi.reset.michele.model.Ator;
import br.com.cwi.reset.michele.model.StatusCarreira;
import br.com.cwi.reset.michele.request.AtorRequest;
import br.com.cwi.reset.michele.response.AtorEmAtividade;

import br.com.cwi.reset.michele.validator.FakeDatabase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AtorService {

    private final FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarAtor(AtorRequest atorRequest) throws Exception {
        if (atorRequest.getNome() == null) {
            throw new NomeNaoInformadoException();
        }

        if (atorRequest.getDataNascimento() == null) {
            throw new DataNascimentoNaoInformadoException();
        }

        if (atorRequest.getStatusCarreira() == null) {
            throw new StatusCarreiraNaoInformadoException();
        }

        if (atorRequest.getNome().split("").length <2) {
            throw new NomeSobrenomeObrigatorioException();
        }
         LocalDate dataAtual = LocalDate.now();
        if (dataAtual.isBefore(atorRequest.getDataNascimento())){
            throw new NascidosNoFuturoException();
        }

        Integer anoNascimento = atorRequest.getDataNascimento().getYear();
        if(atorRequest.getAnoInicioAtividade()<anoNascimento){
            throw new AnoInicioAtividadeInvalidoException();
        }

        final List<Ator> atoresCadastrados = fakeDatabase.recuperaAtores();

        for (Ator atorCadastrado : atoresCadastrados) {
            if (atorCadastrado.getNome().equalsIgnoreCase(atorRequest.getNome())) {
                throw new CadastroDuplicadoException();
            }
        }



        final Integer idGerado = atoresCadastrados.size() + 1;

        final Ator ator = new Ator(idGerado, atorRequest.getNome(), atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());

        fakeDatabase.persisteAtor(ator);

    }

    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {
        final List<Ator> atoresCadastrados = fakeDatabase.recuperaAtores();

        if (atoresCadastrados.isEmpty()) {
            throw new ListaVaziaException();
        }

        final List<AtorEmAtividade> retorno = new ArrayList<>();

        if (filtroNome != null) {
            for (Ator ator : atoresCadastrados) {
                final boolean containsFilter = ator.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
                final boolean emAtividade = StatusCarreira.EM_ATIVIDADE.equals(ator.getStatusCarreira());
                if (containsFilter && emAtividade) {
                    retorno.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
                }
            }
        } else {
            for (Ator ator : atoresCadastrados) {
                final boolean emAtividade = StatusCarreira.EM_ATIVIDADE.equals(ator.getStatusCarreira());
                if (emAtividade) {
                    retorno.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
                }
            }
        }

        if (retorno.isEmpty()) {
            throw new FiltroNomeNaoEncontrado("Ator", filtroNome);
        }

        return retorno;
    }

    public Ator consultarAtor(Integer id) throws Exception {
        if (id == null) {
            throw new IdNaoInformado();
        }

        final List<Ator> atores = fakeDatabase.recuperaAtores();

        for (Ator ator : atores) {
            if (ator.getId().equals(id)) {
                return ator;
            }
        }

        throw new ConsultaIdInvalidoException();
    }

    public List<Ator> consultarAtores() throws Exception {
        final List<Ator> atores = fakeDatabase.recuperaAtores();

        if (atores.isEmpty()) {
            throw new ListaVaziaException();
        }

        return atores;
    }
}
