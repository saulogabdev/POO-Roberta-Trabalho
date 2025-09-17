

public class Pet {
    private String nome;
    private byte idade;
    private String especie;
    private String sexo;
    private double peso;

    public Pet(String nome, byte idade, String especie, String sexo, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.especie = especie;
        this.sexo = sexo;
        this.peso = peso;
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

}