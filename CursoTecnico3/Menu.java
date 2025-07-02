package CursoTecnico3;
import java.util.*;

public class Menu {

    // === CÓDIGOS ANSI ===
    public static final String RESET = "\u001B[0m";

    // Cor do texto
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // Fundo
    public static final String BG_BLACK = "\u001B[40m";
    public static final String BG_RED = "\u001B[41m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_PURPLE = "\u001B[45m";
    public static final String BG_CYAN = "\u001B[46m";
    public static final String BG_WHITE = "\u001B[47m";

    // Efeitos
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String REVERSED = "\u001B[7m";

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Cadastrar> listaCadastro = new ArrayList<>();
        int opcao = 0;

        do {
            System.out.println(BOLD + BG_BLUE + WHITE + "\n--- MENU ---" + RESET);
            System.out.println("1 - Cadastrar projeto");
            System.out.println("2 - Ver evolução de projetos");
            System.out.println("3 - Buscar projeto por nome ou responsável");
            System.out.println("4 - Sair");

            System.out.print(BOLD + "\nDigite sua opção: " + RESET);
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    if (listaCadastro.size() >= 5) {
                        System.out.println(BG_RED + WHITE + "Número máximo de projetos cadastrados!" + RESET);
                        break;
                    }

                    System.out.print("Digite o nome do projeto: ");
                    String prjNome = entrada.nextLine();

                    System.out.print("Digite o nome do responsável: ");
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

                    System.out.println(BG_GREEN + BLACK + BOLD + "Projeto cadastrado com sucesso!" + RESET);
                    break;

                case 2:
                    if (listaCadastro.isEmpty()) {
                        System.out.println(BG_RED + WHITE + "Lista vazia. Cadastre um projeto primeiro." + RESET);
                    } else {
                        System.out.println(BG_YELLOW + BLACK + BOLD + "--- Projetos Cadastrados ---" + RESET);
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

                    System.out.print("Digite o termo de busca: ");
                    String termoBusca = entrada.nextLine();

                    boolean achou = false;
                    for (Cadastrar c : listaCadastro) {
                        if ((tipoBusca == 1 && c.prjNome.equalsIgnoreCase(termoBusca)) ||
                            (tipoBusca == 2 && c.rpNome.equalsIgnoreCase(termoBusca))) {
                            System.out.println(BG_GREEN + BLACK + BOLD + "Projeto encontrado:" + RESET);
                            System.out.println(GREEN + c.escStatus() + RESET);
                            achou = true;
                        }
                    }

                    if (!achou) {
                        System.out.println(BG_RED + WHITE + "Nenhum projeto correspondente encontrado." + RESET);
                    }
                    break;

                case 4:
                    System.out.println(BG_PURPLE + WHITE + "Saindo... Até mais!" + RESET);
                    break;

                default:
                    System.out.println(BG_RED + WHITE + "Opção inválida. Tente novamente." + RESET);
            }

        } while (opcao != 4);
    }
}