package CursoTecnico2;
import java.util.*;

public class Menu {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Cadastrar> listaCadastro = new ArrayList<>();
        int opcao = 0;

        do {
            System.out.println(BLUE + "\n--- MENU ---" + RESET);
            System.out.println("1 - Cadastrar projeto");
            System.out.println("2 - Ver evolução de projetos");
            System.out.println("3 - Buscar projeto por nome ou responsável");
            System.out.println("4 - Sair");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    if (listaCadastro.size() >= 5) {
                        System.out.println(RED + "Número máximo de projetos cadastrados!" + RESET);
                        break;
                    }

                    System.out.println("Digite o nome do projeto:");
                    String prjNome = entrada.nextLine();

                    System.out.println("Digite o nome do responsável:");
                    String rpNome = entrada.nextLine();

                    System.out.println("Estado do projeto:");
                    System.out.println("1 - Em andamento");
                    System.out.println("2 - Concluído");
                    System.out.println("3 - Pausado");

                    int statusOpcao = entrada.nextInt();
                    entrada.nextLine();

                    String status = switch (statusOpcao) {
                        case 1 -> "Em andamento";
                        case 2 -> "Concluído";
                        case 3 -> "Pausado";
                        default -> "Desconhecido";
                    };

                    Cadastrar novoCadastro = new Cadastrar(prjNome, rpNome, status);
                    listaCadastro.add(novoCadastro);

                    System.out.println(GREEN + "Projeto cadastrado com sucesso!" + RESET);
                    break;

                case 2:
                    if (listaCadastro.isEmpty()) {
                        System.out.println(RED + "Lista vazia. Cadastre um projeto primeiro." + RESET);
                    } else {
                        System.out.println(YELLOW + "--- Projetos Cadastrados ---" + RESET);
                        for (Cadastrar c : listaCadastro) {
                            System.out.println(CYAN + c.escStatus() + RESET);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Deseja buscar por:");
                    System.out.println("1 - Nome do projeto");
                    System.out.println("2 - Nome do responsável");

                    int tipoBusca = entrada.nextInt();
                    entrada.nextLine();

                    System.out.println("Digite o termo de busca:");
                    String termoBusca = entrada.nextLine();

                    boolean achou = false;
                    for (Cadastrar c : listaCadastro) {
                        if ((tipoBusca == 1 && c.prjNome.equalsIgnoreCase(termoBusca)) ||
                            (tipoBusca == 2 && c.rpNome.equalsIgnoreCase(termoBusca))) {
                            System.out.println(GREEN + "Projeto encontrado:\n" + c.escStatus() + RESET);
                            achou = true;
                        }
                    }

                    if (!achou) {
                        System.out.println(RED + "Nenhum projeto correspondente encontrado." + RESET);
                    }
                    break;

                case 4:
                    System.out.println(PURPLE + "Saindo... Obrigado por usar o sistema!" + RESET);
                    break;

                default:
                    System.out.println(RED + "Opção inválida. Tente novamente." + RESET);
            }

        } while (opcao != 4);
    }
}
