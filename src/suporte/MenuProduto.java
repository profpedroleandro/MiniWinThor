package suporte;

import entity.Produto;
import repository.ProdutoRepository;
import java.util.Scanner;

public class MenuProduto {

    public static Scanner leia = new Scanner(System.in);

    public static void cadastrarProduto() {

        System.out.print("Informe o nome do produto: ");
        String nome = leia.nextLine();

        System.out.print("Informe o ID do fornecedor: ");
        int idFornecedor = leia.nextInt();

        System.out.print("Informe a descrição do produto: ");
        String descricao = leia.nextLine();
        leia.nextLine();

        System.out.print("Informe o preço de compra: ");
        double precoDeCompra = leia.nextDouble();
        leia.nextLine();

        System.out.println("Informe a data de compra: ");
        String dataCompra = leia.nextLine();

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
        produto.setDataCompra(dataCompra);
        produto.setStatus(status);
        produto.setPeso(peso);

        ProdutoRepository produtoRepository = new ProdutoRepository();
        produtoRepository.inserirProduto(produto);


        System.out.println("Produto cadastrado com sucesso!");

    }

        public static void listarProdutos() {
            ProdutoRepository produtoRepository = new ProdutoRepository();
            produtoRepository.getProdutos();
        }


    public static void buscarProduto() {
        System.out.print("Digite o código do produto que deseja buscar: ");
        int codigo = leia.nextInt();
        leia.nextLine();
        ProdutoRepository produtoRepository = new ProdutoRepository();
        produtoRepository.getProdutoById(codigo);

    }

    public static void editarProduto() {
        System.out.print("Digite o código do produto que deseja editar: ");
        int codigo = leia.nextInt();
        leia.nextLine();

        Produto produto  = new Produto();

        ProdutoRepository produtoRepository = new ProdutoRepository();
        produtoRepository.atualizarProduto(produto);

        System.out.println("\n--- Sistema de Edição de Produtos ---");
        System.out.println("Digite oque deseja editar: ");
        System.out.println("1.  Nome do Produto");
        System.out.println("2.  ID do Fornecedor");
        System.out.println("3.  Descrição do Produto");
        System.out.println("4.  Preço de Compra");
        System.out.println("5.  Data de Compra");
        System.out.println("6.  Status do Produto");
        System.out.println("7.  Peso do Produto");
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
                System.out.print("Informe a nova data de compra: ");
                String dataCompra = leia.nextLine();
                produto.setDataCompra(dataCompra);
                break;
            case 6:
                System.out.print("Informe o novo status do produto: ");
                String status = leia.nextLine();
                produto.setStatus(status);
                System.out.println("Produto alterado com sucesso!");
                break;
            case 7:
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

    public static void removerProduto() {
        System.out.print("Digite o código do produto que deseja remover: ");
        int codigo = leia.nextInt();
        leia.nextLine();

        ProdutoRepository produtoRepository = new ProdutoRepository();
        produtoRepository.deletarProduto(codigo);

    }




    }




