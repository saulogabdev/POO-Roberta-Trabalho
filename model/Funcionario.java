package model;

public class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario(String nome, byte idade, String cpf, String email, String telefone, String cargo) {
        super(nome, idade, cpf, email, telefone);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
 
}
