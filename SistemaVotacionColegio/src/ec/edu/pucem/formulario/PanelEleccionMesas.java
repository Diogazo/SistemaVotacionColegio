package ec.edu.pucem.formulario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import ec.edu.pucem.dominio.Estudiante;
import ec.edu.pucem.dominio.Mesa;



public class PanelEleccionMesas extends JInternalFrame implements ActionListener {
	private List<Mesa> mesas;
	private PanelCrearMesas panelCrearMesas; 
	private List<Estudiante> estudiantes;
	private List <Estudiante> estudiantesDeMesa;

	private static final long serialVersionUID = 1L;

	

	/**
	 * Create the frame.
	 */
	public PanelEleccionMesas( List<Mesa> mesas, List<Estudiante> estudiantes) {
		setTitle("Crear Mesas");
		this.mesas = mesas;
		this.estudiantes = estudiantes;
		
		setBounds(100, 100, 712, 491);
		getContentPane().setLayout(null);
		
		JPanel panelChiquito = new JPanel();
		panelChiquito.setBounds(10, 11, 676, 439);
		getContentPane().add(panelChiquito);
		panelChiquito.setLayout(null);
		
		JButton btnCrearMesas = new JButton("Crear Mesas");
		btnCrearMesas.setBounds(10, 11, 181, 29);
		panelChiquito.add(btnCrearMesas);
		btnCrearMesas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnNewButton_1 = new JButton("Añadir Estudiantes a Mesas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PanelAñadirMesa panelAñadirEstMesa = new PanelAñadirMesa(mesas, estudiantes, estudiantesDeMesa );
		        panelChiquito.add(panelAñadirEstMesa);
		        panelAñadirEstMesa.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(210, 11, 249, 29);
		panelChiquito.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnSalir = new JButton("Cancelar");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSalir.setBounds(476, 11, 190, 29);
		panelChiquito.add(btnSalir);
		btnCrearMesas.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {

				 PanelCrearMesas panelCrearMesas = new PanelCrearMesas(mesas);
			        panelChiquito.add(panelCrearMesas);
			        panelCrearMesas.setVisible(true);
				 
				 
	            }
	        });
		
		

	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}