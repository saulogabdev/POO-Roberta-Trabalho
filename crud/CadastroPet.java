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

    public void removerPet(int num) {
        if ((num - 1) >= 0 && (num - 1) < pets.size()) {
            pets.get(num - 1).getTutor().removerPet(pets.get(num - 1).getNome());
            pets.remove(num - 1);
            System.out.println("Pet removido com sucesso!");
        } else {
            System.out.println("Número inválido, tente novamente.");
        }
    }

    public void listarPets() {
        if (pets.isEmpty()) {
            System.out.println("Nenhum pet castrado.");
        } else {
            for (int i = 0; i < pets.size(); i++) {
                System.out.printf("%-3d | %-15s | %-10s | %-15s | %-15s\n", 
                (i + 1), pets.get(i).getNome(), pets.get(i).getEspecie(), pets.get(i).getRaca(), pets.get(i).getTutor().getNome());
            }
        }
    }
}
