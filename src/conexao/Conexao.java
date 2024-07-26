package conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Autor: Pedro Leandro
 * Classe de Configuração de Conexão com Banco de Dados MySQL
 */
public class Conexao {

    private static final String url = "jdbc:mysql://localhost:3306/negreiros";
    private static final String usuario = "root";
    private static final String senha = "";

    private static Connection minhaConexao;

    public static Connection getMinhaConexao() {

        try {
            if (minhaConexao == null) {
                minhaConexao = DriverManager.getConnection(url, usuario, senha);
                return minhaConexao;
            }else{
                return minhaConexao;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
