package persistencesampleschool.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JTextField;

public class SchoolDecimalJTextFieldEditor {
    
    public static boolean verifyDecimalValue(JTextField jTextField, int precision, int scale) {
        boolean correct;
        if(!jTextField.getText().isEmpty()) {
            try {
                // Convert written text to numeric type
                BigDecimal bigDecimal = new BigDecimal(jTextField.getText());
                // Round to scale decimals
                bigDecimal = bigDecimal.setScale(scale, RoundingMode.HALF_UP);
                // Show number rounded
                jTextField.setText(bigDecimal.toString());
                // Check if lenth is greater than limit 
                if(jTextField.getText().length() > precision + 1) {
                    correct = false;
                } else {
                    correct = true;
                }
            } catch(NumberFormatException ex) {
                correct = false;
            }
        } else {
            correct = false;
        }
        if(correct) {
            return true;
        } else {
            // Stay on JTextField and preselect text
            jTextField.requestFocus();
            jTextField.setSelectionStart(0);
            jTextField.setSelectionEnd(jTextField.getText().length());
            return false;
        }
    }
    
}
