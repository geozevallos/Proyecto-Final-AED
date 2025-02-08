package proyectoFinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import constants.Estado;
import models.Alumno;
import models.Curso;
import services.AlumnoServices;
import helpers.ElementsHelpers;

public class AlumnoAddEditViewDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JTextField txtEdad;
	private JTextField txtCelular;
	//private JTextField txtEstado;

	/**
	 * Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlumnoEditViewDialog dialog = new AlumnoEditViewDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}x
		 */

	/**
	 * Create the dialog.
	 */
	public AlumnoAddEditViewDialog(AlumnoServices alumnoServices,int modo) {

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(12, 12, 80, 17);
		getContentPane().add(lblCodigo);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(12, 41, 80, 17);
		getContentPane().add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(12, 70, 80, 17);
		getContentPane().add(lblApellidos);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(12, 99, 80, 17);
		getContentPane().add(lblDni);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(12, 128, 80, 17);
		getContentPane().add(lblEdad);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(12, 157, 80, 17);
		getContentPane().add(lblCelular);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(12, 186, 80, 17);
		getContentPane().add(lblEstado);
		
		txtNombres = new JTextField();
		txtNombres.setEditable(false);
		txtNombres.setBounds(110, 39, 142, 21);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setEditable(false);
		txtApellidos.setBounds(110, 68, 142, 21);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setBounds(110, 97, 142, 21);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtEdad.setBounds(110, 126, 142, 21);
		getContentPane().add(txtEdad);
		txtEdad.setColumns(10);
		
		txtCelular = new JTextField();
		txtCelular.setEditable(false);
		txtCelular.setBounds(110, 155, 142, 21);
		getContentPane().add(txtCelular);
		txtCelular.setColumns(10);
		
		/*
		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setBounds(110, 184, 142, 21);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);
		*/
		
		JComboBox<Estado> comboBoxEstado = new JComboBox<Estado>(Estado.values());
		comboBoxEstado.setEnabled(false);
		comboBoxEstado.setBounds(110, 184, 142, 21);
		getContentPane().add(comboBoxEstado);

			
		DefaultComboBoxModel<Object> defaultComboBox = new DefaultComboBoxModel<>();
		defaultComboBox.setSelectedItem("Seleccione");
		ArrayList<Alumno> alumnos = alumnoServices.getAlumnos();
		for (Alumno alumno : alumnos) {
			defaultComboBox.addElement(alumno);
		}
		JComboBox<Object> comboBoxAlumno = new JComboBox<>(defaultComboBox);
		comboBoxAlumno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Alumno alumnoSeleccionado = (Alumno) ElementsHelpers.getComboboxObject(comboBoxAlumno);
				
				ElementsHelpers.setTextFieldValue(txtNombres, alumnoSeleccionado.getNombres());
				ElementsHelpers.setTextFieldValue(txtApellidos, alumnoSeleccionado.getApellidos());
				ElementsHelpers.setTextFieldValue(txtDni, alumnoSeleccionado.getDni());
				ElementsHelpers.setTextFieldValue(txtEdad, alumnoSeleccionado.getEdad());
				ElementsHelpers.setTextFieldValue(txtCelular, alumnoSeleccionado.getCelular());
				ElementsHelpers.setSelectedItemEstado(comboBoxEstado, alumnoSeleccionado.getEstado());
				// ElementsHelpers.setTextFieldValue(txtEstado, alumnoSeleccionado.getEstado());
			}
		});
		comboBoxAlumno.setBounds(110, 7, 142, 26);
		getContentPane().add(comboBoxAlumno);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.setBounds(300, 7, 105, 27);
		getContentPane().add(btnGrabar);
		
		// Modo: 1- add, 2-view, 3-edit
		if (modo == 2) {
			
			setTitle("Consultar Alumno");
			btnGrabar.setVisible(false);
			
		} else if (modo == 4){
			
			setTitle("Eliminar Alumno");
			btnGrabar.setText("Eliminar");
			btnGrabar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Alumno alumnoSeleccionado;
					alumnoSeleccionado = (Alumno) ElementsHelpers.getComboboxObject(comboBoxAlumno);
					
					int respuesta = JOptionPane.showConfirmDialog(
							null, "¿Estás seguro que deseas eliminar el alumno?",
							"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (respuesta == JOptionPane.YES_OPTION) {
						boolean eliminado = alumnoServices.deleteAlumno(alumnoSeleccionado);;
						if (eliminado) {
							JOptionPane.showMessageDialog(null, "El alumno fue eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "El alumno no puede ser eliminado", "Error", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			});
			
		} else {
			btnGrabar.setVisible(true);
			txtNombres.setEditable(true);
			txtApellidos.setEditable(true);
			txtEdad.setEditable(true);
			txtCelular.setEditable(true);
			//txtEstado.setEditable(true);
			
			
			if(modo == 1) {
				setTitle("Agregar Alumno");
				comboBoxAlumno.setVisible(false);
				comboBoxEstado.setVisible(false);
				lblEstado.setVisible(false);
				lblCodigo.setVisible(false);
				txtDni.setEditable(true);
				btnGrabar.setBounds(300, 40, 105, 27);
			} else {
				setTitle("Modificar Alumno");
				comboBoxEstado.setEnabled(true);
			}
			

			btnGrabar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String nombres;
					String apellidos;
					int edad;
					int	celular;
					
					nombres = ElementsHelpers.getTextFieldValue(txtNombres);
					apellidos = ElementsHelpers.getTextFieldValue(txtApellidos);
					edad = ElementsHelpers.getTextFieldIntValue(txtEdad);
					celular = ElementsHelpers.getTextFieldIntValue(txtCelular);
					
					if(nombres == null || apellidos == null || edad == 0 || celular == 0) {
						JOptionPane.showMessageDialog(null, "Debes completar todos los datos", "Error", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					
					if(modo == 1) {
						String dni = ElementsHelpers.getTextFieldValue(txtDni);
						if(dni == null) {
							JOptionPane.showMessageDialog(null, "El campo DNI es obligatorio", "Error", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						
						int respuesta = JOptionPane.showConfirmDialog(
								null, "¿Estás seguro de guardar tus cambios?",
								"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(respuesta == JOptionPane.YES_OPTION) {
							Alumno alumnoNuevo = new Alumno(nombres, apellidos, dni, edad, celular);
							boolean rptaCreacion = alumnoServices.addAlumno(alumnoNuevo);
							if(rptaCreacion) {
								JOptionPane.showMessageDialog(null, "El alumno fue ingresado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
								dispose();
							} else {
								JOptionPane.showMessageDialog(null, "El DNI ingresado ya existe", "Error", JOptionPane.INFORMATION_MESSAGE);
								return;
							}
						}
					} else if (modo == 3){
						Estado estado;
						Alumno alumnoSeleccionado;
						
						alumnoSeleccionado = (Alumno) ElementsHelpers.getComboboxObject(comboBoxAlumno);
						estado = ElementsHelpers.getComboxEstadoObject(comboBoxEstado);
						
						int respuesta = JOptionPane.showConfirmDialog(
								null, "¿Estás seguro de guardar tus cambios?",
								"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						
						if(respuesta == JOptionPane.YES_OPTION) {
							alumnoSeleccionado.setNombres(nombres);
							alumnoSeleccionado.setApellidos(apellidos);
							alumnoSeleccionado.setEdad(edad);
							alumnoSeleccionado.setCelular(celular);
							alumnoSeleccionado.setEstado(estado);
							dispose();
						}
					}
					

				}
			});
		}
	}

}
