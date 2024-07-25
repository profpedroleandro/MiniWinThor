package support;

import service.ProdutoService;

import java.util.Scanner;

public class Util {

    public static void menu(){
        Scanner leia = new Scanner(System.in);

        System.out.println();
        System.out.println("****************************** MENU ******************************");
        System.out.println("* 121 - Resumo de Faturamento");
        System.out.println("* 211 - Cadastrar Produto");
        System.out.println("* 212 - Listar Produtos");
        System.out.println("* 311 - Cadastrar Cliente");
        System.out.println("* 321 - Digitar Pedido");
        System.out.println("* 322 - Cancelar Pedido");

        int opcao = leia.nextInt();

        switch(opcao){

            case 121:
                System.out.println("Resumo de Faturamento");
                break;
            case 211:
                new ProdutoService().inserirProduto();
                break;
            case 212:
                new ProdutoService().listarProdutos();
                break;
            case 311:
                System.out.println("Cadastrar Cliente");
                break;
            case 321:
                System.out.println("Digitar Pedido");
                break;
            case 322:
                System.out.println("Cancelar Pedido");
                break;
            default:
                System.out.println("Essa opção é inválida");
                break;

        }

    }

    public static boolean sair(){
        Scanner leia = new Scanner(System.in);

        System.out.println();
        System.out.println("* 0 - Sair");
        System.out.println("* 1 - Continuar");

        int opcao = leia.nextInt();

        if(opcao == 0){
            return true;
        }

        return false;

    }

}
