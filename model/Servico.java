package model;

public class Servico {
    private String tipoServico;
    private String data;
    private float valor;
    private boolean statusServico = true;
    private Pet pet;
    private Funcionario funcionario;

    public Servico(String tipoServico, String data, float valor, Pet pet, Funcionario funcionario) {
        this.tipoServico = tipoServico;
        this.data = data;
        this.valor = valor;
        this.pet = pet;
        this.funcionario = funcionario;
    }

    public Servico() {
    }

    public void concluirServico() {
        this.statusServico = false;
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

    public float getValor() {
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}