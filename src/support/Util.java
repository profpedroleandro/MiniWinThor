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

        Produto produto = new Produto();

        System.out.println("\nCadastro de Produto:");

        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();

        System.out.print("Preço de Compra: ");
        double precoCompra = scanner.nextDouble();

        System.out.print("Preço de Venda: ");
        double precoVenda = scanner.nextDouble();

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();

        System.out.print("Código do Produto: ");
        int codigoProduto = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Data de Validade (aaaa-mm-dd): ");
        String dataValidade = scanner.next();
        scanner.nextLine();

        System.out.print("Disponibilidade (Ativo/Fora de Linha): ");
        String disponibilidade = scanner.nextLine();


        if (disponibilidade.equals("FORA DE LINHA")){
            disponibilidade = "FORA DE LINHA";
        } else {
            disponibilidade = "ATIVO";
        }

        System.out.print("ID do Fornecedor: ");
        int fornecedor = scanner.nextInt();

        produto.setNome(nome);
        produto.setPreco_compra(precoCompra);
        produto.setPreco_venda(precoVenda);
        produto.setQuantidade(quantidade);
        produto.setCodigo_do_produto(codigoProduto);
        produto.setDescricao(descricao);
        produto.setData_de_validade(dataValidade);
        produto.setDisponibilidade(disponibilidade);
        produto.setFornecedor(fornecedor);


        new ProdutoRepository().cadastrarProduto(produto);

        System.out.println("entity.Produto cadastrado com sucesso.");

    }

    private static int ler_opcao_do_usuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a opção desejada: ");
        return scanner.nextInt();
    }
}
