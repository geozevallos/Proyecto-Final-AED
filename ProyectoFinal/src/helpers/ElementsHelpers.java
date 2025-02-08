package helpers;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import constants.Estado;

public class ElementsHelpers {
	public static Object getComboboxObject(JComboBox<Object> comboBox) {
		return comboBox.getSelectedItem();
	}
	
	public static int getComboBoxIndex(JComboBox comboBox) {
		return comboBox.getSelectedIndex();
	}
	
	public static void setSelectedIndex(JComboBox comboBox, int index) {
		comboBox.setSelectedIndex(index);
	}
	
	public static void setTextFieldValue(JTextField txtField, Object value) {
		if (value == null) {
			txtField.setText("");
			return;
		}
		txtField.setText(String.valueOf(value));
	}
	
	public static Integer getTextFieldIntValue(JTextField txtField) {
		String text = txtField.getText();
		if (text.trim().isEmpty()) {
			return 0;
		}
		return Integer.parseInt(text.toString());
	}
	
	public static String getTextFieldValue(JTextField txtField) {
		String text = txtField.getText();
		if (text.trim().isEmpty()) {
			return null;
		}
		return text.toString();
	}
	
	public static void setSelectedItemEstado(JComboBox<Estado> comboBox, Estado estado) {
		comboBox.setSelectedItem(estado);
	}
	
	
	public static Estado getComboxEstadoObject(JComboBox<Estado> comboBox) {
		return (Estado) comboBox.getSelectedItem();
	}
	
}
