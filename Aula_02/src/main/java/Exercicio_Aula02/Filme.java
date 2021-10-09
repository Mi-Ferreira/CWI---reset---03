package Exercicio_Aula02;

public class Filme {
    public Filme(String nome, String descricao, Integer duracao, Integer anoLancamento, Double avaliacao, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    private String nome;
    private String descricao;
    private Integer duracao;
    private Integer anoLancamento;
    private Double avaliacao;
    private Diretor diretor;




    public void reproduzir(){
        System.out.println("Nome Filme: "+nome);
        System.out.println("Descricao: "+descricao);
        System.out.println("Duracao: "+duracao);
        System.out.println("Diretor: "+diretor.getNome());

    }
}
