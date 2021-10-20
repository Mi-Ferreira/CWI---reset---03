package br.com.cwi.reset.michele.service;

import br.com.cwi.reset.michele.exception.*;
import br.com.cwi.reset.michele.model.Ator;
import br.com.cwi.reset.michele.request.AtorRequest;
import br.com.cwi.reset.michele.request.FilmeRequest;

public class FilmeService {

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

        if (filmeRequest.getIdDiretor() == null) {
            throw new IdNaoInformado();
        }

        if (filmeRequest.getIdEstudio() == null) {
            throw new IdNaoInformado();
        }

        if (filmeRequest.getPersonagens()== null) {
            throw new IdNaoInformado();
        }

}
