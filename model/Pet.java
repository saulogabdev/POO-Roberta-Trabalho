package model;

public class Pet {
    private String nome;
    private byte idade;
    private String especie;
    private String raca;
    private String sexo;
    private double peso;
    private Tutor tutor;

    public Pet(String nome, byte idade, String especie, String raca, String sexo, double peso, Tutor tutor) {
        this.nome = nome;
        this.idade = idade;
        this.especie = especie;
        this.raca = raca;
        this.sexo = sexo;
        this.peso = peso;
        this.tutor = tutor;
    }

    public Pet() {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte getIdade() {
        return idade;
    }

    public void setIdade(byte idade) {
        this.idade = idade;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
    
    public String getRaca() {
        return raca;
    }
}