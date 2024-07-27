import entity.Produto;
import support.CadastroEndereco;
import support.Menu;

public class Main {
    public static void main(String[] args) {

        Produto produto = new Produto();

        CadastroEndereco.cadastroEndereco();

        Menu.menu();

    }
}