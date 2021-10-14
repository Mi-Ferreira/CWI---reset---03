package br.com.cwi.reset.micheleferreira;

import java.time.LocalDate;

public class DiretorService {

    private FakeDataBase fakeDataBase;

    public DiretorService(FakeDataBase fakeDataBase) {
        this.fakeDataBase = fakeDataBase;
    }

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws CamposPreenchimentoObrigatorioException, NomeeSobrenomeException,DataNascimentoInvalidaException, NomesIguaisInvalidoException  {
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
    }



}
