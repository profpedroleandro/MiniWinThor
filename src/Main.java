import entity.Produto;
import repository.ProdutoRepository;

import java.util.ArrayList;
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
                listarProdutos();
                break;
            case 3:
                buscarProduto();
                break;
            case 4:
                editarProduto();
                break;
            case 5:
                removerProduto();
                break;
            case 0:
                System.out.println("\nSaindo do sistema...");
                System.exit(0);
                break;
            default:
                System.out.println("\nOpção inválida. Tente novamente.");
        }
    }

    private static boolean perguntarContinuar() {
        System.out.print("\nDeseja voltar para o menu? (S/N): ");
        String resposta = leia.nextLine().toUpperCase();
        return resposta.equals("S");
    }

    private static void cadastrarProduto() {

        System.out.print("Insira o nome do produto: ");
        String nome = leia.nextLine();

        System.out.print("Informe o ID do fornecedor: ");
        int idFornecedor = leia.nextInt();
        leia.nextLine();

        System.out.print("Insira a descrição do produto: ");
        String descricao = leia.nextLine();

        System.out.print("Insira o preço de compra: ");
        double precoDeCompra = leia.nextDouble();
        leia.nextLine();

        System.out.print("Informe o status do produto: ");
        String status = leia.nextLine();

        System.out.print("Informe o peso do produto: ");
        double peso = leia.nextDouble();
        leia.nextLine();

        //TODO implementação do método para cadastrar no banco de dados
        Produto produto  = new Produto();
        produto.setNomeProduto(nome);
        produto.setIdFornecedor(idFornecedor);
        produto.setDescricao(descricao);
        produto.setPrecoDeCompra(precoDeCompra);
        produto.setStatus(status);
        produto.setPeso(peso);

        ProdutoRepository produtoRepository = new ProdutoRepository();
        produtoRepository.inserirProduto(produto);


        System.out.println("Produto cadastrado com sucesso!");

    }

    private static void listarProdutos() {
        if (listaDeProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto produto : listaDeProdutos) {
                System.out.println(produto);
            }
        }
    }

    private static void buscarProduto() {
        System.out.print("Digite o código do produto que deseja buscar: ");
        int codigo = leia.nextInt();
        leia.nextLine();

        Produto produto = encontrarProduto(codigo);

        if (produto != null) {
            System.out.println(produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static Produto encontrarProduto(int codigo) {
        for (Produto produto : listaDeProdutos) {
            if (produto.getIdProduto() == codigo) {
                return produto;
            }
        }
        return null;
    }

    private static void editarProduto() {
        System.out.print("Digite o código do produto que deseja editar: ");
        int codigo = leia.nextInt();
        leia.nextLine();

        Produto produto = encontrarProduto(codigo);


        System.out.println("\n--- Sistema de Edição de Produtos ---");
        System.out.println("Digite oque deseja editar: ");
        System.out.println("1.  Nome do models.Produto");
        System.out.println("2.  ID do Fornecedor");
        System.out.println("3.  Descrição do models.Produto");
        System.out.println("4.  Preço de Compra");
        System.out.println("5.  Status do models.Produto");
        System.out.println("6.  Peso do models.Produto");
        System.out.println("0. Sair");

        System.out.print("Digite a opção desejada: ");
        int edicao = leia.nextInt();
        leia.nextLine();

        switch (edicao) {
            case 1:
                System.out.print("Insira o novo nome do produto: ");
                String nome = leia.nextLine();
                produto.setNomeProduto(nome);
                System.out.println("Produto alterado com sucesso!");
                break;
            case 2:
                System.out.print("Informe o novo ID do fornecedor: ");
                int idFornecedor = leia.nextInt();
                leia.nextLine();
                produto.setIdFornecedor(idFornecedor);
                System.out.println("Produto alterado com sucesso!");
                break;
            case 3:
                System.out.print("Insira a nova descrição do produto: ");
                String descricao = leia.nextLine();
                produto.setDescricao(descricao);
                System.out.println("Produto alterado com sucesso!");
                break;
            case 4:
                System.out.print("Insira o novo preço de compra: ");
                double precoDeCompra = leia.nextDouble();
                leia.nextLine();
                produto.setPrecoDeCompra(precoDeCompra);
                System.out.println("Produto alterado com sucesso!");
                break;
            case 5:
                System.out.print("Informe o novo status do produto: ");
                String status = leia.nextLine();
                produto.setStatus(status);
                System.out.println("Produto alterado com sucesso!");
                break;
            case 6:
                System.out.print("Informe o novo peso do produto: ");
                double peso = leia.nextDouble();
                leia.nextLine();
                produto.setPeso(peso);
                System.out.println("Produto alterado com sucesso!");
                break;
            case 0:
                System.out.println("\nSaindo do sistema...");
                System.exit(0);
                break;
            default:
                System.out.println("\nOpção inválida. Tente novamente.");
        }
    }

    private static void removerProduto() {
        System.out.print("Digite o código do produto que deseja remover: ");
        int codigo = leia.nextInt();
        leia.nextLine();

        Produto produto = encontrarProduto(codigo);

        if (produto != null) {
            listaDeProdutos.remove(produto);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}