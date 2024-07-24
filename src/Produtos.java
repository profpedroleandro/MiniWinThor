import java.util.Date;
import java.util.Scanner;

public class Produtos{
    
    private int idProduto;
    private String nome;
    private double preco_compra;
    private double preco_venda;
    private int quantidade;
    private String codigo_do_produto;
    private String descricao;
    private Date data_de_validade;
    private boolean disponibilidade;
    private int fornecedor;

    Scanner scanner = new Scanner(System.in);

    public void cadastrarProduto(){
        System.out.println("\nCadastro de Produto:");

        System.out.print("ID do Produto: ");
        int id = scanner.nextInt();
        setIdProduto(id);
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();
        setNome(nome);
        


        System.out.print("Preço de Compra: ");
        double precoCompra = scanner.nextDouble();
        setPreco_compra(precoCompra);
        scanner.nextLine();
        

        System.out.print("Preço de Venda: ");
        double precoVenda = scanner.nextDouble();
        setPreco_venda(precoVenda);
        scanner.nextLine();

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        setQuantidade(quantidade);
        scanner.nextLine();

        System.out.print("Código do Produto: ");
        String codigoProduto = scanner.nextLine();
        setCodigo_do_produto(codigoProduto);

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        setDescricao(descricao);

        System.out.print("Data de Validade (dd/mm/aaaa): ");
        String dataValidadeStr = scanner.next();
        setData_de_validade(data_de_validade);

        System.out.print("Disponibilidade (true/false): ");
        boolean disponibilidade = scanner.nextBoolean();
        setDisponibilidade(disponibilidade);
        scanner.nextLine();

        System.out.print("ID do Fornecedor: ");
        int fornecedor = scanner.nextInt();
        setFornecedor(fornecedor);
        scanner.nextLine();
        
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(double preco_compra) {
        this.preco_compra = preco_compra;
    }

    public double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodigo_do_produto() {
        return codigo_do_produto;
    }

    public void setCodigo_do_produto(String codigo_do_produto) {
        this.codigo_do_produto = codigo_do_produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_de_validade() {
        return data_de_validade;
    }

    public void setData_de_validade(Date data_de_validade) {
        this.data_de_validade = data_de_validade;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }
    
}


