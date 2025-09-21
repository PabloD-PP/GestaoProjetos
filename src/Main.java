import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalDate;

// Classe principal que gerencia usuários, projetos e equipes
// Contém o menu de interação com o usuário

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Projeto> projetos = new ArrayList<>();
    private static List<Equipe> equipes = new ArrayList<>();
    private static DateTimeFormatter fomartador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        int opcao;

        // Loop principal
        do {
            System.out.println("\n==== Sistema de Gestão de Projetos ====");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Listar Usuários");
            System.out.println("3. Cadastrar Projeto");
            System.out.println("4. Listar Projetos");
            System.out.println("5. Cadastrar Equipe");
            System.out.println("6. Listar Equipes");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrarUsuario();
                case 2 -> listarUsuarios();
                case 3 -> cadastrarProjeto();
                case 4 -> listarProjetos();
                case 5 -> cadastrarEquipe();
                case 6 -> listarEquipes();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        sc.close();
    }

    // Método para cadastrar um novo usuário
    private static void cadastrarUsuario() {
        System.out.print("Nome completo: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("E-mail: ");
        String email = sc.nextLine();
        System.out.print("Cargo: ");
        String cargo = sc.nextLine();
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        System.out.print("Perfil (administrador/gerente/colaborador): ");
        String perfil = sc.nextLine();

        usuarios.add(new Usuario(nome, cpf, email, cargo, login, senha, perfil));
        System.out.println("Usuário cadastrado com sucesso!");
    }

    // Método para listar usuários
    private static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            usuarios.forEach(System.out::println);
        }
    }

    // Método para cadastrar um novo projeto
    private static void cadastrarProjeto() {
        if (usuarios.isEmpty()) {
            System.out.println("Cadastre ao menos um usuário para ser gerente.");
            return;
        }
        System.out.print("Nome do projeto: ");
        String nome = sc.nextLine();
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();
        System.out.print("Data de início (DD/MM/AAAA): ");
        LocalDate inicio = LocalDate.parse(sc.nextLine(), fomartador);
        System.out.print("Data de término prevista (DD/MM/AAAA): ");
        LocalDate fim = LocalDate.parse(sc.nextLine(), fomartador);
        System.out.print("Status (planejado/em andamento/concluído/cancelado): ");
        String status = sc.nextLine();

        System.out.println("Escolha o gerente pelo índice:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(i + " - " + usuarios.get(i).getNomeCompleto() + " (" + usuarios.get(i).getPerfil() + ")");
        }
        int idx = sc.nextInt();
        sc.nextLine();
        Usuario gerente = usuarios.get(idx);

        projetos.add(new Projeto(nome, descricao, inicio, fim, status, gerente));
        System.out.println("Projeto cadastrado com sucesso!");
    }

    // Método para listar projetos
    private static void listarProjetos() {
        if (projetos.isEmpty()) {
            System.out.println("Nenhum projeto cadastrado.");
        } else {
            projetos.forEach(System.out::println);
        }
    }

    // Método para cadastrar uma nova equipe
    private static void cadastrarEquipe() {
        System.out.print("Nome da equipe: ");
        String nome = sc.nextLine();
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        Equipe equipe = new Equipe(nome, descricao);
        if (!usuarios.isEmpty()) {
            System.out.println("Adicionar membros (digite -1 para parar):");
            for (int i = 0; i < usuarios.size(); i++) {
                System.out.println(i + " - " + usuarios.get(i).getNomeCompleto());
            }
            while (true) {
                int idx = sc.nextInt();
                sc.nextLine();
                if (idx == -1) break;
                equipe.adicionarMembro(usuarios.get(idx));
            }
        }

        equipes.add(equipe);
        System.out.println("Equipe cadastrada com sucesso!");
    }

    // Método para listar equipes
    private static void listarEquipes() {
        if (equipes.isEmpty()) {
            System.out.println("Nenhuma equipe cadastrada.");
        } else {
            equipes.forEach(System.out::println);
        }
    }
}