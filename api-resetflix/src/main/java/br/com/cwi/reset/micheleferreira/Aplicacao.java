package br.com.cwi.reset.micheleferreira;

import java.util.List;
import java.util.ArrayList;

public class Aplicacao {
    public static void main(String[] args) {
        FakeDataBase fakeDatabase = new FakeDataBase();
        AtorService atorService = new AtorService(fakeDatabase);
        DiretorService diretorService = new DiretorService(fakeDatabase);

        //Ator
        String nome = "Will Smith";
        Integer dia = 25;
        Integer mes = 9;
        Integer ano = 1968;
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;


        AtorRequest atorRequest = new AtorRequest(nome, dia, mes,ano, statusCarreira, anoInicioAtividade);

        try{
            atorService.criarAtor(atorRequest);
        }
        catch(CamposPreenchimentoObrigatorioException e){
            System.out.println(e.getMessage());
        }

        catch(DataNascimentoInvalidaException e){
            System.out.println(e.getMessage());
        }
        catch(AnoInicioAtividadeInvalidoException e){
            System.out.println(e.getMessage());
        }
        catch(NomesIguaisInvalidoException e){
            System.out.println(e.getMessage());
        }

        Ator ator = new Ator(IdGeradorAtor.getProximoIdAtor(),atorRequest.getNome(),atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(),atorRequest.getAnoInicioAtividade());

        List<Ator> atores = fakeDatabase.recuperaAtores();

        System.out.println("Deve conter 1 ator, quantidade encontrada"+atores.size());
        System.out.println("Primeiro Ator deve ser Will Smith"+ atores.get(0).getNome());

    //Diretor
        String nome = "Will Smith";
        Integer dia = 25;
        Integer mes = 9;
        Integer ano = 1968;
        Integer anoInicioAtividade = 1986;

        DiretorRequest diretorRequest = new DiretorRequest(nome, dia, mes,ano, anoInicioAtividade);

        try{
            DiretorService.cadastrarDiretor(diretorRequest);
        }
        catch(CamposPreenchimentoObrigatorioException e){
            System.out.println(e.getMessage());
        }

        catch(DataNascimentoInvalidaException e1){
            System.out.println(e1.getMessage());
        }
        catch(AnoInicioAtividadeInvalidoException e2){
            System.out.println(e2.getMessage());
        }
        catch(NomesIguaisInvalidoException e3){
            System.out.println(e3.getMessage());
        }

        Diretor diretor = new Diretor(IdGeradorDiretor.getProximoIdDiretor(),diretorRequest.getNome(),diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        System.out.println("Deve conter 1 diretor, quantidade encontrada"+diretores.size());
        System.out.println("Primeiro Ator deve ser Will Smith"+ diretores.get(0).getNome());

}
