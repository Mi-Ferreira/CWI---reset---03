package Exercicio_Aula02;

public abstract class  Pessoa {

    private String nome;
    private Integer idade;
    private Genero genero;

    public Pessoa(String nome, Integer idade, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }
    public String getNome(){
        return nome;
    }

    public void imprimirInformacoes (){
        System.out.println("Nome "+nome);
        System.out.println("Idade "+idade);
        System.out.println("Genero "+genero.getDescricao());
    }


}
