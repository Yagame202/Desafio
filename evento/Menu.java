package evento;
import java.util.*;

public class Menu {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ArrayList<Registro> listaCadastro = new ArrayList<>();
		int opcao = 0;
		
		do {
			System.out.println(" 1 |Cadastro de participantes | Limite (15) |");
			System.out.println(" 2 |Consulte um participante específico informando o e-mail |");
			System.out.println(" 3 |Consultar média de horas dos participantes |");

			opcao = entrada.nextInt(); 
			entrada.nextLine();

			switch (opcao) {
				case 1:
					if (listaCadastro.size() >= 15) { 
						System.out.println("| Número máximo de participantes cadastrados |");
						break;
					}
					System.out.println("| Digite seu nome: |");
					String nome = entrada.nextLine();

					System.out.println("| Digite seu email: |");
					String email = entrada.nextLine();

					System.out.println("| Digite a sua quantidade de horas de participação: |");
					double qtdhora = entrada.nextDouble();
					entrada.nextLine();
					Registro novoRegistro = new Registro(nome, email, qtdhora);
					listaCadastro.add(novoRegistro);
					System.out.println("\n| Participante cadastrado com sucesso! |");
					break;
					
				case 2:
					System.out.println("Digite abaixo");
					if (listaCadastro.isEmpty()) {
						System.out.println("\n|'Sem participantes cadastrados'|");
						break;
					}else {
					System.out.println("Digite o email do participante");
					String buscaEmail = entrada.nextLine();
					
					boolean encontrado = false;
					
					for(Registro c : listaCadastro) {
						if (c.email.equalsIgnoreCase(buscaEmail)) {
							System.out.println("Participante encontrado");
							System.out.println(c.exibir());
							System.out.println(c.direitoCertificado());
							encontrado = true;
							break;
							}
						}
					if (!encontrado) {
						System.out.println("Participante não encontrado");	
						}
					}
					break;
					
				case 3:
					if (listaCadastro.isEmpty()) {
					System.out.println("\nNão foi possivel encontrar Participantes");
					break;
					}else {
						double somaHoras  = 0;
						for(Registro c : listaCadastro) {
							somaHoras += c.qtdhora;
						}
						double media = (somaHoras / listaCadastro.size());
						System.out.printf("Média de horas dos participantes:" + media);
						
						
					}	
			}
		} while (opcao != 4); 
	}
}
