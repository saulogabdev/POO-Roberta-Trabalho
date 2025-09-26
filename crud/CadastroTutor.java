package crud;

import model.Tutor;
import java.util.ArrayList;

public class CadastroTutor {
    private ArrayList<Tutor> tutores = new ArrayList<>();
    private CadastroPet cadastroPet;

    public CadastroTutor(CadastroPet cadastroPet) {
        this.cadastroPet = cadastroPet;
    }

    public void novoTutor(Tutor tutor) {
        tutores.add(tutor);
    }

    public void removerTutor(int num) {
        if (tutores.isEmpty()) {
            return;
        }

        if ((num - 1) >= 0 && (num - 1) < tutores.size()) {
            cadastroPet.removerPetPorTutor(tutores.get(num - 1));
            tutores.remove(num - 1);
            System.out.println("\u001B[32m"+"Tutor removido com sucesso!"+"\u001B[0m");
        } else {
            System.out.println("\u001B[31m"+"Número inválido, tente novamente."+"\u001B[0m");
        }
    }

    public Tutor getTutor(int num) {
        if (num <= 0 || num > tutores.size()) {
            System.out.println("\u001B[31m" + "Número inválido! Nenhum tutor encontrado." + "\u001B[0m");
            return null;
        }
        return tutores.get(num - 1);
    }

    public boolean isCadastroVazio() {
        return tutores.isEmpty() ? true : false;
    }

    public void listarTutores() {
        if (tutores.isEmpty()) {
            System.out.println("\u001B[31m" + "Nenhum tutor castrado." + "\u001B[0m");
        } else {
            System.out.printf("%-3s | %-15s | %-5s | %-20s | %-25s | %-20s\n", "ID", "Nome", "Idade", "CPF", "Email",
                    "Telefone");
            for (int i = 0; i < tutores.size(); i++) {
                System.out.printf("%-3s | %-15s | %-5d | %-20s | %-25s | %-20s\n",
                        (i + 1),
                        tutores.get(i).getNome(),
                        tutores.get(i).getIdade(),
                        tutores.get(i).getCpf(),
                        tutores.get(i).getEmail(),
                        tutores.get(i).getTelefone());
            }
        }
    }

    public void listarPetTutor(int num) {
        tutores.get(num - 1).listarPets();
    }

    public boolean isTutorSemPet(int num) {
        if (tutores.get(num - 1).petSize() == 0) {
            return true;
        }
        return false;
    }

    public Tutor buscarPorCPF(String cpf) {
        cpf = cpf.replaceAll("\\D", "");
        for (Tutor tutor : tutores) {
            if (tutor.getCpf().equals(cpf)) {
                return tutor;
            }
        }
        return null;
    }

}