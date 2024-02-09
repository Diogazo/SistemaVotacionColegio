package ec.edu.pucem.formulario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ec.edu.pucem.dominio.Candidato;
import ec.edu.pucem.dominio.Estudiante;

import java.awt.Label;
import java.awt.Font;


public class PanelVoto extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JPanel panel;

    private List<Candidato> candidatos;
    private List<Estudiante> estudiantes;
    private String cedulaIngresada;

    public PanelVoto(List<Estudiante> estudiantes, String cedulaIngresada, List<Candidato> candidatos) {
        this.estudiantes = estudiantes;
        this.cedulaIngresada = cedulaIngresada;
        this.candidatos = candidatos;


        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);

        this.panel = new JPanel();
        this.panel.setBounds(10, 116, 414, 111);
        getContentPane().add(this.panel);
       

        Label labelNombre = new Label("Hola " + obtenerNombreEstudiante());
        labelNombre.setAlignment(Label.CENTER);
        labelNombre.setFont(new Font("Dialog", Font.PLAIN, 18));
        labelNombre.setBounds(133, 24, 175, 22);
        getContentPane().add(labelNombre);

        Label labelNombre_1 = new Label("Escoja su candidato");
        labelNombre_1.setAlignment(Label.CENTER);
        labelNombre_1.setFont(new Font("Dialog", Font.PLAIN, 18));
        labelNombre_1.setBounds(133, 53, 175, 22);
        getContentPane().add(labelNombre_1);
        
        cargarCandidatos();

    }

    private String obtenerNombreEstudiante() {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedulaEstudiante().equals(cedulaIngresada)) {
                return estudiante.getNombreEstudiante();
            }
        }
        return "Estudiante no encontrado";
    }

    private void cargarCandidatos() {
        int x = 0;
        panel.removeAll();
        for (Candidato candidato : candidatos) {
            JButton btnCandidato = new JButton(candidato.getNombreCandidato());
            btnCandidato.setBounds(x * 155, 0, 150, 80);
            btnCandidato.addActionListener(this);
            panel.add(btnCandidato);
            x++;
        }
        panel.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            String nombreCandidato = button.getText();
            registrarVoto(nombreCandidato);
        }
    }

    private void registrarVoto(String nombreCandidato) {
        Candidato candidatoSeleccionado = null;
        for (Candidato candidato : candidatos) {
            if (candidato.getNombreCandidato().equals(nombreCandidato)) {
                candidatoSeleccionado = candidato;
                break;
            }
        }

        if (candidatoSeleccionado != null) {
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getCedulaEstudiante().equals(cedulaIngresada)) {
                    estudiante.votarPor(candidatoSeleccionado);
                    candidatoSeleccionado.incrementarVotos();
                    break;
                }
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error: Candidato no encontrado");
        }
    }
    
}
