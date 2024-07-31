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
            System.out.printf("ID \t Nome \t Preço de Compra \t Preço de Venda \t Quantidade \t Código do Produto \t  Descricao\n");
            while (resultSet.next()) {
                System.out.printf("%d \t %s \t %.2f \t\t\t\t %.2f \t\t\t\t %d \t\t\t %d \t\t\t %s\t \n", resultSet.getInt("idProduto"), resultSet.getString("nome"), resultSet.getDouble("preco_compra"), resultSet.getDouble("preco_venda"), resultSet.getInt("quantidade"), resultSet.getInt("codigo_do_produto"), resultSet.getString("descricao"));
            }

            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void getProdutoById(int id) {

        Statement statement = null;
        Connection connection = Conexao.getMinhaConexao();
        try {
            statement = (Statement) connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String comandoSQL = "SELECT * FROM produtos WHERE idProduto =  "+id;
        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery(comandoSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println();
            System.out.println("****************************** LISTA DE PRODUTOS ******************************");
            System.out.printf("ID \t Nome \t Preço de Compra \t Preço de Venda \t Quantidade \t Código do Produto \t  Descricao\n");
            while (resultSet.next()) {
                System.out.printf("%d \t %s \t %.2f \t\t\t\t %.2f \t\t\t\t %d \t\t\t %d \t\t\t %s\t \n", resultSet.getInt("idProduto"), resultSet.getString("nome"), resultSet.getDouble("preco_compra"), resultSet.getDouble("preco_venda"), resultSet.getInt("quantidade"), resultSet.getInt("codigo_do_produto"), resultSet.getString("descricao"));
            }

            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void atualizarProduto(Produto produto, int id) {

        String comandoSQL = "UPDATE produtos SET nome = ?, preco_compra= ?, preco_venda= ?, quantidade= ?, codigo_do_produto= ?, descricao= ?, data_de_validade= ?, disponibilidade= ?, fornecedor= ? WHERE idProduto = " + id;
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

            System.out.println("Produto atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deletarProduto(int id) {

        String comandoSQL = "DELETE FROM produtos WHERE idProduto = " +id;

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = Conexao.getMinhaConexao().prepareStatement(comandoSQL);
            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Produto deletado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }




}
