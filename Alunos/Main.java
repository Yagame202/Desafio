package Alunos;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int escolha = 0;
        ArrayList<Cadastro> listaAlunos = new ArrayList<>(); // Lista de alunos

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Exibir alunos cadastrados");
            System.out.println("3 - Sair");
            System.out.print("Digite sua opção: ");
            escolha = entrada.nextInt();
            entrada.nextLine(); 

            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome do aluno: ");
                    String nome = entrada.nextLine();

                    System.out.print("Digite a nota 1 do aluno: ");
                    int nota1 = entrada.nextInt();

                    System.out.print("Digite a nota 2 do aluno: ");
                    int nota2 = entrada.nextInt();
                    entrada.nextLine(); 

                    Cadastro cadastro = new Cadastro(nome, nota1, nota2);
                    listaAlunos.add(cadastro); // Adiciona à lista
                    System.out.println("Aluno cadastrado com sucesso!");
                    break;

                case 2:
                    if (listaAlunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado ainda.");
                    } else {
                        System.out.println("\n--- Alunos Cadastrados ---");
                        for (Cadastro aluno : listaAlunos) {
                            System.out.println(aluno.exibir());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (escolha != 3);

        entrada.close();
    }
}


