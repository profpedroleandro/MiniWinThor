package repository;

import conexao.Conexao;
import entity.Produto;

import java.sql.*;

public class ProdutoRepository {

    public void cadastrarProduto(Produto produto) {

        String comandoSQL = "INSERT INTO produtos (nome, descricao, garantia, quantidade ,precoVenda ,precoCompra ,dataDaUltimaCompra ,status_produto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = Conexao.getMinhaConexao().prepareStatement(comandoSQL);
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());
            preparedStatement.setString(3, produto.getGarantia());
            preparedStatement.setInt(   4, produto.getQuantidade());
            preparedStatement.setDouble(5, produto.getPrecoDeVenda());
            preparedStatement.setDouble(6, produto.getPrecoDeCompra());
            preparedStatement.setString(7, produto.getDataDaUltimaCompra());
            preparedStatement.setString(8, produto.getStatusProduto());


            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void getProdutos() {

        Statement statement = null;
        Connection connection = Conexao.getMinhaConexao();
        try {
            statement = (Statement) connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String comandoSQL = "SELECT * FROM produtos";
        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery(comandoSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println();
            System.out.println("****************************** LISTA DE PRODUTOS ******************************");
            System.out.printf("Cod \t Nome \t Preço \t Status\n");
            while (resultSet.next()) {
                System.out.printf("%d %s %.2f %s\n", resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getDouble("preco"), resultSet.getString("status_prod"));
            }

            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
