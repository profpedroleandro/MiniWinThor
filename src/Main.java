import support.Util;

public class Main {

    public static void main(String[] args) {

        boolean sair = false;

        do{
            Util.menu();
            sair = Util.sair();
        }while(!sair);

    }

}