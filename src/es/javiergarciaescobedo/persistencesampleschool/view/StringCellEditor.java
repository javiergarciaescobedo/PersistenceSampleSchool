package es.javiergarciaescobedo.persistencesampleschool.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StringCellEditor extends DefaultCellEditor {
    
    private JTextField jTextField;

    public StringCellEditor(JTextField jTextField) {
        super(jTextField);
        this.jTextField = jTextField;
        // Set a border for JTextfield component. Otherwise, it has a big margin
        this.jTextField.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));
    }

    @Override
    public boolean stopCellEditing() {
        // Only allow stop editing if text size is not greater than 
        //  jTextField columns property
        if(jTextField.getColumns() > 0 && 
                jTextField.getText().length() > jTextField.getColumns()) {
            JOptionPane.showMessageDialog(null, "La longitud máxima es " + jTextField.getColumns());
            return false;
        } else {
            return super.stopCellEditing();
        }
    }
    
}
