package crud;

import model.Tutor;
import java.util.ArrayList;

public class CadastroTutor {
    ArrayList<Tutor> tutores = new ArrayList<>();

    public void novoTutor(Tutor tutor) {
        tutores.add(tutor);
    }

    public Tutor buscarPorCPF(String cpf) {
        cpf = cpf.replaceAll("\\D", "");
        for (Tutor tutor : tutores) {
            if (tutor.getCpf().equals(cpf)) {
                return tutor;
            }
        }
        return null;
    }
    
}