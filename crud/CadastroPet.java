package crud;

import java.util.ArrayList;
import model.Pet;
import model.Tutor;

public class CadastroPet {
    ArrayList<Pet> pets = new ArrayList<>();

    public void novoPet(Pet pet, Tutor tutor) {
        pets.add(pet);
        tutor.adicionarPet(pet);
    }

    

    public void listarPets() {
        for (int i = 0; i < pets.size(); i++) {
            System.out.printf("%d | %s | %s | %s | %s \n", (i + 1), pets.get(i).getNome(), pets.get(i).getEspecie(), pets.get(i).getRaca(), pets.get(i).getTutor().getNome());
        }
    }
}
