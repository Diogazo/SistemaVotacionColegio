package ec.edu.pucem.dominio;

import java.util.ArrayList;
import java.util.List;


public class Mesa {

    private String nombreMesa;
    private List<Estudiante> estudiantesDeMesa;

    public Mesa() {
        this.estudiantesDeMesa = new ArrayList<>();
    }

    public String getNombreMesa() {
        return nombreMesa;
    }

    public void setNombreMesa(String nombreMesa) {
        this.nombreMesa = nombreMesa;
    }

    public List<Estudiante> getEstudiantesDeMesa() {
        return estudiantesDeMesa;
    }

    public void setEstudiantesDeMesa(List<Estudiante> estudiantesDeMesa) {
        this.estudiantesDeMesa = estudiantesDeMesa;
    }

    public Candidato[] getCandidatos() {
        List<Candidato> candidatos = new ArrayList<>();
        for (Estudiante estudiante : estudiantesDeMesa) {
            Candidato candidatoVotado = estudiante.getCandidatoVotado();
            if (candidatoVotado != null && !candidatos.contains(candidatoVotado)) {
                candidatos.add(candidatoVotado);
            }
        }
        return candidatos.toArray(new Candidato[0]);
    }
}