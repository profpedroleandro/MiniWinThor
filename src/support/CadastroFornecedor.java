package support;

import entity.Fornecedor;
import repository.FornecedorRepository;
import java.util.Scanner;

public class CadastroFornecedor {
    public static void cadastroFornecedor() {
        Scanner leia = new Scanner(System.in);
        Fornecedor fornecedor = new Fornecedor();

        System.out.println("Razão Social: ");
        String razaoSocial = leia.nextLine();
        fornecedor.setRazaoSocial(razaoSocial);

        System.out.println("CNPJ: ");
        String CNPJ = leia.nextLine();
        fornecedor.setCnpj(CNPJ);

        System.out.println("IE: ");
        String ie = leia.nextLine();
        fornecedor.setIe(ie);

        System.out.println("Nome Fantasia: ");
        String nomeFantasia = leia.nextLine();
        fornecedor.setNomeFantasia(nomeFantasia);

        listaFornecedor();

        FornecedorRepository fornecedorRepository = new FornecedorRepository();
        fornecedorRepository.cadastroFornecedor(fornecedor);

        System.out.println("Fornecedor cadastrado com sucesso!");
    }
    private static void listaFornecedor() {

        Fornecedor fornecedor = new Fornecedor();

        System.out.println("********************Listar Fornecedor********************");
        System.out.println("Razão Social: " + fornecedor.getRazaoSocial());
        System.out.println("Nome Fantasia : " + fornecedor.getNomeFantasia());
        System.out.println("CNPJ: " + fornecedor.getCnpj());
        System.out.println("Ie: " + fornecedor.getIe());



    }
}
