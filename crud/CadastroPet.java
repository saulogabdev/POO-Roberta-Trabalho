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
            System.out.println("Pet removido com sucesso!");
        } else {
            System.out.println("Número inválido, tente novamente.");
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
            System.out.println("\u001B[31m" + "Nenhum pet castrado." + "\u001B[0m");
        } else {
            System.out.printf("%-3s | %-15s | %-15s | %-15s | %-15s\n", "ID", "Nome do Pet", "Especie do Pet",
                    "Raça do Pet", "Dono");
            for (int i = 0; i < pets.size(); i++) {
                System.out.printf("%-3d | %-15s | %-15s | %-15s | %-15s\n",
                        (i + 1), pets.get(i).getNome(), pets.get(i).getEspecie(), pets.get(i).getRaca(),
                        pets.get(i).getTutor().getNome());
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
