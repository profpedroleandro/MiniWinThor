package support;

import entity.Produto;
import repository.ProdutoRepository;

import java.sql.ResultSet;
import java.util.Scanner;

public class Menu {
    public static void menu() {

        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("*************************************MENU*********************************");
            System.out.println("1.Cadastrar de Produto ");
            System.out.println("2.Lista de Produtos ");
            System.out.println("3.Procurar Produto ");
            System.out.println("4.Atualizar Produto");
            System.out.println("5.Excluir Produto ");
            System.out.println("0.Sair");
            System.out.println("**********************************FIM MENU*******************************");
            System.out.println("Selecione uma das opções acima.");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listaDeProdutos();
                    break;
                case 3:
                    selecionarProduto();
                    break;
                case 4:
                    atualizarProduto();
                    break;
                case 5:
                    excluirProduto();
                    break;
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }

        } while (true);
    }

    private static void cadastrarProduto() {

        Produto produto = new Produto();

        Scanner entrada = new Scanner(System.in);

        String nomedoproduto, descricao, garantia;
        int quantidade, escolha;
        double precodeVenda, precodeCompra;
        String datadaUltimaCompra;

        System.out.println("******************Cadastro de Produtos*********************");
        System.out.println("Digite o nome do produto: ");
        nomedoproduto = entrada.nextLine();
        produto.setNome(nomedoproduto);
        System.out.println("Digite a descriçao do produto: ");
        descricao = entrada.nextLine();
        produto.setDescricao(descricao);
        System.out.println("Digite a garantia do produto: ");
        garantia = entrada.nextLine();
        produto.setGarantia(garantia);
        System.out.println("Digite a quantidade do produto: ");
        quantidade = entrada.nextInt();
        produto.setQuantidade(quantidade);
        System.out.println("Digite o preço de venda do produto: ");
        precodeVenda = entrada.nextDouble();
        produto.setPrecoDeVenda(precodeVenda);
        System.out.println("Digite o preço de compra do produto: ");
        precodeCompra = entrada.nextDouble();
        produto.setPrecoDeCompra(precodeCompra);
        System.out.println("Informe a data da sua última compra (ano-mês-dia)");
        entrada.nextLine();
        datadaUltimaCompra = entrada.nextLine();
        produto.setDataDaUltimaCompra(datadaUltimaCompra);

        System.out.println("Informe o status do produto: 1 para 'Ativo' ou 2 para 'Fora de linha'");
        escolha = entrada.nextInt();

        String status_produto = "ativo";

        if (escolha == 2) {
            status_produto = "fora de linha";
        }
        produto.setStatusProduto(status_produto);

        ProdutoRepository produtoRepository = new ProdutoRepository();
        produtoRepository.cadastrarProduto(produto);


        System.out.println(".Produto Cadastrado com Sucesso!");

    }

    public static void listaDeProdutos() {
        ProdutoRepository produtoRepository = new ProdutoRepository();
        produtoRepository.getProdutos();
    }

    public static void selecionarProduto(){

        Scanner leia = new Scanner(System.in);
        int id;
        System.out.println("Insira o ID do pruduto desejado");
        id = leia.nextInt();

        ProdutoRepository produtoRepository = new ProdutoRepository();
        produtoRepository.selecionarProduto(id);

    }

    public static void atualizarProduto(){

        Scanner leia = new Scanner(System.in);
        Produto produto= new Produto();

        int id;

        String nomedoproduto, descricao, garantia;
        int quantidade, escolha;
        double precodeVenda, precodeCompra;
        String datadaUltimaCompra;

        System.out.println("Insira o id: ");
        id = leia.nextInt();
        System.out.println("Digite o nome do produto: ");
        leia.nextLine();
        nomedoproduto = leia.nextLine();
        produto.setNome(nomedoproduto);
        System.out.println("Digite a descriçao do produto: ");
        descricao = leia.nextLine();
        produto.setDescricao(descricao);
        System.out.println("Digite a garantia do produto: ");
        garantia = leia.nextLine();
        produto.setGarantia(garantia);
        System.out.println("Digite a quantidade do produto: ");
        quantidade = leia.nextInt();
        produto.setQuantidade(quantidade);
        System.out.println("Digite o preço de venda do produto: ");
        precodeVenda = leia.nextDouble();
        produto.setPrecoDeVenda(precodeVenda);
        System.out.println("Digite o preço de compra do produto: ");
        precodeCompra = leia.nextDouble();
        produto.setPrecoDeCompra(precodeCompra);
        System.out.println("Informe a data da sua última compra (ano-mês-dia)");
        leia.nextLine();
        datadaUltimaCompra = leia.next();
        produto.setDataDaUltimaCompra(datadaUltimaCompra);

        System.out.println("Informe o status do produto: 1 para 'Ativo' ou 2 para 'Fora de linha'");
        escolha = leia.nextInt();

        String status_produto = "ativo";

        if (escolha == 2) {
            status_produto = "fora de linha";
        }
        produto.setStatusProduto(status_produto);


        ProdutoRepository produtoRepository = new ProdutoRepository();
        produtoRepository.atualizarProduto(produto,id);
        System.out.println("Produto Atualizado com sucesso!");
    }

    public static void excluirProduto(){

        Scanner leia = new Scanner(System.in);
        int id;
        System.out.println("Id do produto a ser excluído: ");
        id = leia.nextInt();

        ProdutoRepository produtoRepository = new ProdutoRepository();
        produtoRepository.excluirProduto(id);

        System.out.println("Produto excluído!");

    }

}
