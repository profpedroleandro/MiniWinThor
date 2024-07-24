import javax.xml.crypto.Data;
import java.util.Scanner;

public class Menu {
public static void menu(){
    int oqver;
    System.out.println("*************************************MENU*********************************");
    System.out.println("1.Cadastro de Produtos ");
    System.out.println("2.Lista de Produtos ");
    System.out.println("3.Procurar Produtos ");
    System.out.println("4.Excluir Produtos ");
    System.out.println("0.Sair");
    System.out.println("**********************************FIM MENU*******************************");
    System.out.println("Digite qual que voce quer:");
    oqver = (new Scanner(System.in)).nextInt();

int opicao=(new Scanner(System.in)).nextInt();;
    switch (opicao){
        case 1:
            Scanner sc = new Scanner(System.in);
            String nomedoproduto,descricao,garantia;
            int quantidade,precodeVenda,precodeCompra,statusProduto;
            Data datadaUltimaCompra;

            System.out.println("******************Cadastro de Produtos*********************");
            System.out.println("Digite o nome do produto: ");
            nomedoproduto = sc.nextLine();
            System.out.println("Digite a descriçao do produto: ");
            descricao = sc.nextLine();
            System.out.println("Digite a garantia do produto: ");
            garantia = sc.nextLine();
            System.out.println("Digite a quantidade do produto: ");
            quantidade = sc.nextInt();
            System.out.println("Digite o preço de venda do produto: ");
            precodeVenda = sc.nextInt();
            System.out.println("Digite o preço de compra do produto: ");
            precodeCompra = sc.nextInt();
            System.out.println("Digite o status do produto[1.ativo ou 2.fora de linha]: ");
            statusProduto = sc.nextInt();
            if(statusProduto == 1){
                System.out.println("ativo");
            }
            else if(statusProduto == 2){
                System.out.println("fora de linha");
            }

            break;
    }


}
public static void  CadastrodeProdutos(){
    Scanner sc = new Scanner(System.in);
    String nomedoproduto,descricao,garantia;
    int quantidade,precodeVenda,precodeCompra,statusProduto;
    Data datadaUltimaCompra;

    System.out.println("******************Cadastro de Produtos*********************");
    System.out.println("Digite o nome do produto: ");
    nomedoproduto = sc.nextLine();
    System.out.println("Digite a descriçao do produto: ");
    descricao = sc.nextLine();
    System.out.println("Digite a garantia do produto: ");
    garantia = sc.nextLine();
    System.out.println("Digite a quantidade do produto: ");
    quantidade = sc.nextInt();
    System.out.println("Digite o preço de venda do produto: ");
    precodeVenda = sc.nextInt();
    System.out.println("Digite o preço de compra do produto: ");
    precodeCompra = sc.nextInt();
    System.out.println("Digite o status do produto[1.ativo ou 2.fora de linha]: ");
    statusProduto = sc.nextInt();
    if(statusProduto == 1){
        System.out.println("ativo");
    }
    else if(statusProduto == 2){
        System.out.println("fora de linha");
    }


    System.out.println("O produto "+nomedoproduto+"castrado com sucesso!");
    System.out.println(descricao+" do produto cadastrado com sucesso");
    System.out.println(garantia+ " de garantian cadastrado com sucesso");
    System.out.println(quantidade+ " de quantidade de produtos");
    System.out.println("O preco de venda e "+precodeVenda+ "do produto");
    System.out.println("O preco de compra e "+precodeCompra+ "do produto");
    System.out.println("O status do produto "+statusProduto+ "do produto");
}

public static void ListaDeProdutos(){
    Scanner sc = new Scanner(System.in);
    String nomedoproduto = "";
    System.out.println("******************Lista de Produtos*********************");
    System.out.println("Nome dos produtos " +nomedoproduto);
}
}
