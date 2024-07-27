package support;

import entity.Endereco;
import repository.EnderecoRepository;
import java.util.Scanner;

public class CadastroEndereco {

    public static void cadastroEndereco(){

        Endereco endereco = new Endereco();

        Scanner leia = new Scanner(System.in);

        System.out.println("**********Cadastro do Endereço**********");

        System.out.println("Informe o  seu Logradouro");
        String logradouro = leia.nextLine();
        endereco.setLogradouro(logradouro);

        System.out.println("Informe o Bairro");
        String bairro = leia.nextLine();
        endereco.setBairro(bairro);

        System.out.println("Informe o CEP");
        String cep = leia.nextLine();
        endereco.setCep(cep);

        System.out.println("Adicione um Complemento");
        String complemento = leia.nextLine();
        endereco.setComplemento(complemento);

        System.out.println("Informe sua cidade");
        String cidade = leia.nextLine();
        endereco.setCidade(cidade);

        System.out.println("Informe o Estado");
        String estado = leia.nextLine();
        endereco.setEstado(estado);

        System.out.println("Informe o Pais");
        String pais = leia.nextLine();
        endereco.setPais(pais);

        listaDeEnderecos();

        EnderecoRepository enderecoRepository = new EnderecoRepository();
        enderecoRepository.cadastroEndereco(endereco);

        System.out.println("Endereço cadastrado com sucesso!");




    }
    private static void listaDeEnderecos() {

        Endereco endereco = new Endereco();

        System.out.println("********************Listar Produtos********************");
        System.out.println("Logradouro: " + endereco.getLogradouro());
        System.out.println("Bairro: " + endereco.getBairro());
        System.out.println("CEP: " + endereco.getCep());
        System.out.println("Compelmento: " + endereco.getComplemento());
        System.out.println("Cidade: " + endereco.getCidade());
        System.out.println("Estado: " + endereco.getEstado());
        System.out.println("País: " + endereco.getPais());


    }



}
