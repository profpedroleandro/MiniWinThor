package support;

import entity.Produto;
import repository.ProdutoRepository;

import java.util.Scanner;

public class Util {

    public static void menu_principal() {
        System.out.println("\n\n============== MENU PRINCIPAL ===============");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listagem de produtos");
        System.out.println("3 - Consultar produto");
        System.out.println("4 - Atualizar produto");
        System.out.println("5 - Excluir produto");
        System.out.println("0 - Encerrar programa");
        System.out.println("============================================");
    }

    public static void escolhas_menu_principal(int opcao) {

        boolean continuar = true;

        do {
            switch (opcao) {
                case 0:
                    System.out.println("\nEncerrando!");
                    continuar = false;
                    break;
                case 1:
                    System.out.println("------------------ Cadastrar ------------------\n");
                    cadastrarProduto();
                    Util.menu_principal();
                    break;
                case 2:
                    System.out.println("Listagem de produtos\n");
                    // Lógica para listar produtos
                    Util.menu_principal();
                    break;
                case 3:
                    System.out.println("Consultar produto\n");
                    // Lógica para consultar produto
                    Util.menu_principal();
                    break;
                case 4:
                    System.out.println("Atualizar produto\n");
                    // Lógica para atualizar produto
                    Util.menu_principal();
                    break;
                case 5:
                    System.out.println("Excluir produto\n");
                    // Lógica para excluir produto
                    Util.menu_principal();
                    break;
                default:
                    System.out.println("Escolha uma opção válida!\n");
                    Util.menu_principal();
                    break;
            }

            opcao = ler_opcao_do_usuario();
        } while (continuar);
    }


    public static void cadastrarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCadastro de entity.Produto:");

        System.out.print("Nome do entity.Produto: ");
        String nome = scanner.nextLine();

        System.out.print("Preço de Compra: ");
        double precoCompra = scanner.nextDouble();

        System.out.print("Preço de Venda: ");
        double precoVenda = scanner.nextDouble();

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();

        System.out.print("Código do entity.Produto: ");
        String codigoProduto = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Data de Validade (aaaa-mm-dd): ");
        String dataValidadeStr = scanner.next();
        scanner.nextLine();

        System.out.print("Disponibilidade (Ativo/Fora de Linha): ");
        String disponibilidade = scanner.nextLine();



        if (disponibilidade.equals("Fora de Linha")){
            disponibilidade = "Fora de Linha";
        } else {
            disponibilidade = "Ativo";
        }

        System.out.print("ID do Fornecedor: ");
        int fornecedor = scanner.nextInt();


        Produto produto = new Produto();
        produto.setNome(nome);

        new ProdutoRepository().cadastrarProduto(produto);

        //TODO invocar o método implementado para salvar os dados no database

        System.out.println("entity.Produto cadastrado com sucesso.");

    }

    private static int ler_opcao_do_usuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a opção desejada: ");
        return scanner.nextInt();
    }
}
