package model;

import java.util.ArrayList;

public class Tutor extends Pessoa {
    private ArrayList<Pet> pets = new ArrayList<>();
    
    public Tutor(String nome, byte idade, String cpf, String email, String telefone) {
        super(nome, idade, cpf, email, telefone);
    }

    public void listarPets() {
        if (pets.isEmpty()) {
            System.out.println("\u001B[31m"+"Nenhum pet castrado."+"\u001B[0m");
        } else {
            System.out.printf("%-3s | %-15s | %-15s | %-15s | %-15s\n", "ID", "Nome do Pet", "Especie do Pet", "Raça do Pet", "Dono" );
            for (int i = 0; i < pets.size(); i++) {
                System.out.printf("%-3d | %-15s | %-15s | %-15s | %-15s\n", 
                (i + 1), pets.get(i).getNome(), pets.get(i).getEspecie(), pets.get(i).getRaca(), pets.get(i).getTutor().getNome());
            }
        }
    }

    public void removerPet(String nome) {
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getNome().equalsIgnoreCase(nome)) {
                pets.remove(i);
            }
        }
    }

    public void adicionarPet(Pet pet) {
        pets.add(pet);
    }

    public int petSize() {
        return pets.size();
    }


}
