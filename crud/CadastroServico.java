package crud;

import java.util.ArrayList;

import model.Funcionario;
import model.Servico;

public class CadastroServico {
    private ArrayList<Servico> servicos = new ArrayList<>();

    public void novoServico(Servico servico) {
        servicos.add(servico);
    }

    public boolean isVazio() {
        return servicos.isEmpty();
    }

    public void removerServico(int num) {
        if (servicos.isEmpty()) {
            System.out.println("\u001B[31mNenhum serviço cadastrado.\u001B[0m");
            return;
        }

        if (num > 0 && num <= servicos.size()) {
            servicos.remove(num - 1);
            System.out.println("\u001B[32mServiço removido com sucesso!\u001B[0m");
        } else {
            System.out.println("\u001B[31mNúmero inválido, tente novamente.\u001B[0m");
        }
    }

    public void listarServico() {
        if (servicos.isEmpty()) {
            System.out.println("\u001B[31mNenhum serviço cadastrado.\u001B[0m");
        } else {
            System.out.printf("%-3s | %-15s | %-12s | %-10s | %-15s | %-20s | %-10s\n",
                    "ID", "Tipo", "Data", "Valor", "Pet", "Funcionário", "Status");

            for (int i = 0; i < servicos.size(); i++) {
                Servico s = servicos.get(i);
                System.out.printf("%-3d | %-15s | %-12s | R$%-8.2f | %-15s | %-20s | %-10s\n",
                        (i + 1),
                        s.getTipoServico(),
                        s.getData(),
                        s.getValor(),
                        s.getPet().getNome(),
                        s.getFuncionario().getNome(),
                        s.isStatusServico() ? "Ativo" : "Concluído");
            }
        }
    }

    public void removerServicoPorFuncionario(Funcionario funcionario) {
        for (int i = 0; i < servicos.size(); i++) {
            if (servicos.get(i).getFuncionario().equals(funcionario)) {
                removerServico(i);
                i--;
            }
        }
    }

    public boolean listarServicosAtivos() {
        boolean encontrou = false;
        if (servicos.isEmpty()) {
            System.out.println("\u001B[31mNenhum serviço cadastrado.\u001B[0m");
        } else {
            System.out.printf("%-3s | %-15s | %-5s | %-20s | %-25s | %-20s | %-15s\n",
                    "ID", "Tipo", "Data", "Valor", "Pet", "Funcionário", "Status");
            for (int i = 0; i < servicos.size(); i++) {
                Servico s = servicos.get(i);
                if (s.isStatusServico()) {
                    encontrou = true;
                    System.out.printf("%-3d | %-15s | %-12s | R$%-8.2f | %-15s | %-15s | %-10s\n",
                            (i + 1),
                            s.getTipoServico(),
                            s.getData(),
                            s.getValor(),
                            s.getPet().getNome(),
                            s.getFuncionario().getNome(),
                            s.isStatusServico() ? "Ativo" : "Concluido");
                }
            }
            if (!encontrou) {
                System.out.println("\u001B[31mNenhum serviço ativo encontrado.\u001B[0m");
            }

        }
        return encontrou;
    }

    public void listarServicosFuncionario(Funcionario funcionario) {
        boolean encontrou = false;
        System.out.printf("%-3s | %-15s | %-12s | %-7s | %-15s | %-10s\n",
                "ID", "Tipo", "Data", "Valor", "Pet", "Status");

        for (int i = 0; i < servicos.size(); i++) {
            Servico s = servicos.get(i);
            if (s.isStatusServico() && s.getFuncionario().equals(funcionario)) {
                encontrou = true;
                System.out.printf("%-3d | %-15s | %-12s | R$%-6d | %-15s | %-10s\n",
                        (i + 1),
                        s.getTipoServico(),
                        s.getData(),
                        s.getValor(),
                        s.getPet(),
                        s.isStatusServico() ? "Ativo" : "Concluído");
            }
        }

        if (!encontrou) {
            System.out.println("\u001B[31mNenhum serviço encontrado para este funcionário.\u001B[0m");
        }
    }
}
