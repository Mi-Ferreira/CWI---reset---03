package br.com.cwi.reset.michele.service;

import br.com.cwi.reset.michele.FakeDatabase;
import br.com.cwi.reset.michele.exception.*;
import br.com.cwi.reset.michele.model.Ator;
import br.com.cwi.reset.michele.model.Diretor;
import br.com.cwi.reset.michele.model.StatusCarreira;
import br.com.cwi.reset.michele.request.AtorRequest;
import br.com.cwi.reset.michele.request.DiretorRequest;
import br.com.cwi.reset.michele.response.AtorEmAtividade;
import br.com.cwi.reset.michele.validator.FakeDatabase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws Exception {
        if (diretorRequest.getNome() == null) {
            throw new NomeNaoInformadoException();
        }

        if (diretorRequest.getDataNascimento() == null) {
            throw new DataNascimentoNaoInformadoException();
        }


        if (diretorRequest.getNome().split("").length <2) {
            throw new NomeSobrenomeObrigatorioException();
        }
        LocalDate dataAtual = LocalDate.now();
        if (dataAtual.isBefore(diretorRequest.getDataNascimento())){
            throw new NascidosNoFuturoException();
        }

        Integer anoNascimento = diretorRequest.getDataNascimento().getYear();
        if(diretorRequest.getAnoInicioAtividade()<anoNascimento){
            throw new AnoInicioAtividadeInvalidoException();
        }

        final List<Diretor> diretoresCadastrados = fakeDatabase.recuperaDiretores();

        for (Diretor diretorCadastrado : diretoresCadastrados) {
            if (diretorCadastrado.getNome().equalsIgnoreCase(diretorRequest.getNome())) {
                throw new CadastroDuplicadoException();
            }
        }

        final Integer idGerado = diretoresCadastrados.size() + 1;

        final Diretor diretor = new Diretor(idGerado, diretorRequest.getNome(), diretorRequest.getDataNascimento(),diretorRequest.getAnoInicioAtividade());

        fakeDatabase.persisteDiretor(diretor);

    }

    public List<Diretor> consultarDiretores() throws Exception {
        final List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        if (diretores.isEmpty()) {
            throw new ListaVaziaException();
        }

        return diretores;
    }
}
