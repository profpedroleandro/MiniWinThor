package service;

import DAO.ProdutoDAO;
import entity.Produto;

import java.util.Scanner;

public class ProdutoService {

    public void inserirProduto() {

        Scanner entrada = new Scanner(System.in);

        Produto produto = new Produto();

        System.out.println();
        System.out.println("****************************** PRODUTO ******************************");
        System.out.println("Informe o nome do produto: ");
        String nome = entrada.nextLine();
        System.out.println("Informe uma descrição para o produto");
        String descricao = entrada.nextLine();
        System.out.println("Digite o preço de venda");
        double precoDeVenda = entrada.nextDouble();
        System.out.println("Escolha: [1] -> ATIVO | [2] -> FORA DE LINHA");
        int escolha = entrada.nextInt();

        String status = "ATIVO";

        if (escolha == 2) {
            status = "FORA_DE_LINHA";
        }

        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setPreco(precoDeVenda);
        produto.setStatus(status);

        new ProdutoDAO().cadastrarProduto(produto);

        System.out.println("Produto cadastrado com sucesso!");

    }

    public void listarProdutos() {
        new ProdutoDAO().getProdutos();
    }

}
