package Paciente;
import java.util.*;
public class Menu {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ArrayList<Paciente> listaPaciente = new ArrayList<>();
		int opcao = 0;
		do {
			System.out.println("\n--- MENU ---");
			System.out.println("1 - Registrar paciente ");
			System.out.println("2 - Ver evolução de paciente");
			System.out.println("3 - Ver índice médio de evolução");
			System.out.println("4 - Sair"); 
			
			opcao = entrada.nextInt();
			entrada.nextLine(); 
			
			switch (opcao) {
			case 1:
				if (listaPaciente.size() >= 8) {
				System.out.println("| Numero maximo de paciente cadastrados |");
				break;
				}
				System.out.println("Digite o nome do paciente:");
				String nome = entrada.nextLine();
				
				System.out.println("Digite a escala de dor do paciente de 0 a 10:");
				double reducaoDor = entrada.nextDouble();
				
				System.out.println("Digite a melhora na estabilidade do paciente de 0 a 10");
				double melhoraMobilidade = entrada.nextDouble();
				
				Paciente novoPaciente = new Paciente(nome, reducaoDor, melhoraMobilidade);
				listaPaciente.add(novoPaciente);
				System.out.println("Paciente cadastrado com sucesso!");
				
				break;
				
			case 2:
				if(listaPaciente.isEmpty()) {
					System.out.println("| Sem paciente cadastrado |");
				}else {
					System.out.println("Pacientes cadastrados" );
					for(Paciente novoPaciente1 : listaPaciente) {
						System.out.println(novoPaciente1.exibir2());
					}
				}break;
				
			case 3:
				if(listaPaciente.isEmpty()) {
					System.out.println("| Sem paciente cadastrado |");
				}else {
					System.out.println("Pacientes cadastrados" );
					for(Paciente novoPaciente1 : listaPaciente) {
						System.out.println(novoPaciente1.exibir());
					}
				}break;
			case 4:
				System.out.println("Você Saiu... ");
				System.exit(opcao);
				
			default:
				System.out.println("Opção inválida");
				break;
			}
			
		}while(opcao != 4);
		entrada.close();
	}

}
