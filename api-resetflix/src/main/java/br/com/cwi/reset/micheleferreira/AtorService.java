package br.com.cwi.reset.micheleferreira;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;


public class AtorService {

    public FakeDataBase fakeDataBase;

    public AtorService(FakeDataBase fakeDataBase) {
        this.fakeDataBase = fakeDataBase;
    }

    public void criarAtor(AtorRequest atorRequest) throws CamposPreenchimentoObrigatorioException, NomeeSobrenomeException,DataNascimentoInvalidaException, NomesIguaisInvalidoException  {
        if (atorRequest.getNome() == null ||atorRequest.getDataNascimento() == null || atorRequest.getStatusCarreira() ==null || atorRequest.getAnoInicioAtividade() ==null){
            throw new CamposPreenchimentoObrigatorioException();
        }
        if (atorRequest.getNome().indexOf(' ') == 0){
            throw new NomeeSobrenomeException();
        }
        if (!(atorRequest.getDataNascimento() <= LocalDate.now())){
            throw new DataNascimentoInvalidaException();
        }
        if (atorRequest.getNome().indexOf(' ') == 0){
            throw new NomeeSobrenomeException();
        }

        if (verificacaoAtorExiste()){
            throw new NomesIguaisInvalidoException();
        }

        fakeDataBase.persisteeAtor(ator);
    }

    public void consultarAtor()throws CampoObrigatorioIdException{
        if ( == null){
            throw new CampoObrigatorioIdException ();
        }
        return Ator.getNome();
    }

}
