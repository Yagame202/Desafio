package Correcao;

import java.util.*;

public class SistemaAlunos {
	
	public static void calcularMediaGeral(ArrayList<Aluno> listaAlunos) {
		if(listaAlunos.isEmpty()) {
			System.out.println("Sem alunos");
			return;
		}
		double soma = 0;
		for(Aluno al : listaAlunos) {
			soma+=al.calcularMedia();
		}
		double mediaGeral = soma/listaAlunos.size();
		System.out.println("Média geral: " + mediaGeral);
		
	}
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ArrayList<Aluno> listaAlunos = new ArrayList<>();
		
		int opcao;
		
		do {
			System.out.println("-----Menu-----");
			System.out.println("1 - Cadastrar aluno");
			System.out.println("2 - Consultar aluno");
			System.out.println("3 - Calcular média geral");
			System.out.println("0 - Sair");
			opcao = entrada.nextInt();
			entrada.nextLine();
			switch(opcao) {
				case 1:
					if (listaAlunos.size() >= 5) {
						System.out.println("Limite de 5 alunos atingido");
						break;
					}
					System.out.print("Nome do aluno: ");
					String nome = entrada.nextLine();
					System.out.print("Digite a 1ª nota: ");
					double nota1 = entrada.nextDouble();
					System.out.print("Digite a 2ª nota: ");
					double nota2 = entrada.nextDouble();
					entrada.nextLine();
					
					Aluno novoAluno = new Aluno(nome, nota1, nota2);
					listaAlunos.add(novoAluno);
					System.out.println("Aluno cadastrado!");
					break;
				
				case 2: 
					System.out.println("Digite o aluno: ");
					String busca = entrada.nextLine();
					boolean encontrado = false;
					/*
					 laço de repetição que pega cada objeto 
					 aluno da lista de alunos e "joga" para 
					 a variável temporária 'a', 
					 para realizar alguma ação com ela
					*/
					for (Aluno a : listaAlunos) {
						if (busca.equalsIgnoreCase(a.nome)) {
							System.out.println("Média: " + a.calcularMedia());
							System.out.println("Situação: " + a.verificarSituacao());
							encontrado = true;
							break;
						}
					}
					if (!encontrado) {
						System.out.println("Não encontrado");
					}
					
					break;
					
				case 3:
					calcularMediaGeral(listaAlunos);
					break;
					
				case 0: 
					System.out.println("Saindo...");
					break;
				
				default:
					System.out.println("Opção inválida");
			}
		} while(opcao != 0);
	}

}
