package repository;

import conexao.Conexao;
import entity.Produto;

import java.sql.*;

public class ProdutoRepository {

    public void inserirProduto(Produto produto) {

        String comandoSQL = "INSERT INTO produtos (fornecedor, nome, descricao, preco_compra, data_compra, status_produto, quantidade, peso) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = Conexao.getMinhaConexao().prepareStatement(comandoSQL);
            preparedStatement.setInt(1, produto.getIdFornecedor());
            preparedStatement.setString(2, produto.getNomeProduto());
            preparedStatement.setString(3, produto.getDescricao());
            preparedStatement.setDouble(4, produto.getPrecoDeCompra());
            preparedStatement.setString(5, produto.getDataCompra());
            preparedStatement.setString(6, produto.getStatus());
            preparedStatement.setInt(7, produto.getQuantidade());
            preparedStatement.setDouble(8, produto.getPeso());

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
