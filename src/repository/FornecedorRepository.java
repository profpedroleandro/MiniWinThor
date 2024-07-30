package repository;

import conexao.Conexao;
import entity.Fornecedor;


import java.sql.*;

public class FornecedorRepository {

    public void cadastrarFornecedor(Fornecedor fornecedor) {

        String comandoSQL = "INSERT INTO fornecedores (`cnpj`, `razao_social`, `nome_fantasia`, `cidade`, `inscricao_estadual`) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = Conexao.getMinhaConexao().prepareStatement(comandoSQL);
            preparedStatement.setString(1, fornecedor.getCnpj());
            preparedStatement.setString(2, fornecedor.getRazao_social());
            preparedStatement.setString(3, fornecedor.getNome_fantasia());
            preparedStatement.setString(4, fornecedor.getCidade());
            preparedStatement.setString(5, fornecedor.getInscricao_estadual());

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

        String comandoSQL = "SELECT * FROM fornecedores";
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
