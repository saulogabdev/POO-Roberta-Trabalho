package model;

import java.util.ArrayList;

public class Tutor extends Pessoa {
    private ArrayList<Pet> pets = new ArrayList<>();
    
    public Tutor(String nome, byte idade, String cpf, String email, String telefone) {
        super(nome, idade, cpf, email, telefone);
    }

    public void adicionarPet(Pet pet) {
        pets.add(pet);
    }
}
