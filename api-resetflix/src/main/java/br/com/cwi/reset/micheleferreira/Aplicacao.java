package br.com.cwi.reset.micheleferreira;

import java.util.List;
import java.util.ArrayList;

public class Aplicacao {
    public static void main(String[] args) {
        FakeDataBase fakeDatabase = new FakeDataBase();
        AtorService atorService = new AtorService(fakeDatabase);

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
        catch(NomeeSobrenomeException f){
            System.out.println(f.getMessage());
        }
        catch(DataNascimentoInvalidaException g){
            System.out.println(g.getMessage());
        }
        catch(NomeeSobrenomeException h){
            System.out.println(h.getMessage());
        }
        catch(NomesIguaisInvalidoException i){
            System.out.println(i.getMessage());
        }

        Ator ator = new Ator(IdGeradorAtor.getProximoId(),atorRequest.getNome(),atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(),atorRequest.getAnoInicioAtividade());

        List<Ator> atores = fakeDatabase.recuperaAtores();

        System.out.println("Deve conter 1 ator, quantidade encontrada"+atores.size());
        System.out.println("Primeiro Ator deve ser Will Smith"+ atores.get(0).getNome());


    }
}