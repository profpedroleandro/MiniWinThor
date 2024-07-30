package repository;
import conexao.Conexao;
import entity.Fornecedor;
import entity.Produto;
import java.sql.*;

public class FornecedorRepository {

    public void inserirFornecedor(Fornecedor fornecedor) {

        String comandoSQL = "INSERT INTO produtos (razao_social, nome_fantasia, cnpj, cidade, estado, cep) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = Conexao.getMinhaConexao().prepareStatement(comandoSQL);
            preparedStatement.setString(1, fornecedor.getRazao_social());
            preparedStatement.setString(2, fornecedor.getNome_fantasia());
            preparedStatement.setInt(3, fornecedor.getCnpj());
            preparedStatement.setString(4, fornecedor.getCidade());
            preparedStatement.setString(5, fornecedor.getEstado());
            preparedStatement.setInt(6, fornecedor.getCep());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void getFornecedores() {

        Statement statement = null;
        Connection connection = Conexao.getMinhaConexao();
        try {
            statement = (Statement) connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String comandoSQL = "SELECT * FROM forncedores";
        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery(comandoSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println();
            System.out.println("****************************** LISTA DE FORNECEDORES ******************************");
            System.out.printf("Cod \t Razão \t CNPJ \t Cep\n");
            while (resultSet.next()) {
                System.out.printf("\n", resultSet.getInt("idForncedor"), resultSet.getString("raza_social"), resultSet.getInt("cep"));
            }

            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void getForncedorById(int id) {
        Statement statement = null;
        Connection connection = Conexao.getMinhaConexao();
        try {
            statement = (Statement) connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String comandoSQL = "SELECT * FROM fornecedores WHERE idFornecedor = " + id;
        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery(comandoSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println();
            System.out.println("****************************** LISTA DE FORNECEDORES ******************************");
            System.out.printf("Cod \t Razão \t CNPJ \t Cep\n");
            while (resultSet.next()) {
                System.out.printf("\n", resultSet.getInt("idForncedor"), resultSet.getString("raza_social"), resultSet.getInt("cep"));
            }

            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);


        }

    }

    public void deletarFornecedor(int id) {

        String comandoSQL = "DELETE FROM forncedores WHERE idFornecedor =" + id;

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = Conexao.getMinhaConexao().prepareStatement(comandoSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
