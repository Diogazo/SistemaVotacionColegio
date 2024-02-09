package ec.edu.pucem.formulario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ec.edu.pucem.dominio.Candidato;
import ec.edu.pucem.dominio.Mesa;


public class PanelResultadoMesa extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JTable table;
    private DefaultTableModel model;

    private List<Mesa> mesas;
    private JButton btnCancelar;
    private JLabel lblNombres;
    private JComboBox<String> comboBoxMesas;

    public PanelResultadoMesa(List<Mesa> mesas) {
        this.mesas = mesas;
        setTitle("REPORTE GENERAL POR MESA");
        setBounds(100, 100, 600, 309);
        getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 48, 566, 167);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Votos" }));
        scrollPane.setViewportView(table);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        btnCancelar.setBounds(234, 227, 117, 25);
        getContentPane().add(btnCancelar);

        lblNombres = new JLabel("Mesa");
        lblNombres.setBounds(12, 21, 70, 15);
        getContentPane().add(lblNombres);

        comboBoxMesas = new JComboBox<>();
        comboBoxMesas.setBounds(79, 12, 231, 24);
        comboBoxMesas.addActionListener(this);
        getContentPane().add(comboBoxMesas);

        model = (DefaultTableModel) table.getModel();
        llenarComboBoxMesas();
        llenarTabla();
    }
    

    private void llenarComboBoxMesas() {
        for (Mesa mesa : mesas) {
            comboBoxMesas.addItem(mesa.getNombreMesa());
        }
    }

    private void llenarTabla() {
        model.setRowCount(0);
        String mesaSeleccionada = (String) comboBoxMesas.getSelectedItem();
        for (Mesa mesa : mesas) {
            if (mesa.getNombreMesa().equals(mesaSeleccionada)) {
                for (Candidato candidatos : mesa.getCandidatos()) {
                    Object[] fila = new Object[2];
                    fila[0] = candidatos.getNombreCandidato();
                    fila[1] = candidatos.getVotos();
                    model.addRow(fila);
                }
                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancelar) {
            dispose();
        } else if (e.getSource() == comboBoxMesas) {
            llenarTabla();
        }
    }
}