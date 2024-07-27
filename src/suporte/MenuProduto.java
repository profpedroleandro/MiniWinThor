package suporte;

import entity.Produto;
import repository.ProdutoRepository;

public class MenuProduto {

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

}
