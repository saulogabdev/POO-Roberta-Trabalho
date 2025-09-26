import model.Funcionario;
import model.Pet;
import model.Servico;
import model.Tutor;

import java.net.Socket;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import crud.CadastroFuncionario;
import crud.CadastroPet;
import crud.CadastroServico;
import crud.CadastroTutor;

public class Main {

    final static Scanner SC = new Scanner(System.in);

    static CadastroPet cadastroPet = new CadastroPet();
    static CadastroTutor cadastroTutor = new CadastroTutor(cadastroPet);
    static CadastroServico cadastroServico = new CadastroServico();
    static CadastroFuncionario cadastroFuncionario = new CadastroFuncionario(cadastroServico);
    final static String RESET = "\u001B[0m";
    final static String VERMELHO = "\u001B[31m";
    final static String VERDE = "\u001B[32m";

    public static void main(String[] args) {
        int opcao;
        Tutor tutor = new Tutor("Saulo", (byte)16, "1", "sla", "sla");
        cadastroTutor.novoTutor(tutor);
        Funcionario funcionario = new Funcionario("Roberto", (byte)19, "2", "sla", "sla", "sla");
        cadastroFuncionario.novoFuncionario(funcionario);
        Pet pet = new Pet("Teddy", (byte)2, "sla", "sla", "sla", 2.9, tutor);
        cadastroPet.novoPet(pet, tutor);

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
            }
        } while (opcao != 0);
    }

    public static void gerenciarTutores() {
        int opcao;
        do {
            limpaTerminal();
            System.out.println("============== TUTORES ==============");
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Cadastrar Tutor");
            System.out.println("2 - Remover Tutor");
            System.out.println("3 - Listar Tutores");
            System.out.println("4 - Listar Pets Tutor");
            System.out.println("0 - Voltar");
            opcao = SC.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarTutores();
                    break;
                case 2:
                    removerTutores();
                    break;
                case 3:
                    listarTutores();
                    break;
                case 4:
                    listarPetDosTutores();
                    break;
            }
        } while (opcao != 0);
    }

    public static void gerenciarServicos() {
        int opcao;
        do {
            limpaTerminal();
            System.out.println("============== SERVIÇOS ==============");
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Cadastrar serviço");
            System.out.println("2 - Listar serviços");
            System.out.println("3 - Remover serviço");
            System.out.println("4 - Concluir serviço");
            System.out.println("5 - Listar serviços ativos");
            System.out.println("0 - Voltar");
            opcao = SC.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarServico();
                    break;
                case 2:
                    listarServicos();
                    break;
                case 3:
                    removerServico();
                    break;
                case 4:
                    concluirServico();
                    break;
                case 5:
                    listarServicosAtivos();
                    break;
            }
        } while (opcao != 0);
    }

    public static void gereciarFuncionarios() {
        int opcao;
        do {
            limpaTerminal();
            System.out.println("============== FUNCIONÁRIOS ==============");
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Remover funcionário");
            System.out.println("3 - Listar funcionário");
            System.out.println("4 - Listar serviços para o funcionário");
            System.out.println("0 - Voltar");
            opcao = SC.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    removerFuncionarios();
                    break;
                case 3:
                    listarFuncionarios();
                    break;
                case 4:
                    listarServicosDoFuncionario();
                    break;
            }
        } while (opcao != 0);
    }

    public static void cadastrarPets() {
    limpaTerminal();
    System.out.println("============== CADASTRO PET ==============");
    String nome = "";
    byte idade = 0;
    String especie = "";
    String raca = "";
    String sexo = "";
    double peso = 0;
    Tutor tutor = null;
    System.out.printf("Nome: \n");
    nome = SC.next();
    while (true) {
        try {
            System.out.printf("Idade: \n");
            idade = SC.nextByte();
            break;
        } catch (InputMismatchException e) {
            System.out.println(VERMELHO + "Idade inválida! Digite um número inteiro." + RESET);
            SC.nextLine(); 
        }
    }
    System.out.printf("Especie: \n");
    especie = SC.next();
    System.out.printf("Raça: \n");
    raca = SC.next();
    System.out.printf("Sexo: \n");
    sexo = SC.next();
    while (true) {
        try {
            System.out.printf("Peso: \n");
            peso = SC.nextDouble();
            break;
        } catch (InputMismatchException e) {
            System.out.println(VERMELHO + "Peso inválido! Digite um número válido (ex: 4,5)." + RESET);
            SC.nextLine(); 
        }
    }
    System.out.printf("CPF do tutor (0 para cancelar): \n");
    String cpf = SC.next();
    if (cpf.equals("0")) return;
    tutor = cadastroTutor.buscarPorCPF(cpf);
    if (tutor != null) {
        Pet pet = new Pet(nome, idade, especie, raca, sexo, peso, tutor);
        cadastroPet.novoPet(pet, tutor);
        System.out.println(VERDE + "Cadastro concluído com sucesso!" + RESET);
    } else {
        System.out.println();
        System.out.println(VERMELHO + "CPF não encontrado!");
        System.out.println("Possíveis motivos:");
        System.out.println(" - O CPF foi digitado incorretamente;");
        System.out.println(" - O tutor ainda não foi cadastrado.");
        System.out.println("Tente novamente ou cadastre um novo tutor." + RESET);
        System.out.println();
    }
    System.out.println("Insira qualquer caracter para sair!");
    SC.nextLine();
    SC.next();
}


    public static void removerPets() {
        limpaTerminal();
        System.out.println("============== REMOÇÃO ==============");
        cadastroPet.listarPets();
        if (!cadastroPet.isCadastroVazio()) {
            System.out.print("Insira o ID de que pet deseja remover: ");
            int id = SC.nextInt();
            if (id == 0) {
                return;
            }
            cadastroPet.removerPet(SC.nextInt());
        }
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }

    public static void listarPets() {
        limpaTerminal();
        System.out.println("============== LISTA DE PETS CADASTRADOS ==============");
        cadastroPet.listarPets();
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }

    public static void cadastrarTutores() {
        limpaTerminal();
        System.out.println("============== CADASTRO TUTOR ==============");
        String nome = "";
        while (true) {
            try {
                System.out.print("Nome: ");
                nome = SC.next();
                break;
            } catch (Exception e) {
                System.out.println("\u001B[31mEntrada inválida para nome. Tente novamente.\u001B[0m");
                SC.nextLine();
            }
        }
        byte idade = 0;
        while (true) {
            try {
                System.out.print("Idade: ");
                idade = SC.nextByte();
                break;
            } catch (Exception e) {
                System.out.println("\u001B[31mEntrada inválida para idade. Digite apenas números.\u001B[0m");
                SC.nextLine();
            }
        }
        String cpf = "";
        while (true) {
            try {
                System.out.print("CPF: ");
                cpf = SC.next();
                if (cpf.equals("0")) {
                    return;
                }
                if (cadastroTutor.buscarPorCPF(cpf) != null) {
                    System.out.println("\u001B[31mCPF já existente, tente outro! (ou digite 0 para cancelar)\u001B[0m");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("\u001B[31mEntrada inválida para CPF. Tente novamente.\u001B[0m");
                SC.nextLine();
            }
        }
        String email = "";
        while (true) {
            try {
                System.out.print("Email: ");
                email = SC.next();
                break;
            } catch (Exception e) {
                System.out.println("\u001B[31mEntrada inválida para email. Tente novamente.\u001B[0m");
                SC.nextLine();
            }
        }
        String telefone = "";
        while (true) {
            try {
                System.out.print("Telefone (0 para cancelar): ");
                telefone = SC.next();
                if (telefone.equals("0")) {
                    return;
                }
                break;
            } catch (Exception e) {
                System.out.println("\u001B[31mEntrada inválida para telefone. Tente novamente.\u001B[0m");
                SC.nextLine();
            }
        }
        Tutor tutor = new Tutor(nome, idade, cpf, email, telefone);
        cadastroTutor.novoTutor(tutor);

        System.out.println(VERDE + "Tutor cadastrado com sucesso!" + RESET);
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }

    public static void removerTutores() {
        limpaTerminal();
        System.out.println("============== REMOÇÃO ==============");
        cadastroTutor.listarTutores();
        if (!cadastroTutor.isCadastroVazio()) {
            int id;
            while (true) {
            try {
                System.out.print("Insira o ID de que tutor deseja remover (0 para cancelar): ");
                id = SC.nextInt();
                if (id == 0) {
                    return;
                }
                cadastroTutor.removerTutor(id);
                break;
            } catch (Exception e) {
                System.out.println("\u001B[31mEntrada inválida para ID. Tente novamente.\u001B[0m");
                SC.nextLine();
            }
        }
        }
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }

    public static void listarTutores() {
        limpaTerminal();
        System.out.println("============== LISTA DE TUTORES CADASTRADOS ==============");
        cadastroTutor.listarTutores();
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }

    public static void listarPetDosTutores() {
    limpaTerminal();
    System.out.println("============== LISTA DE TUTORES CADASTRADOS ==============");
    cadastroTutor.listarTutores();
    if (!cadastroTutor.isCadastroVazio()) {
        int num = -1;
        while (true) {
            try {
                System.out.print("Insira o ID de que tutor deseja ver os pets: ");
                num = SC.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31mEntrada inválida! Digite apenas números inteiros.\u001B[0m");
                SC.nextLine();
            }
        }
        limpaTerminal();
        if (!cadastroTutor.isTutorSemPet(num)) {
            System.out.printf("============== LISTA DE PETS CADASTRADOS NO TUTOR %s ==============\n",
                    cadastroTutor.getTutor(num).getNome());
        }
        cadastroTutor.listarPetTutor(num);
    }
    System.out.println("Insira qualquer caracter para sair!");
    SC.next();
}


    public static void cadastrarServico() {
    limpaTerminal();
    Funcionario funcionario = null;
    Pet pet = null;
    System.out.println("============== CADASTRO SERVIÇO ==============");
    String tipoServico = "";
    String data = "";
    float valor = 0f;
    while (true) {
        try {
            System.out.print("Tipo do serviço: ");
            tipoServico = SC.next();
            break;
        } catch (Exception e) {
            System.out.println(VERMELHO + "Entrada inválida, tente novamente." + RESET);
            SC.nextLine();
        }
    }
    while (true) {
        try {
            System.out.print("Data do serviço: ");
            data = SC.next();
            break;
        } catch (Exception e) {
            System.out.println(VERMELHO + "Entrada inválida, tente novamente." + RESET);
            SC.nextLine();
        }
    }
    while (true) {
        try {
            System.out.print("Valor do serviço: ");
            valor = SC.nextFloat();
            SC.nextLine();
            break;
        } catch (InputMismatchException e) {
            System.out.println(VERMELHO + "Valor inválido! Digite apenas números (ex: 50.00)." + RESET);
            SC.nextLine();
        }
    }
    while (true) {
        System.out.print("CPF do funcionário: ");
        String cpf = SC.next();
        funcionario = cadastroFuncionario.buscarPorCPF(cpf);
        if (funcionario != null) {
            break;
        } else {
            System.out.println(VERMELHO + "CPF não encontrado!");
            System.out.println("Possíveis motivos:");
            System.out.println(" - O CPF foi digitado incorretamente;");
            System.out.println(" - O funcionário ainda não foi cadastrado.");
            System.out.println("Tente novamente ou cadastre um novo funcionário." + RESET);
        }
    }
    while (true) {
        try {
            cadastroPet.listarPets();
            System.out.print("Insira o ID do pet que receberá o serviço (0 para cancelar): ");
            int num = SC.nextInt();
            if (num == 0) {
                System.out.println("Cadastro de serviço cancelado.");
                return;
            }
            pet = cadastroPet.getPet(num);
            if (pet != null) {
                break;
            } else {
                System.out.println(VERMELHO + "Número inválido! Tente novamente." + RESET);
            }
        } catch (InputMismatchException e) {
            System.out.println(VERMELHO + "Entrada inválida! Digite apenas números inteiros." + RESET);
            SC.nextLine();
        }
    }
    Servico servico = new Servico(tipoServico, data, valor, pet, funcionario);
    cadastroServico.novoServico(servico);
    System.out.println(VERDE + "Serviço cadastrado com sucesso!" + RESET);
    System.out.println("Insira qualquer caracter para sair!");
    SC.next();
}


    public static void listarServicos() {
        limpaTerminal();
        System.out.println("============== LISTA DE SERVIÇOS CADASTRADOS ==============");
        cadastroServico.listarServico();
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }

    public static void removerServico() {
        limpaTerminal();
        System.out.println("============== REMOÇÃO ==============");
        cadastroServico.listarServico();
        if (!cadastroServico.isVazio()) {
            System.out.print("Insira o ID do serviço que quer remover (0 para cancelar): ");
            int num = SC.nextInt();
            if (num == 0) {
                return;
            }
            cadastroServico.removerServico(num);
        }
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }

    public static void concluirServico() {
        limpaTerminal();
        System.out.println("============== CONCLUIR SERVIÇOS ==============");
        if (cadastroServico.listarServicosAtivos()) {
            System.out.print("Insira o ID do serviço que quer concluir (0 para cancelar): ");
            int num = SC.nextInt();
            if (num == 0) {
                return;
            }
            cadastroServico.concluirServico(num);
        }
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }

    public static void listarServicosAtivos() {
        limpaTerminal();
        System.out.println("============== LISTAR SERVIÇOS ATIVOS ==============");
        cadastroServico.listarServicosAtivos();
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }

    public static void cadastrarFuncionario() {
    limpaTerminal();
    System.out.println("============== CADASTRO FUNCIONÁRIO ==============");
    String nome = "";
    byte idade = 0;
    String cpf = "";
    String email = "";
    String telefone = "";
    String cargo = "";
    System.out.printf("Nome: \n");
    nome = SC.next();
    while (true) {
        try {
            System.out.printf("Idade: \n");
            idade = SC.nextByte();
            break; 
        } catch (InputMismatchException e) {
            System.out.println(VERMELHO + "Idade inválida! Digite um número inteiro." + RESET);
            SC.nextLine();
        }
    }
    while (true) {
        System.out.printf("CPF: \n");
        cpf = SC.next();
        if (cpf.equals("0")) {
            return; 
        }
        if (cadastroFuncionario.buscarPorCPF(cpf) == null) {
            break; 
        }
        System.out.println(VERMELHO + "CPF já existente, tente outro! (0 para cancelar cadastro)" + RESET);
    }
    System.out.printf("Email: \n");
    email = SC.next();
    System.out.printf("Telefone: \n");
    telefone = SC.next();
    System.out.printf("Cargo (0 para cancelar): \n");
    cargo = SC.next();
    if (cargo.equals("0")) {
        return;
    }
    Funcionario funcionario = new Funcionario(nome, idade, cpf, email, telefone, cargo);
    cadastroFuncionario.novoFuncionario(funcionario);
    System.out.println(VERDE + "Funcionário cadastrado com sucesso!" + RESET);
    System.out.println("Insira qualquer caracter para sair!");
    SC.next();
}


    public static void removerFuncionarios() {
        limpaTerminal();
        System.out.println("============== REMOÇÃO ==============");
        cadastroFuncionario.listarFuncionarios();
        if (!cadastroFuncionario.isVazio()) {
            System.out.print("Insira o ID do funcionário que deseja remover (0 para cancelar): ");
            int num = SC.nextInt();
            if (num == 0) {
                return;
            }
            cadastroFuncionario.removeFuncionario(num);
        }
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }

    public static void listarFuncionarios() {
        limpaTerminal();
        System.out.println("============== LISTAR FUNCIONÁRIOS ==============");
        cadastroFuncionario.listarFuncionarios();
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }

    public static void listarServicosDoFuncionario() {
        limpaTerminal();
        System.out.println("============== LISTAR SERVIÇOS DO FUNCIONARIO ==============");
        cadastroFuncionario.listarFuncionarios();
        System.out.print("Insira o ID do funcionário visualizar os serviços: ");
        int num = SC.nextInt();
        limpaTerminal();
        System.out.println("============== LISTA DE SERVIÇOS ==============");
        cadastroFuncionario.listarServicosFuncionario(num);
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }

}