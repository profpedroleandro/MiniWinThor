import javax.xml.crypto.Data;

public class Produto{
    private int codigo;
    private String nome;
    private String descricao;
    private String garantia;
    private int quantidade;
    private double precoDeVenda;
    private double precoDeCompra;
    private String status_produto;
    private Data dataDaUltimaCompra;

    public int getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    public Data getDataDaUltimaCompra(){
        return dataDaUltimaCompra;
    }
    public void setDataDaUltimaCompra(Data dataDaUltimaCompra){
        this.dataDaUltimaCompra = dataDaUltimaCompra;
    }

    public  String getGarantia(){
        return garantia;
    }
    public void setGarantia(String garantia){
        this.garantia = garantia;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
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

    public String getStatus() {
        return status_produto;
    }

    public void setStatus(String status) {
        this.status_produto = status;
    }

    public double getPrecoDeVenda() {
        return precoDeVenda;
    }

    public void setPrecoDeVenda(double precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}