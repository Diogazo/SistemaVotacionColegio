package ec.edu.pucem.formulario;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ec.edu.pucem.dominio.Estudiante;
import ec.edu.pucem.dominio.Mesa;



public class PanelAñadirMesa extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JTable table;
	private DefaultTableModel model;
	private JComboBox<Mesa> comboBox;
	private JComboBox<Estudiante> comboBox2;

	private Mesa mesa;

	private List<Mesa> mesas;
	private List <Estudiante> estudiantes;
	private List <Estudiante> estudiantesDeMesa;



	public PanelAñadirMesa(List<Mesa> mesas, List<Estudiante>estudiantes, List <Estudiante> estudiantesDeMesa) {

		this.mesas = mesas;
		this.estudiantes = estudiantes;
		this.estudiantesDeMesa = estudiantesDeMesa;
		
		setTitle("Añadir Estudiante a Mesa");
		setBounds(10, 11, 545, 398);
		getContentPane().setLayout(null);
		
		JLabel lblNombreMesa = new JLabel("Mesa:");
		lblNombreMesa.setBounds(161, 24, 46, 14);
		getContentPane().add(lblNombreMesa);
		
		comboBox = new JComboBox<>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		DefaultComboBoxModel<Mesa> comboBoxModel = new DefaultComboBoxModel<>(
		mesas.toArray(new Mesa[0]));
		comboBox.setModel(comboBoxModel);
		
				comboBox.setRenderer(new DefaultListCellRenderer() {
					@Override
					public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
							boolean cellHasFocus) {
						if (value instanceof Mesa) {
							Mesa mesa = (Mesa) value;
							value = mesa.getNombreMesa();
						}
						return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
					}
				});

				comboBox.setBounds(217, 19, 132, 24);
				getContentPane().add(comboBox);
		
		
		
		JLabel lblEstudiante = new JLabel("Estudiante:");
		lblEstudiante.setBounds(142, 59, 61, 14);
		getContentPane().add(lblEstudiante);
		
				comboBox2 = new JComboBox<>();

				DefaultComboBoxModel <Estudiante> comboBoxModel1 = new DefaultComboBoxModel<>(
				estudiantes.toArray(new Estudiante[0]));
				comboBox2.setModel(comboBoxModel1);
				
				
			
						comboBox2.setRenderer(new DefaultListCellRenderer() {
							@Override
							public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
									boolean cellHasFocus) {
								if (value instanceof Estudiante) {
									Estudiante estudiante = (Estudiante) value;
									value = estudiante.getNombreEstudiante();
								}
								return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
							}
						});

						comboBox2.setBounds(217, 54, 132, 24);
						getContentPane().add(comboBox2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 157, 413, 178);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(model.getValueAt(0, 0));
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Estudiante", "Mesa"}));
		scrollPane.setViewportView(table);
		
		JButton btnSalir = new JButton("Cancelar");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(280, 100, 89, 23);
		getContentPane().add(btnSalir);
		model = (DefaultTableModel) table.getModel();

		JButton btnAgregar = new JButton("Guardar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarEstudianteAMesa();
			}
		});
		btnAgregar.setBounds(149, 100, 89, 23);
		getContentPane().add(btnAgregar);
		cargarMesas();

	}
	
	private void cargarMesas() {
	    // Limpiar ComboBox de mesas antes de cargar las mesas existentes
	    comboBox.removeAllItems();

	    // Agregar las mesas existentes al ComboBox
	    for (Mesa mesa : mesas) {
	        comboBox.addItem(mesa);
	    }
	}


	private void agregarEstudianteAMesa() {
	    Mesa mesaSeleccionada = (Mesa) comboBox.getSelectedItem();
	    Estudiante estudianteSeleccionado = (Estudiante) comboBox2.getSelectedItem();
	    
	    if (mesaSeleccionada != null && estudianteSeleccionado != null) {
	        // Verifica si la mesa ya está en la lista de mesas
	        boolean mesaExiste = false;
	        for (Mesa m : mesas) {
	            if (m.getNombreMesa().equals(mesaSeleccionada.getNombreMesa())) {
	                // La mesa ya existe en la lista, establece la referencia a la mesa existente
	                mesaSeleccionada = m;
	                mesaExiste = true;
	                break;
	            }
	        }
	        
	        // Si la mesa no existe en la lista, agrégala
	        if (!mesaExiste) {
	            mesas.add(mesaSeleccionada);
	        }
	        
	        // Agrega el estudiante a la mesa
	        mesaSeleccionada.getEstudiantesDeMesa().add(estudianteSeleccionado);
	        
	        // Agrega la fila a la tabla
	        agregarFila(mesaSeleccionada.getNombreMesa(), estudianteSeleccionado.getNombreEstudiante());
	    } else {
	        System.out.println("Mesa o estudiante seleccionado es nulo");
	    }
	}


	private void agregarFila(String nombreMesa, String nombreEstudiante) {
	    model.addRow(new Object[]{nombreEstudiante, nombreMesa});
	}


	

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}