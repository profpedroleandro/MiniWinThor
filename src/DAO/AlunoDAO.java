package DAO;

import conexao.Conexao;
import entity.Aluno;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDAO {

    public void inserirAluno(Aluno aluno) {

        String comandoSQL = "INSERT INTO alunos (cpf, nome, sexo, cidade, estado) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = Conexao.getMinhaConexao().prepareStatement(comandoSQL);
            preparedStatement.setString(1, aluno.getCpf());
            preparedStatement.setString(2, aluno.getNome());
            preparedStatement.setString(3, aluno.getSexo());
            preparedStatement.setString(4, aluno.getCidade());
            preparedStatement.setString(5, aluno.getEstado());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
