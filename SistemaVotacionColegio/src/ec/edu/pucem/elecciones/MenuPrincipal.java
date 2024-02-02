package ec.edu.pucem.elecciones;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import ec.edu.pucem.dominio.Candidato;
import ec.edu.pucem.dominio.Curso;
import ec.edu.pucem.dominio.Estudiante;
import ec.edu.pucem.dominio.Mesa;
import ec.edu.pucem.formulario.PanelCandidatos;
import ec.edu.pucem.formulario.PanelCurso;
import ec.edu.pucem.formulario.PanelEleccionMesas;
import ec.edu.pucem.formulario.PanelEstudiantes;
import ec.edu.pucem.formulario.PanelPadronElectoral;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List <Candidato> candidatos;
	private List <Curso> cursos;
	private List <Estudiante> estudiantes;
	private List<Estudiante> estudiantesMesa;
	private List <Mesa> mesas;




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public MenuPrincipal() {
		
		candidatos = new ArrayList<>(); 
		cursos = new ArrayList<>(); 
		estudiantes = new ArrayList<>(); 
		mesas = new ArrayList<>(); 
		estudiantesMesa = new ArrayList<>();
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 697);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnAdministracion = new JMenu("Administración");
		menuBar.add(mnAdministracion);
		
		JMenuItem mntmCursos = new JMenuItem("Crear Cursos");
		mntmCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 PanelCurso panelCurso = new PanelCurso(cursos);
			        contentPane.add(panelCurso);
			        panelCurso.setVisible(true);
			}
		});
		mnAdministracion.add(mntmCursos);
		
		JMenuItem mntmEstudiantes = new JMenuItem("Crear Estudiantes");
		mntmEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  PanelEstudiantes panelEstudiantes = new PanelEstudiantes(cursos , estudiantes);
			        contentPane.add(panelEstudiantes);
			        panelEstudiantes.setVisible(true);
				
			}
		});
		mnAdministracion.add(mntmEstudiantes);
		
		JMenuItem mntmCandidatos = new JMenuItem("Crear Candidatos");
		mntmCandidatos.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        PanelCandidatos panelCandidatos = new PanelCandidatos(candidatos);
		        contentPane.add(panelCandidatos);
		        panelCandidatos.setVisible(true);
		    }
		});
		

		mnAdministracion.add(mntmCandidatos);
		
		
		mnAdministracion.add(mntmCandidatos);
		
		JMenuItem mntmMesas = new JMenuItem("Crear Mesas");
		mntmMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//PanelEleccionMesas
				PanelEleccionMesas panelEleccionMesas = new PanelEleccionMesas(mesas, estudiantes);
		        contentPane.add(panelEleccionMesas);
		        panelEleccionMesas.setVisible(true);
				
			}
		});
		mnAdministracion.add(mntmMesas);
		
		JMenu mnReportes = new JMenu("Reporte");
		menuBar.add(mnReportes);
		
		JMenuItem mntmPadron = new JMenuItem("Imprimir Padrón Electoral");
		mntmPadron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				PanelPadronElectoral  panelPadronElectoral  = new PanelPadronElectoral(mesas, estudiantes, estudiantesMesa);
				contentPane.add(panelPadronElectoral);
				panelPadronElectoral.setVisible(true);
				
			}
		});
		mnReportes.add(mntmPadron);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
	}
}
