package support;

import entity.Produto;
import entity.Fornecedor;
import repository.FornecedorRepository;
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
        System.out.println("6 - Fornecedor");
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
                    System.out.println("------------------ Cadastrar Produto ------------------\n");
                    cadastrarProduto();
                    Util.menu_principal();
                    break;
                case 2:
                    System.out.println("Listagem de produtos\n");
                    listarProduto();
                    Util.menu_principal();
                    break;
                case 3:
                    System.out.println("Consultar produto\n");
                    pesquisarProdutoPorId();
                    Util.menu_principal();
                    break;
                case 4:
                    System.out.println("-----------------------Atualizar produto-------------------------------\n");
                    atualizarProdutoPorId();
                    Util.menu_principal();
                    break;
                case 5:
                    System.out.println("Excluir produto\n");
                    deletarProdutoPorId();
                    Util.menu_principal();
                    break;
                case 6:
                    System.out.println("------------------ Cadastrar Fornecedor ------------------\n");
                    cadastrarFornecedor();
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

        System.out.println("Produto cadastrado com sucesso.");

    }


    public static void cadastrarFornecedor() {
        Scanner scanner = new Scanner(System.in);

        Fornecedor fornecedor = new Fornecedor();

        System.out.print("cnpj: ");
        String cnpj = scanner.nextLine();


        System.out.print("Razão social: ");
        String razaoSocial = scanner.nextLine();


        System.out.print("Nome fantasia: ");
        String nomeFantasia = scanner.nextLine();


        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();


        System.out.print("inscrição estadual: ");
        String incricao = scanner.nextLine();


        // Configurar outros atributos do fornecedor conforme necessário
            fornecedor.setCnpj(cnpj);
            fornecedor.setRazao_social(razaoSocial);
            fornecedor.setNome_fantasia(nomeFantasia);
            fornecedor.setCidade(cidade);
            fornecedor.setInscricao_estadual(incricao);


        // Supondo que ProdutoRepository seja uma classe que lida com o cadastro de produtos
        new FornecedorRepository().cadastrarFornecedor(fornecedor);

        System.out.println("Fornecedor cadastrado com sucesso.");
    }


    private static int ler_opcao_do_usuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a opção desejada: ");
        return scanner.nextInt();
    }

    public static void listarProduto(){
        ProdutoRepository produtoRepository = new ProdutoRepository();
        produtoRepository.getProdutos();
    }

    public static void pesquisarProdutoPorId(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do produto: ");
        int id = scanner.nextInt();

        ProdutoRepository produtoRepository = new ProdutoRepository();
        produtoRepository.getProdutoById(id);

    }





    public static void atualizarProdutoPorId(){
        Scanner scanner = new Scanner(System.in);

        Produto produto = new Produto();

        System.out.println("Digite o ID do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.printf("\nQual vai ser o novo nome do Produto: ");
        String nome = scanner.nextLine();

        System.out.printf("\nQual vai ser o novo preço de compra: ");
        double precoCompra = scanner.nextDouble();


        System.out.printf("\nQual vai ser o novo preço de venda: ");
        double precoVenda = scanner.nextDouble();


        System.out.printf("\nQual vai ser o nova quantidade: ");
        int quantidade = scanner.nextInt();



        System.out.printf("\nQual vai ser o novo codigo do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();


        System.out.printf("\nQual vai ser o nova descrição: ");
        String descricao = scanner.nextLine();


        System.out.printf("\nDigite a nova Data de Validade(aaaa-mm-dd): ");
        String dataValidade = scanner.nextLine();


        System.out.printf("\nQual vai ser a atualização de disponibilidade Disponibilidade (1- Ativo 2-Fora de Linha): ");
        String disponibilidade = scanner.nextLine();

        if (disponibilidade == "1"){
            disponibilidade = "ATIVO";
        } else if (disponibilidade == "2"){
            disponibilidade = "FORA DE LINHA";
        }else {
            disponibilidade = "ATIVO";
        }


        System.out.printf("\nDigite o novo ID do Fornecedor: ");
        int fornecedor = scanner.nextInt();

        produto.setNome(nome);
        produto.setPreco_compra(precoCompra);
        produto.setPreco_venda(precoVenda);
        produto.setQuantidade(quantidade);
        produto.setCodigo_do_produto(codigo);
        produto.setDescricao(descricao);
        produto.setData_de_validade(dataValidade);
        produto.setDisponibilidade(disponibilidade);
        produto.setFornecedor(fornecedor);


        String atributo = scanner.nextLine();
        ProdutoRepository produtoRepository = new ProdutoRepository();
        produtoRepository.atualizarProduto(produto, id);

    }

    public static void deletarProdutoPorId(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do produto: ");
        int id = scanner.nextInt();

        ProdutoRepository produtoRepository = new ProdutoRepository();
        produtoRepository.deletarProduto(id);

    }



}
