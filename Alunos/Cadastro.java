package Alunos;

public class Cadastro {
    String nome;
    private int nota1;
    private int nota2;

    public Cadastro(String nome, int nota1, int nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String exibir() {
        int media = (nota1 + nota2) / 2;
        String situacao;

        if (media >= 7) {
            situacao = "Aprovado";
        } else if (media >= 4) {
            situacao = "Recuperação";
        } else {
            situacao = "Reprovado";
        }

        return "Nome: " + nome + " | Média: " + media + " | Situação: " + situacao;
    }
}
