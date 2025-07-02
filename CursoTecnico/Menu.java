package CursoTecnico;
import java.util.*;
public class Menu {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ArrayList<Cadastrar> listaCadastro = new ArrayList<>();
		
		int opcao = 0;
		
		do {
			
			System.out.println("\n--- MENU ---");
			System.out.println("1 - Cadastrar projeto ");
			System.out.println("2 - Ver evolução de projetos");
			System.out.println("3 - Ver índice de evolução um projeto");
			System.out.println("4 - Sair"); 
			
			opcao = entrada.nextInt();
			entrada.nextLine();
	
			switch(opcao) {
			
			case 1:
				if (listaCadastro.size() >= 5) {
					System.out.println("Número máximo de projetos cadastrados!");
					break;
				}

				System.out.println("Digite o nome do projeto:");
				String prjNome = entrada.nextLine();

				System.out.println("Digite o nome do responsável:");
				String rpNome = entrada.nextLine();

				System.out.println("Em qual estado seu projeto se encontra:");
				System.out.println("1 - Em andamento");
				System.out.println("2 - Concluído");
				System.out.println("3 - Pausado");

				int statusOpcao = entrada.nextInt();
				entrada.nextLine();

				String status = "";

				switch (statusOpcao) {
			case 1:
				status = "Em andamento";
				break;
			case 2:
				status = "Concluído";
				break;
			case 3:
				status = "Pausado";
				break;
				default:
				System.out.println("Opção inválida |.");
				status = "Desconhecido";
				break;
				}

				Cadastrar novoCadastro = new Cadastrar(prjNome, rpNome, status);
				listaCadastro.add(novoCadastro);

				System.out.println("Projeto cadastrado com sucesso!");
				break;

			case 2:
				if (listaCadastro.isEmpty()) {
				System.out.println("Lista vazia | você pode adicionar ");
				break;
				}else {
				System.out.println("Projeto cadastrados");
				for (Cadastrar novoCadastro1 : listaCadastro) {
					System.out.println(" | " + "Projetos: "+ novoCadastro1.escStatus());
					}
				}
				break;
			case 3:
				System.out.println("Digite o nome do projeto:");
				
				String buscaNome = entrada.nextLine();
				
				boolean encontrado = false;
				for(Cadastrar b : listaCadastro) {
				if (b.prjNome.equalsIgnoreCase(buscaNome)) {
					System.out.println("Projetos: " + b.escStatus());
					encontrado = true;
					break;
					}
				if (!encontrado) {
					System.out.println("| Projetos não encontrado |");
					}
				}
				break;
			case 4:
				System.out.println("Saindo...");
				System.exit(opcao);
				
				
				default:
				System.out.println("Opção inválida");
			}
			
			}while(opcao != 5);
		}
	}

