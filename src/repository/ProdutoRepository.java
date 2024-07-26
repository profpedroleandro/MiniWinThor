package repository;

import conexao.Conexao;
import entity.Produto;

import java.sql.*;

public class ProdutoRepository {

    public void cadastrarProduto(Produto produto) {

        String comandoSQL = "INSERT INTO produtos (`nome`, `preco_compra`, `preco_venda`, `quantidade`, `codigo_do_produto`, `descricao`, `data_de_validade`, `disponibilidade`, `fornecedor`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = Conexao.getMinhaConexao().prepareStatement(comandoSQL);
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setDouble(2, produto.getPreco_compra());
            preparedStatement.setDouble(3, produto.getPreco_venda());
            preparedStatement.setInt(4, produto.getQuantidade());
            preparedStatement.setInt(5, produto.getCodigo_do_produto());
            preparedStatement.setString(6, produto.getDescricao());
            preparedStatement.setString(7, produto.getData_de_validade());
            preparedStatement.setString(8, produto.getDisponibilidade());
            preparedStatement.setInt(9, produto.getFornecedor());
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
