package ec.edu.pucem.formulario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ec.edu.pucem.dominio.Candidato;


public class PanelResultadoGeneral extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JTable table;
    private DefaultTableModel model;

    private List<Candidato> candidatos;
    private JButton btnCancelar;

    public PanelResultadoGeneral(List<Candidato> candidatos) {
        this.candidatos = candidatos;
        setTitle("Resultados Generales");
        setBounds(100, 100, 600, 309);
        getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 48, 566, 167);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(model.getValueAt(table.getSelectedRow(), 0));
            }
        });
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Votos" }));
        scrollPane.setViewportView(table);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        btnCancelar.setBounds(234, 227, 117, 25);
        getContentPane().add(btnCancelar);

        model = (DefaultTableModel) table.getModel();
        llenarTabla();
    }

    private void llenarTabla() {
        model.setRowCount(0);
        for (Candidato candidato : candidatos) {
            Object[] fila = new Object[2];
            fila[0] = candidato.getNombreCandidato();
            fila[1] = candidato.getVotos();
            model.addRow(fila);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancelar) {
            dispose();
        }
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }
}