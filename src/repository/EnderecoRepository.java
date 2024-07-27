package repository;

import conexao.Conexao;
import entity.Endereco;

import java.sql.*;

public class EnderecoRepository {

    public void cadastroEndereco(Endereco endereco) {

        String comandoSQL = "INSERT INTO enderecos (logradouro, bairro, cep, complemento ,cidade ,estado ,pais) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = Conexao.getMinhaConexao().prepareStatement(comandoSQL);
            preparedStatement.setString(1, endereco.getLogradouro());
            preparedStatement.setString(2, endereco.getBairro());
            preparedStatement.setString(3, endereco.getCep());
            preparedStatement.setString(   4, endereco.getComplemento());
            preparedStatement.setString(5, endereco.getCidade());
            preparedStatement.setString(6, endereco.getEstado());
            preparedStatement.setString(7, endereco.getPais());


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
