import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int opcao;
        Scanner scanner = new Scanner(System.in);

        Util.menu_principal();
        System.out.println("\nDigite a opção desejada: ");
        opcao = scanner.nextInt();
        scanner.nextLine();
        Util.escolhas_menu_principal(opcao);

    }
}