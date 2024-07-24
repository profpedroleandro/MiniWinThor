import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static ArrayList<Produto> listaDeProdutos = new ArrayList<>();
    public static Scanner leia = new Scanner(System.in);

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
                cadastrarProduto();
                break;
            case 2:
                break;
            case 0:
                System.out.println("\nSaindo do sistema...");
                break;
            default:
                System.out.println("\nOpção inválida. Tente novamente.");
        }
    }

    private static boolean perguntarContinuar() {
        System.out.print("\nDeseja continuar? (S/N): ");
        String resposta = leia.nextLine().toUpperCase();
        return resposta.equals("S");
    }

    private static void cadastrarProduto() {
        System.out.print("Insira o código do produto: ");
        int codigo = leia.nextInt();
        leia.nextLine();

        System.out.print("Insira o nome do produto: ");
        String nome = leia.nextLine();

        System.out.print("Informe o ID do fornecedor: ");
        int idFornecedor = leia.nextInt();
        leia.nextLine();

        System.out.print("Insira a descrição do produto: ");
        String descricao = leia.nextLine();

        System.out.print("Insira o preço de compra: ");
        double precoDeCompra = leia.nextDouble();

        System.out.print("Informe o status do produto: ");
        String status = leia.nextLine();

        System.out.print("Informe o peso do produto: ");
        double peso = leia.nextDouble();
        leia.nextLine();
    }

}


