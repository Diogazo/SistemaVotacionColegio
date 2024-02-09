package ec.edu.pucem.dominio;

public class Candidato {
    
    private String nombreCandidato;
    private String partido;
    private int votos;
    
    // Constructor
    public Candidato(String nombreCandidato, String partido) {
        this.nombreCandidato = nombreCandidato;
        this.partido = partido;
        this.votos = 0; // Inicializamos el contador de votos en 0 al crear un nuevo candidato
    }
    
    // Getters y Setters
    
    public String getNombreCandidato() {
        return nombreCandidato;
    }

    public void setNombreCandidato(String nombreCandidato) {
        this.nombreCandidato = nombreCandidato;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }
    
    public int getVotos() {
        return votos;
    }
    
    // Método para incrementar el contador de votos
    public void incrementarVotos() {
        this.votos++;
    }
    public void disminuirVotos() {
        this.votos--;
    }
}