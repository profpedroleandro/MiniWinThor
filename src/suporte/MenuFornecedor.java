package suporte;

import entity.Fornecedor;
import entity.Produto;
import repository.FornecedorRepository;
import repository.ProdutoRepository;
import java.util.Scanner;

public class MenuFornecedor {

    public static Scanner leia = new Scanner(System.in);

    public static void cadastrarForcenedor() {

        System.out.print("Informe a razão social: ");
        String razao_social = leia.nextLine();

        System.out.print("Informe o nome Fantasia: ");
        String nome_fantasia = leia.nextLine();

        System.out.print("Informe o cnpj: ");
        int cnpj = leia.nextInt();
        leia.nextLine();

        System.out.print("Informe a cidade: ");
        String cidade = leia.nextLine();
        leia.nextLine();

        System.out.println("Informe o estado (SIGLA): ");
        String estado = leia.nextLine();

        System.out.print("Informe o CEP: ");
        int cep = leia.nextInt();

        //TODO implementação do método para cadastrar no banco de dados
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setRazao_social(razao_social);
        fornecedor.setNome_fantasia(nome_fantasia);
        fornecedor.setCnpj(cnpj);
        fornecedor.setCidade(cidade);
        fornecedor.setEstado(estado);
        fornecedor.setCep(cep);


        FornecedorRepository fornecedorRepository = new FornecedorRepository();
        fornecedorRepository.inserirFornecedor(fornecedor);

        System.out.println("Produto cadastrado com sucesso!");

    }

    public static void listarFornecedores() {

        FornecedorRepository fornecedorRepository = new FornecedorRepository();
        fornecedorRepository.getFornecedores();
}


    public static void fornecedorById() {
        System.out.print("Digite o código do produto que deseja buscar: ");
        int codigo = leia.nextInt();
        leia.nextLine();

        FornecedorRepository fornecedorRepository = new FornecedorRepository();
        fornecedorRepository.getForncedorById(codigo);

    }

    public static void removerFornecedor() {
        System.out.print("Digite o código do Fornecedor que deseja remover: ");
        int codigo = leia.nextInt();
        leia.nextLine();

        FornecedorRepository fornecedorRepository = new FornecedorRepository();
        fornecedorRepository.deletarFornecedor(codigo);

    }




}




