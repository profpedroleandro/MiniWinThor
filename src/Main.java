import suporte.MenuProduto;
import suporte.MenuFornecedor;

import java.util.Scanner;

public class Main {

    public static Scanner leia = new Scanner(System.in);

    MenuProduto menuProduto = new MenuProduto();

    public static void main(String[] args) {

        boolean continuar;

        do {
            menuPrincipal();
            continuar = perguntarContinuar();

        } while (continuar);

        System.out.println("\nPrograma finalizado!");
    }


    private static void menuPrincipal() {
        System.out.println("\n--- Sistema de Cadastro de Produtos ---");
        System.out.println("1. Cadastrar Produto");
        System.out.println("2. Listar Produtos");
        System.out.println("3. Buscar Produto");
        System.out.println("4. Editar Produto");
        System.out.println("5. Remover Produto");
        System.out.println("0. Sair");

        System.out.print("Digite a opção desejada: ");
        int opcao = leia.nextInt();
        leia.nextLine();

        switch (opcao) {
            case 1:
                MenuProduto.cadastrarProduto();
                break;
            case 2:
                MenuProduto.listarProdutos();
                break;
            case 3:
                MenuProduto.buscarProduto();
                break;
            case 4:
                MenuProduto.editarProduto();
                break;
            case 5:
                MenuProduto.removerProduto();
                break;
            case 0:
                System.out.println("\nSaindo do sistema...");
                System.exit(0);
                break;
            default:
                System.out.println("\nOpção inválida. Tente novamente.");
        }
    }

    public static void menuFornecedor() {
        System.out.println("\n--- Sistema de Fornecedores ---");
        System.out.println("1. Cadastrar Fornecedor");
        System.out.println("2. Listar Fornecedores");
        System.out.println("3. Buscar Fornecedor");
        System.out.println("4. Remover Fornecedor");
        System.out.println("0. Voltar");

        System.out.print("Digite a opção desejada: ");
        int opcao = leia.nextInt();
        leia.nextLine();

        switch (opcao) {
            case 1:
                MenuFornecedor.cadastrarForcenedor();
                break;
            case 2:
                MenuFornecedor.listarFornecedores();
                break;
            case 3:
                MenuFornecedor.fornecedorById();
                break;
            case 4:
                MenuFornecedor.removerFornecedor();
                break;
            case 0:
                System.out.println("\nSaindo do sistema...");
                System.exit(0);
            default:
                System.out.println("\nOpção inválida. Tente novamente.");
        }

    }

    private static boolean perguntarContinuar() {
        System.out.print("\nDeseja voltar para o menu? (S/N): ");
        String resposta = leia.nextLine().toUpperCase();
        return resposta.equals("S");
    }


}