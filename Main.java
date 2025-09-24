import model.Pet;
import model.Tutor;
import java.util.ArrayList;
import java.util.Scanner;
import crud.CadastroPet;
import crud.CadastroTutor;

public class Main {

    final static Scanner SC = new Scanner(System.in);

    static CadastroPet cadastroPet = new CadastroPet();
    static CadastroTutor cadastroTutor = new CadastroTutor();

    public static void main(String[] args) {
        int opcao;

        do {
            limpaTerminal();
            imprimirCabecalho();
            opcao = SC.nextInt();
            switch (opcao) {
                case 1:
                    gerenciarPets();
                    break;
                case 2:
                    gerenciarTutores();
                    break;
                case 3:
                    gerenciarServicos();
                    break;
                case 4:
                    gereciarFuncionarios();
                    break;
            }
        } while (opcao != 0);
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
        System.out.println("4 - Gerenciar Funcionario");
        System.out.println("0 - Sair");
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
        int opcao;
        do {
            limpaTerminal();
            System.out.println("============== PETS ==============");
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Cadastrar Pet");
            System.out.println("2 - Remover Pet");
            System.out.println("3 - Listar Pets");
            System.out.println("0 - Voltar");
            opcao = SC.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarPets();
                    break;
                case 2:
                    removerPets();
                    break;
                case 3:
                    listarPets();
                    break;
                case 4:
                    gereciarFuncionarios();
                    break;
            }
        } while (opcao != 0);
    }

    public static void gerenciarTutores() {
        limpaTerminal();
    }

    public static void gerenciarServicos() {
        limpaTerminal();
    }

    public static void gereciarFuncionarios() {
        limpaTerminal();
    }

    public static void cadastrarPets() {
        limpaTerminal();
        Tutor tuter = new Tutor("Saulo", (byte) 16, "103.817.609-36", "saulo@gmail.com", "9999999");
        tuter.setCpf("103.817.609-36");
        cadastroTutor.novoTutor(tuter);
        System.out.println("============== CADASTRO ==============");
        System.out.printf("Nome: \n");
        String nome = SC.next();
        System.out.printf("Idade: \n");
        byte idade = SC.nextByte();
        System.out.printf("Especie: \n");
        String especie = SC.next();
        System.out.printf("Raça: \n");
        String raca = SC.next();
        System.out.printf("Sexo: \n");
        String sexo = SC.next();
        System.out.printf("Peso: \n");
        double peso = SC.nextDouble();
        System.out.printf("CPF do tutor: \n");
        Tutor tutor = cadastroTutor.buscarPorCPF(SC.next());
        if (tutor != null) {
            Pet pet = new Pet(nome, idade, especie, raca, sexo, peso, tutor);
            cadastroPet.novoPet(pet, tutor);
            System.out.println("Cadastro concluido com sucesso!");
        } else {
            System.out.println("CPF errado ou não cadastrado!");
            System.out.println("Para resolver");
            System.out.println("Verifique se o CPF foi digitado corretamente.");
            System.out.println("Ou");
            System.out.println("Verifique se o tutor foi cadastrado, caso não, cadastre!");
            System.out.println();
        }
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }

    public static void removerPets() {
        limpaTerminal();
        System.out.println("============== REMOÇÃO ==============");
        cadastroPet.listarPets();
        System.out.print("Insira o número de que pet deseja remover: ");
        cadastroPet.removerPet(SC.nextInt());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void listarPets() {
        limpaTerminal();
        System.out.println("============== LISTA DE PETS CADASTRADOS ==============");
        cadastroPet.listarPets();
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }
}