package proyectoFinal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import constants.Estado;
import helpers.ElementsHelpers;
import models.Alumno;
import models.Curso;
import services.CursosServices;

public class CursoAddEditViewDeleteDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtAsignatura;
	//private JTextField txtCiclo;
	private JTextField txtCreditos;
	private JTextField txtHoras;


	/**
	 * Launch the application.
	public static void main(String[] args) {
		try {
			CursoAddEditViewDeleteDialog dialog = new CursoAddEditViewDeleteDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 */

	public CursoAddEditViewDeleteDialog(CursosServices cursosServices, int modo) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblcodCurso = new JLabel("Cód. curso:");
		lblcodCurso.setBounds(12, 12, 80, 17);
		getContentPane().add(lblcodCurso);
		
		JLabel lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setBounds(12, 41, 80, 17);
		getContentPane().add(lblAsignatura);
		
		JLabel lblCiclo = new JLabel("Ciclo:");
		lblCiclo.setBounds(12, 70, 80, 17);
		getContentPane().add(lblCiclo);
		
		JLabel lblCreditos = new JLabel("Créditos:");
		lblCreditos.setBounds(12, 99, 80, 17);
		getContentPane().add(lblCreditos);
		
		JLabel lblHoras = new JLabel("Horas:");
		lblHoras.setBounds(12, 128, 80, 17);
		getContentPane().add(lblHoras);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(110, 39, 142, 21);
		getContentPane().add(txtAsignatura);
		txtAsignatura.setColumns(10);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.setBounds(300, 7, 105, 27);
		getContentPane().add(btnGrabar);
		
		JComboBox comboBoxCiclo = new JComboBox<>();
		comboBoxCiclo.setModel(new DefaultComboBoxModel(new String[] {"Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto"}));
		comboBoxCiclo.setBounds(110, 68, 142, 21);
		getContentPane().add(comboBoxCiclo);
		
		txtCreditos = new JTextField();
		txtCreditos.setBounds(110, 97, 142, 21);
		getContentPane().add(txtCreditos);
		txtCreditos.setColumns(10);
		
		txtHoras = new JTextField();
		txtHoras.setBounds(110, 126, 142, 21);
		getContentPane().add(txtHoras);
		txtHoras.setColumns(10);
		
		if(modo == 1){
				setTitle("Agregar curso");
				
				JTextField txtCodigo = new JTextField();
				txtCodigo.setBounds(110, 7, 142, 26);
				getContentPane().add(txtCodigo);
				txtCodigo.setColumns(10);
				btnGrabar.addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						int codigoCurso;
						String asignatura;
						int ciclo;
						int creditos;
						int horas;
						
						codigoCurso = ElementsHelpers.getTextFieldIntValue(txtCodigo);
						asignatura = ElementsHelpers.getTextFieldValue(txtAsignatura);
						creditos = ElementsHelpers.getTextFieldIntValue(txtCreditos);
						horas = ElementsHelpers.getTextFieldIntValue(txtHoras);
						ciclo = ElementsHelpers.getComboBoxIndex(comboBoxCiclo);
						
						if(asignatura == null || codigoCurso == 0 || creditos == 0 || horas == 0) {
							JOptionPane.showMessageDialog(null, "Debes completar todos los datos", "Error", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						int respuesta = JOptionPane.showConfirmDialog(
								null, "¿Estás seguro de guardar tus cambios?",
								"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(respuesta == JOptionPane.YES_OPTION) {
							Curso cursoNuevo = new Curso(codigoCurso, asignatura, ciclo, creditos, horas);
							boolean rptaCreacion = cursosServices.addCurso(cursoNuevo);
							if(rptaCreacion) {
								JOptionPane.showMessageDialog(null, "El curso fue ingresado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
								dispose();
							} else {
								JOptionPane.showMessageDialog(null, "Ya existe un curso con ese id", "Error", JOptionPane.INFORMATION_MESSAGE);
								return;
							}
						}
					}
				});
				
		} else {
			DefaultComboBoxModel<Object> defaultComboBox = new DefaultComboBoxModel<>();
			defaultComboBox.setSelectedItem("Seleccione");
			ArrayList<Curso> cursos = cursosServices.getCursos();
			for (Curso curso : cursos) {
				defaultComboBox.addElement(curso);
			}
			JComboBox<Object> comboBoxCurso = new JComboBox<>(defaultComboBox);
			comboBoxCurso.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Curso cursoSeleccionado = (Curso) ElementsHelpers.getComboboxObject(comboBoxCurso);
					
					ElementsHelpers.setTextFieldValue(txtAsignatura, cursoSeleccionado.getAsignatura());
					ElementsHelpers.setTextFieldValue(txtCreditos, cursoSeleccionado.getCreditos());
					ElementsHelpers.setTextFieldValue(txtHoras, cursoSeleccionado.getHoras());
					ElementsHelpers.setSelectedIndex(comboBoxCiclo, cursoSeleccionado.getCiclo());

				}
			});
			comboBoxCurso.setBounds(110, 7, 142, 26);
			getContentPane().add(comboBoxCurso);
			
			if(modo == 2 || modo == 4) {
				// Get
				setTitle("Consultar curso");	
				txtAsignatura.setEditable(false);
				txtCreditos.setEditable(false);
				txtHoras.setEditable(false);
				comboBoxCiclo.setEnabled(false);
				btnGrabar.setVisible(false);
				
				if(modo == 4) {
					setTitle("Eliminar curso");
					btnGrabar.setText("Eliminar");
					btnGrabar.setVisible(true);
					btnGrabar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							Curso cursoSeleccionado;
							cursoSeleccionado = (Curso) ElementsHelpers.getComboboxObject(comboBoxCurso);
							
							int respuesta = JOptionPane.showConfirmDialog(
									null, "¿Estás seguro que deseas eliminar el curso?",
									"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (respuesta == JOptionPane.YES_OPTION) {
								boolean eliminado = cursosServices.deleteCurso(cursoSeleccionado);
								if (eliminado) {
									JOptionPane.showMessageDialog(null, "El curso fue eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
									dispose();
								} else {
									JOptionPane.showMessageDialog(null, "El curso no puede ser eliminado", "Error", JOptionPane.INFORMATION_MESSAGE);
								}
							}
						}
					});
					
				}
			} else if(modo == 3) {
				// Edicion
				setTitle("Editar curso");
				btnGrabar.addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						Curso cursoSeleccionado;
						String asignatura;
						int ciclo;
						int creditos;
						int horas;
						
						cursoSeleccionado = (Curso) ElementsHelpers.getComboboxObject(comboBoxCurso);
						asignatura = ElementsHelpers.getTextFieldValue(txtAsignatura);
						creditos = ElementsHelpers.getTextFieldIntValue(txtCreditos);
						horas = ElementsHelpers.getTextFieldIntValue(txtHoras);
						ciclo = ElementsHelpers.getComboBoxIndex(comboBoxCiclo);
						
						if(asignatura == null || creditos == 0 || horas == 0) {
							JOptionPane.showMessageDialog(null, "Debes completar todos los datos", "Error", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						int respuesta = JOptionPane.showConfirmDialog(
								null, "¿Estás seguro de guardar tus cambios?",
								"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(respuesta == JOptionPane.YES_OPTION) {
							cursoSeleccionado.setAsignatura(asignatura);
							cursoSeleccionado.setCiclo(ciclo);
							cursoSeleccionado.setCreditos(creditos);
							cursoSeleccionado.setHoras(horas);
							dispose();
						}
					}
				});
			} 
			
			
		} 
	}

}
