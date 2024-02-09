package ec.edu.pucem.dominio;

import javax.swing.JOptionPane;

public class Estudiante {
	
	private String nombreEstudiante;
	private String cedulaEstudiante;
	private Curso curso;
	private Candidato candidatoVotado; // Agregar atributo

	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	public String getCedulaEstudiante() {
		return cedulaEstudiante;
	}

	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Candidato getCandidatoVotado() {
		return candidatoVotado;
	}

	public void setCandidatoVotado(Candidato candidatoVotado) {
		this.candidatoVotado = candidatoVotado;
	}

	public void votarPor(Candidato candidatoSeleccionado) {
	    if (candidatoVotado != null) {
	        JOptionPane.showMessageDialog(null, "Usted ya ha votado por el candidato: " + candidatoVotado.getNombreCandidato());
	        candidatoSeleccionado.disminuirVotos();
	        return;
	    }

	    this.candidatoVotado = candidatoSeleccionado;
	    JOptionPane.showMessageDialog(null, "¡Gracias por su voto!");
	}
}