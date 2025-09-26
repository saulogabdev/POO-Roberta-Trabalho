package crud;

import java.util.ArrayList;

import model.Funcionario;
import model.Servico;

public class CadastroFuncionario {
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private CadastroServico cadastroServico;

    public CadastroFuncionario(CadastroServico cadastroServico) {
        this.cadastroServico = cadastroServico;
    }

    public void novoFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public Funcionario getFuncionario(int num) {
        if (num <= 0 || num > funcionarios.size()) {
            System.out.println("\u001B[31m" + "Número inválido! Nenhum funcionário encontrado." + "\u001B[0m");
            return null;
        }
        return funcionarios.get(num - 1);
    }

    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("\u001B[31m" + "Nenhum funcionário cadastrado." + "\u001B[0m");
        } else {
            System.out.printf("%-3s | %-15s | %-5s | %-20s | %-25s | %-20s | %-15s\n",
                    "ID", "Nome", "Idade", "CPF", "Email", "Telefone", "Cargo");
            for (int i = 0; i < funcionarios.size(); i++) {
                Funcionario f = funcionarios.get(i);
                System.out.printf("%-3d | %-15s | %-5d | %-20s | %-25s | %-20s | %-15s\n",
                        (i + 1),
                        f.getNome(),
                        f.getIdade(),
                        f.getCpf(),
                        f.getEmail(),
                        f.getTelefone(),
                        f.getCargo());
            }
        }
    }

    public Funcionario buscarPorCPF(String cpf) {
        cpf = cpf.replaceAll("\\D", "");
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;
            }
        }
        return null;
    }

    public void listarServicosFuncionario(int num) {
        cadastroServico.listarServicosFuncionario(funcionarios.get(num - 1));
    }

    public void removeFuncionario(int num) {
        if (funcionarios.isEmpty()) {
            System.out.println("\u001B[31mNenhum funcionário cadastrado.\u001B[0m");
            return;
        }

        if (num > 0 && num <= funcionarios.size()) {
            cadastroServico.removerServicoPorFuncionario(funcionarios.get(num - 1));
            funcionarios.remove(num - 1);
            System.out.println("\u001B[32mFuncionário removido com sucesso!\u001B[0m");
        } else {
            System.out.println("\u001B[31mNúmero inválido, tente novamente.\u001B[0m");
        }
    }

    public boolean isVazio() {
        return funcionarios.isEmpty();
    }


}
