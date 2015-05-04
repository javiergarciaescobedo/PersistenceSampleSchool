package persistencesampleschool.controller;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SchoolIntegerCellEditor extends DefaultCellEditor {
    
    JTextField jTextField;

    public SchoolIntegerCellEditor(JTextField jTextField) {
        super(jTextField);
        this.jTextField = jTextField;
        // Set a border for JTextfield component. Otherwise, it has a big margin
        this.jTextField.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));
    }

    @Override
    public boolean stopCellEditing() {
        try {
            // Only allow stop editing if text is integer
            Integer.valueOf(jTextField.getText());
            return super.stopCellEditing();
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debe introducir un valor numérico entero");
            return false;
        }
    }
    
}
