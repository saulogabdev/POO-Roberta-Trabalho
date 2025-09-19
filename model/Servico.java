package model;

public class Servico {
    String tipoServico;
    String data;
    int valor;
    boolean statusServico;
    Pet pet;

    public Servico(String tipoServico, String data, int valor, boolean statusServico, Pet pet) {
        this.tipoServico = tipoServico;
        this.data = data;
        this.valor = valor;
        this.statusServico = statusServico;
        this.pet = pet;
    }

    public Servico() {
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isStatusServico() {
        return statusServico;
    }

    public void setStatusServico(boolean statusServico) {
        this.statusServico = statusServico;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}