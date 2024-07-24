public class Produto{
    private String nomeProduto;
    private int codigo;
    private int idFornecedor;
    private String descricao;
    private double precoDeCompra;
    private String status;
    private int quantidade;
    private double peso;




    public void setNomeProduto(String nomeProduto){
        this.nomeProduto = nomeProduto;
    }

    public String getNomeProduto(){
        return this.nomeProduto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecoDeCompra() {
        return precoDeCompra;
    }

    public void setPrecoDeCompra(double precoDeCompra) {
        this.precoDeCompra = precoDeCompra;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }
    public int getQuantidade(){
        return quantidade;
    }

    public double getPeso(){
        return peso;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public void setquantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}