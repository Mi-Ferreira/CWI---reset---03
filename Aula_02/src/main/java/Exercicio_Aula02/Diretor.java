package Exercicio_Aula02;

public class Diretor {
    private String nome;
    private Integer idade;
    private Integer quantidadeFilmes;
    private Genero genero;

    public Diretor(String nome, Integer idade, Integer quantidadeFilmes,Genero genero ) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeFilmes = quantidadeFilmes;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void imprimirInformacoes (){
        System.out.println("Nome "+nome);
        System.out.println("Idade "+idade);
        System.out.println("Genero "+genero.getDescricao());
    }
}
