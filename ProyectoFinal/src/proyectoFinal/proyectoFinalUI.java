package proyectoFinal;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import services.AlumnoServices;

public class proyectoFinalUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public AlumnoServices alumnoServices = new AlumnoServices();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					proyectoFinalUI frame = new proyectoFinalUI();
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
	public proyectoFinalUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setTitle("REGISTRO Y MATRÍCULA DE ALUMNOS");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuPrincipal = new JMenuBar();
		menuPrincipal.setBounds(12,0,795,23);
		contentPane.add(menuPrincipal);
		
		// Mantenimiento --------------------------------------
		JMenu menuMantenimiento = new JMenu("Mantenimiento");
		menuPrincipal.add(menuMantenimiento);
		
		JMenu subMenuMantenimientoAlumno = new JMenu("Alumno");
		menuMantenimiento.add(subMenuMantenimientoAlumno);
		
		JMenuItem itemMantenimientoAlumnoAdd = new JMenuItem("Adicionar");
		itemMantenimientoAlumnoAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AlumnoAddEditViewDialog AlumnoViewDialog = new AlumnoAddEditViewDialog(alumnoServices, 1);
				AlumnoViewDialog.setLocationRelativeTo(proyectoFinalUI.this);
				AlumnoViewDialog.setVisible(true);
			}
		});
		subMenuMantenimientoAlumno.add(itemMantenimientoAlumnoAdd);
		
		
		JMenuItem itemMantenimientoAlumnoGet = new JMenuItem("Consultar");
		itemMantenimientoAlumnoGet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AlumnoAddEditViewDialog AlumnoViewDialog = new AlumnoAddEditViewDialog(alumnoServices, 2);
				AlumnoViewDialog.setLocationRelativeTo(proyectoFinalUI.this);
				AlumnoViewDialog.setVisible(true);
			}
		});
		
		subMenuMantenimientoAlumno.add(itemMantenimientoAlumnoGet);
		
		
		JMenuItem itemMantenimientoAlumnoEdit = new JMenuItem("Editar");
		itemMantenimientoAlumnoEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AlumnoAddEditViewDialog AlumnoEditDialog = new AlumnoAddEditViewDialog(alumnoServices, 3);
				AlumnoEditDialog.setLocationRelativeTo(proyectoFinalUI.this);
				AlumnoEditDialog.setVisible(true);
			}
		});
		subMenuMantenimientoAlumno.add(itemMantenimientoAlumnoEdit);
		
		JMenuItem itemMantenimientoAlumnoDelete = new JMenuItem("Eliminar");
		subMenuMantenimientoAlumno.add(itemMantenimientoAlumnoDelete);
		
		JMenu subMenuMantenimientoCurso = new JMenu("Curso");
		menuMantenimiento.add(subMenuMantenimientoCurso);
		
		JMenuItem itemMantenimientoCursoAdd = new JMenuItem("Adicionar");
		subMenuMantenimientoCurso.add(itemMantenimientoCursoAdd);
		
		JMenuItem itemMantenimientoCursoGet = new JMenuItem("Consultar");
		subMenuMantenimientoCurso.add(itemMantenimientoCursoGet);
		
		JMenuItem itemMantenimientoCursoEdit = new JMenuItem("Editar");
		subMenuMantenimientoCurso.add(itemMantenimientoCursoEdit);
		
		JMenuItem itemMantenimientoCursoDelete = new JMenuItem("Eliminar");
		subMenuMantenimientoCurso.add(itemMantenimientoCursoDelete);
		
		// Registro ---------------------------------
		JMenu menuRegistro = new JMenu("Registro");
		menuPrincipal.add(menuRegistro);
		
		JMenu subMenuRegistroMatricula = new JMenu("Matricula");
		menuRegistro.add(subMenuRegistroMatricula);
		
		JMenuItem itemRegistroMatriculaAdd = new JMenuItem("Adicionar");
		subMenuRegistroMatricula.add(itemRegistroMatriculaAdd);
		
		JMenuItem itemRegistroMatriculaGet = new JMenuItem("Consultar");
		subMenuRegistroMatricula.add(itemRegistroMatriculaGet);
		
		JMenuItem itemRegistroMatriculaEdit = new JMenuItem("Editar");
		subMenuRegistroMatricula.add(itemRegistroMatriculaEdit);
		
		JMenuItem itemRegistroMatriculaDelete = new JMenuItem("Eliminar");
		subMenuRegistroMatricula.add(itemRegistroMatriculaDelete);
		
		JMenu subMenuRegistroRetiro = new JMenu("Retiro");
		menuRegistro.add(subMenuRegistroRetiro);
		
		JMenuItem itemRegistroRetiroAdd = new JMenuItem("Adicionar");
		subMenuRegistroRetiro.add(itemRegistroRetiroAdd);
		
		JMenuItem itemRegistroRetiroGet = new JMenuItem("Consultar");
		subMenuRegistroRetiro.add(itemRegistroRetiroGet);
		
		JMenuItem itemRegistroRetiroEdit = new JMenuItem("Editar");
		subMenuRegistroRetiro.add(itemRegistroRetiroEdit);
		
		JMenuItem itemRegistroRetiroDelete = new JMenuItem("Eliminar");
		subMenuRegistroRetiro.add(itemRegistroRetiroDelete);

		// Consulta ---------------------
		JMenu menuConsulta = new JMenu("Consulta");
		menuPrincipal.add(menuConsulta);
		
		JMenuItem itemConsultaAlumnos = new JMenuItem("Alumnos");
		menuConsulta.add(itemConsultaAlumnos);
		
		JMenuItem itemConsultaCursos = new JMenuItem("Cursos");
		menuConsulta.add(itemConsultaCursos);
		
		JMenuItem itemConsultaMatriculas = new JMenuItem("Matriculas");
		menuConsulta.add(itemConsultaMatriculas);
		
		JMenuItem itemConsultaRetiros = new JMenuItem("Retiros");
		menuConsulta.add(itemConsultaRetiros);
		
		// Reporte ---------------------------
		JMenu menuReporte = new JMenu("Reporte");
		menuPrincipal.add(menuReporte);
		
		JMenuItem itemReporte1 = new JMenuItem("Alumnos con matrícula pendiente");
		menuReporte.add(itemReporte1);
		
		JMenuItem itemReporte2 = new JMenuItem("Alumnos con matrícula vigente");
		menuReporte.add(itemReporte2);
		
		JMenuItem itemReporte3 = new JMenuItem("Alumnos matriculados por curso");
		menuReporte.add(itemReporte3);
		
	}

}
