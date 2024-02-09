package ec.edu.pucem.formulario;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import ec.edu.pucem.dominio.Candidato;
import ec.edu.pucem.dominio.Estudiante;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

public class PanelCedula extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField textCedula;
    private List<Estudiante> estudiantes;
    private List<Candidato> candidatos;
    private JPanel contentPane;

    public PanelCedula(List<Estudiante> estudiantes, List<Candidato> candidatos) {
        this.estudiantes = estudiantes;
        this.candidatos = candidatos;
        
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel(); 
        setContentPane(contentPane); 
        contentPane.setLayout(null);

        textCedula = new JTextField();
        textCedula.setBounds(139, 109, 135, 20);
        contentPane.add(textCedula);
        textCedula.setColumns(10);

        JLabel lblNewLabel = new JLabel("Cédula Estudiante");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(139, 84, 161, 14);
        contentPane.add(lblNewLabel);

        JButton btnNewButtonEntrar = new JButton("Entrar");
        btnNewButtonEntrar.setBounds(161, 154, 89, 23);
        contentPane.add(btnNewButtonEntrar);
        btnNewButtonEntrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (estudiantes == null) {
            JOptionPane.showMessageDialog(this, "Error: La lista de estudiantes no está inicializada");
            return;
        }
        
        String cedulaIngresada = textCedula.getText();
        boolean cedulaRegistrada = false;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedulaEstudiante().equals(cedulaIngresada)) {
                cedulaRegistrada = true;
                break;
            }
        }
        if (cedulaRegistrada) {
            // Abre el panel de voto
            PanelVoto panelVoto = new PanelVoto(estudiantes, cedulaIngresada, candidatos);
            panelVoto.setBounds(100, 100, 450, 300); // Establece el tamaño y la posición
            getParent().add(panelVoto); // Agrega el panel de voto al contenedor padre del panel de cédula
            panelVoto.setVisible(true);
            
            // Cierra el panel de cédula
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Número de cédula no registrada");
        }
    }
}