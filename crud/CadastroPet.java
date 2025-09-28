package crud;

import java.util.ArrayList;
import model.Pet;
import model.Tutor;

public class CadastroPet {
    private ArrayList<Pet> pets = new ArrayList<>();

    int petsSize = pets.size();

    public void novoPet(Pet pet, Tutor tutor) {
        pets.add(pet);
        tutor.adicionarPet(pet);
    }

    public boolean isCadastroVazio() {
        return pets.isEmpty() ? true : false;
    }

    public void removerPet(int num) {
        if (pets.isEmpty()) {
            return;
        }

        if ((num - 1) >= 0 && (num - 1) < pets.size()) {
            pets.get(num - 1).getTutor().removerPet(pets.get(num - 1).getNome());
            pets.remove(num - 1);
            System.out.println("\u001B[32 mPet removido com sucesso!\u001B[0m");
        } else {
            System.out.println("\u001B[31mNúmero inválido, tente novamente.\u001B[0m");
        }
    }

    public Pet getPet(int num) {
        if (num <= 0 || num > pets.size()) {
            System.out.println("\u001B[31m" + "Número inválido! Nenhum pet encontrado." + "\u001B[0m");
            return null;
        }
        return pets.get(num - 1);
    }

    public void listarPets() {
    if (pets.isEmpty()) {
        System.out.println("\u001B[31m" + "Nenhum pet cadastrado." + "\u001B[0m");
    } else {
        System.out.printf("%-3s | %-15s | %-5s | %-10s | %-15s | %-10s | %-8s | %-15s\n",
                "ID", "Nome", "Idade", "Espécie", "Raça", "Sexo", "Peso", "Tutor");
        for (int i = 0; i < pets.size(); i++) {
            Pet p = pets.get(i);
            System.out.printf("%-3d | %-15s | %-5d | %-10s | %-15s | %-10s | %-8.2f | %-15s\n",
                    (i + 1), p.getNome(), p.getIdade(), p.getEspecie(), p.getRaca(),
                    p.getSexo(), p.getPeso(), p.getTutor().getNome());
        }
    }
}


    public void removerPetPorTutor(Tutor tutor) {
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getTutor().equals(tutor)) {
                pets.remove(i);
                i--;
            }
        }
    }
}
