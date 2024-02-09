package ec.edu.pucem.elecciones;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import ec.edu.pucem.dominio.Candidato;
import ec.edu.pucem.dominio.Curso;
import ec.edu.pucem.dominio.Estudiante;
import ec.edu.pucem.dominio.Mesa;
import ec.edu.pucem.formulario.PanelCandidatos;
import ec.edu.pucem.formulario.PanelCedula;
import ec.edu.pucem.formulario.PanelCurso;
import ec.edu.pucem.formulario.PanelEleccionMesas;
import ec.edu.pucem.formulario.PanelEstudiantes;
import ec.edu.pucem.formulario.PanelPadronElectoral;
import ec.edu.pucem.formulario.PanelResultadoGeneral;
import ec.edu.pucem.formulario.PanelResultadoMesa;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class MenuPrincipal extends JFrame implements ActionListener { 

    private static final long serialVersionUID = 1L;
    private JDesktopPane desktopPane;
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
        setForeground(new Color(0, 0, 0));
        setTitle("Menú Principal");
        
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
        
        JMenu mnProceso = new JMenu("Proceso");
        menuBar.add(mnProceso);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Sufragar");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PanelCedula panelCedula = new PanelCedula(estudiantes, candidatos);
                contentPane.add(panelCedula);
                panelCedula.setVisible(true);
            }
        });
        mnProceso.add(mntmNewMenuItem);
        
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
        
        JMenuItem mntmNewResultadosGenerales = new JMenuItem("Resultados Generales");
        mntmNewResultadosGenerales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PanelResultadoGeneral panelResultadoGeneral = new PanelResultadoGeneral(candidatos);
                contentPane.add(panelResultadoGeneral);
                panelResultadoGeneral.setVisible(true);
            }
        });
        mnReportes.add(mntmNewResultadosGenerales);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Resultados Por Mesa");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PanelResultadoMesa panelResultadoMesa = new PanelResultadoMesa( mesas);
                contentPane.add(panelResultadoMesa);
                panelResultadoMesa.setVisible(true);
            }
        });
        mnReportes.add(mntmNewMenuItem_1);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Resultados Generales En Gráficos De Barras");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearResultadosEnBarras();
            }
        });
        mnReportes.add(mntmNewMenuItem_2);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
    }
    private void crearResultadosEnBarras() {
		final JInternalFrame frame = new JInternalFrame("Resultado en Barras", true);
		desktopPane = new JDesktopPane();
        desktopPane.setBounds(100, 100, 872, 697); 
        contentPane.add(desktopPane);
		
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (Candidato candidatos : candidatos) {
			dataset.addValue(candidatos.getVotos(), "Candidatos", candidatos.getNombreCandidato());
		}
		final JFreeChart chart = ChartFactory.createBarChart("Bar Chart", "Category", "Series", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(600, 400));

		final JPanel panel = new JPanel();
		panel.setBounds(0, 0, 600, 400);
		panel.setLayout(new BorderLayout());
		panel.add(chartPanel);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});

		panel.add(btnCancelar, BorderLayout.SOUTH);
		frame.getContentPane().add(panel);
		desktopPane.add(frame);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    
}