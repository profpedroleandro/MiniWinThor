import java.util.Date;

public class Produto {

    private int idProduto;
    private String nome;
    private double preco_compra;
    private double preco_venda;
    private int quantidade;
    private String codigo_do_produto;
    private String descricao;
    private String data_de_validade;
    private String disponibilidade;
    private int fornecedor;

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

    public String getData_de_validade() {
        return data_de_validade;
    }

    public void setData_de_validade(String data_de_validade) {
        this.data_de_validade = data_de_validade;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

}


