package Livro;

import java.util.*;

public class Menu {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ArrayList<Livro> listaLivro = new ArrayList<>();
		int opcao = 0;

		do {
			System.out.println("\n--- MENU ---");
			System.out.println("1 - Cadastrar novo Livro ");
			System.out.println("2 - Mostrar todos os livros cadastrados");
			System.out.println("3 - Consultar dados de livro por titulo");
			System.out.println("4 - Ver quantos livros foram cadastrados antes de 2010");
			System.out.println("5 - Sair");

			opcao = entrada.nextInt();
			entrada.nextLine();

			switch (opcao) {

				case 1:
					if (listaLivro.size() >= 10) {
						System.out.println("Número máximo de livros cadastrados!!");
						break;
					}
					System.out.println("Digite o nome do livro:");
					String titulo = entrada.nextLine();

					System.out.println("Digite o autor do livro:");
					String autor = entrada.nextLine();

					System.out.println("Digite o ano do livro:");
					int ano = entrada.nextInt();

					Livro novoLivro = new Livro(titulo, autor, ano);
					listaLivro.add(novoLivro);
					System.out.println("Novo Livro cadastrado com sucesso!");
					break;

				case 2:
					if (listaLivro.isEmpty()) {
						System.out.println("| Nenhum livro cadastrado |");
					} else {
						System.out.println("| Lista de Livros cadastrados |");
						for (Livro novoLivro1 : listaLivro) {
							System.out.println(novoLivro1.mostrar());
						}
					}
					break;

				case 3:
					System.out.println("Dados de Livro |");
					if (listaLivro.isEmpty()) {
						System.out.println("| Nenhum Livro encontrado |");
					} else {
						System.out.println("Digite o título do livro que deseja consultar:");
						String tituloBusca = entrada.nextLine();

						boolean encontrado = false;

						for (Livro q : listaLivro) {
							if (q.titulo.equalsIgnoreCase(tituloBusca)) {
								System.out.println("Livro encontrado:");
								System.out.println(q.mostrar());
								encontrado = true;
								break;
							}
						}

						if (!encontrado) {
							System.out.println("Livro '" + tituloBusca + "' não encontrado.");
						}
					}
					break;
					
				case 4:
					System.out.println("Livros cadastrados (| Quantidade  e Nome |) antes de '2010' ");
					int quantidade = 0;
					for(Livro q : listaLivro){
					if(q.ano < 2010){
						quantidade++;
						}
					}
					System.out.println("Quantidade cadastrados Livros" + "|" + quantidade + "|");
					break;
				case 5:
					System.out.println("Você Saiu...");
					System.exit(opcao);
				default:
					System.out.println("Opção inválida | Escolha uma opção valida!");
			}
		} while (opcao != 5);
	}
}

	
