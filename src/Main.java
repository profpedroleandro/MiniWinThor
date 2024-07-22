import DAO.AlunoDAO;
import entity.Aluno;

public class Main {

    public static void main(String[] args) {

        Aluno aluno = new Aluno();

        aluno.setCpf("18836132057");
        aluno.setNome("Pedro Leandro Gomes da Silva");
        aluno.setSexo("M");
        aluno.setCidade("Caxias");
        aluno.setEstado("MA");

        new AlunoDAO().inserirAluno(aluno);

        System.out.println("Aluno cadastrado com sucesso!");

    }

}