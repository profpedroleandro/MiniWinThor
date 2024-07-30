package repository;

import conexao.Conexao;
import entity.Fornecedor;

import java.sql.*;

public class FornecedorRepository {


        public void cadastroFornecedor(Fornecedor fornecedor) {

            String comandoSQL = "INSERT INTO fornecedor (razaoSocial, nomeFantasia, cnpj, ie) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = null;

            try {
                preparedStatement = Conexao.getMinhaConexao().prepareStatement(comandoSQL);
                preparedStatement.setString(1, fornecedor.getRazaoSocial());
                preparedStatement.setString(2, fornecedor.getNomeFantasia());
                preparedStatement.setString(3, fornecedor.getCnpj());
                preparedStatement.setString(   4, fornecedor.getIe());



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
                System.out.println("****************************** LISTA DE FORNECEDORES ******************************");
                System.out.printf("Cod.Fornecedor \t Razão Social \t  CNPJ \t Ie \t Nome Fantasia \n");
                while (resultSet.next()) {
                    System.out.printf("%d %s %s %s %s\n", resultSet.getInt("idFornecedor"),resultSet.getString("razao_social"), resultSet.getString("cnpj"), resultSet.getString("ie"), resultSet.getString("nome_fantasia"));
                }

                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

