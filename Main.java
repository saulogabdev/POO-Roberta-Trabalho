import model.Funcionario;
import model.Pet;
import model.Servico;
import model.Tutor;

import java.net.Socket;
import java.util.ArrayList;
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
            System.out.println(VERDE + "Cadastro concluido com sucesso!" + RESET);
        } else {
            System.out.println();
            System.out.println(VERMELHO + " CPF não encontrado!");
            System.out.println("Possíveis motivos:");
            System.out.println(" - O CPF foi digitado incorretamente;");
            System.out.println(" - O tutor ainda não foi cadastrado.");
            System.out.println("Tente novamente ou cadastre um novo tutor." + RESET);
            System.out.println();
        }
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }

    public static void removerPets() {
        limpaTerminal();
        System.out.println("============== REMOÇÃO ==============");
        cadastroPet.listarPets();
        if (!cadastroPet.isCadastroVazio()) {
            System.out.print("Insira o ID de que pet deseja remover: ");
            cadastroPet.removerPet(SC.nextInt());
        }
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }

    // ADICIONAR CPF DO DONO
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
                System.out.print("Telefone: ");
                telefone = SC.next();
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
            System.out.print("Insira o ID de que tutor deseja remover: ");
            cadastroTutor.removerTutor(SC.nextInt());
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
            System.out.print("Insira o ID de que tutor deseja ver os pets: ");
            int num = SC.nextInt();
            limpaTerminal();
            if (!cadastroTutor.isTutorSemPet(num)) {
                System.out.printf("============== LISTA DE PETS CADASTRADOS NO TUTOR %S  ==============\n",
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
        System.out.print("Tipo do serviço: ");
        String tipoServico = SC.next();
        System.out.print("Data do serviço: ");
        String data = SC.next();
        System.out.print("Valor do serviço: ");
        float valor = SC.nextFloat();
        SC.nextLine();
        while (funcionario == null) {
            System.out.print("CPF do funcionário: ");
            String cpf = SC.next();
            funcionario = cadastroFuncionario.buscarPorCPF(cpf);
            if (funcionario == null) {
                System.out.println(VERMELHO + "CPF não encontrado!");
                System.out.println("Possíveis motivos:");
                System.out.println(" - O CPF foi digitado incorretamente;");
                System.out.println(" - O funcionário ainda não foi cadastrado.");
                System.out.println("Tente novamente ou cadastre um novo funcionário." + RESET);
            }
        }
        while (pet == null) {
            cadastroPet.listarPets();
            System.out.print("Insira o ID do pet que receberá o serviço (0 para cancelar): ");
            int num = SC.nextInt();
            if (num == 0) {
                System.out.println("Cadastro de serviço cancelado.");
                return;
            }
            pet = cadastroPet.getPet(num);
            if (pet == null) {
                System.out.println(VERMELHO + "Número inválido! Tente novamente." + RESET);
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
        System.out.println("============== REMOÇÃO ==============");
        cadastroServico.listarServico();
        if (!cadastroServico.isVazio()) {
            System.out.print("Insira o ID do serviço que quer remover: ");
            int num = SC.nextInt();
            cadastroServico.removerServico(num);
        }
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }

    public static void concluirServico() {
        limpaTerminal();
        System.out.println("============== CONCLUIR SERVIÇOS ==============");
        if (cadastroServico.listarServicosAtivos()) {
            System.out.print("Insira o ID do serviço que quer concluir: ");
            int num = SC.nextInt();
            cadastroServico.removerServico(num);
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
        System.out.printf("Nome: \n");
        String nome = SC.next();
        System.out.printf("Idade: \n");
        byte idade = SC.nextByte();
        System.out.printf("CPF: \n");
        String cpf = SC.next();
        while (cadastroFuncionario.buscarPorCPF(cpf) != null) {
            System.out.println("CPF já existente, tente outro! (0 para cancelar cadastro)");
            cpf = SC.next();
            if (cpf.equals("0")) {
                return;
            }
        }
        System.out.printf("Email: \n");
        String email = SC.next();
        System.out.printf("Telefone: \n");
        String telefone = SC.next();
        System.out.printf("Cargo: \n");
        String cargo = SC.next();
        // fazer a verificacao de cpf ja existente
        Funcionario funcionario = new Funcionario(nome, idade, cpf, email, telefone, cargo);
        cadastroFuncionario.novoFuncionario(funcionario);
        System.out.println(VERDE + "Funcionario cadastrado com sucesso!" + RESET);
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }

    public static void removerFuncionarios() {
        limpaTerminal();
        System.out.println("============== REMOÇÃO ==============");
        cadastroFuncionario.listarFuncionarios();
        if (!cadastroFuncionario.isVazio()) {
            System.out.print("Insira o ID do funcionário que deseja remover: ");
            int num = SC.nextInt();
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
        cadastroFuncionario.listarServicosFuncionario(num);
        System.out.println("Insira qualquer caracter para sair!");
        SC.next();
    }

}