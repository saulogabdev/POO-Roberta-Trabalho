import model.Pet;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    final static Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        int answr;
        
        imprimirCabecalho();
        answr = SC.nextInt();

        switch (answr) {
            case 1:
                gerenciarPets();
                break;
            case 2:
                gerenciarTutores();
                break;
            case 3:
                gerenciarServicos();
                break;
        }
    }

    public static void imprimirCabecalho() {
        System.out.println(" ____  ____  ____        ____   __  ____  ____  _  _   __   ____  ____ \n" + //
                        "(  _ \\(  __)(_  _)      / ___) /  \\(  __)(_  _)/ )( \\ / _\\ (  _ \\(  __)\n" + //
                        " ) __/ ) _)   )(        \\___ \\(  O )) _)   )(  \\ /\\ //    \\ )   / ) _) \n" + //
                        "(__)  (____) (__)       (____/ \\__/(__)   (__) (_/\\_)\\_/\\_/(__\\_)(____)");
        System.out.println();
        System.out.println("1 - Gerenciar Pets");
        System.out.println("2 - Gerenciar Tutores");
        System.out.println("3 - Gerenciar Serviço");
        System.out.println();
        System.out.print("O que deseja fazer: ");
    }

    public static void limpaTerminal() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.print("\033\143");
    }

    public static void gerenciarPets() {
        limpaTerminal();
    }

    public static void gerenciarTutores() {
        limpaTerminal();
    }

    public static void gerenciarServicos() {
        limpaTerminal();
    }
}