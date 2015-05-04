package persistencesampleschool.controller;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import persistencesampleschool.data.SchoolGroup;
import persistencesampleschool.resources.SchoolValues;

public class SchoolGroupsListRenderer extends DefaultListCellRenderer {
    
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        SchoolGroup schoolGroup = (SchoolGroup)value;
        if(value != null) {
            setText(schoolGroup.getName());
            if(isSelected) {
                setBackground(SchoolValues.defaultBackgroundColor);
                setForeground(Color.WHITE);
            } else {
                setBackground(Color.WHITE);
                setForeground(Color.BLACK);
            }
        } else {
            setText("");
        }
        return this;
    }
    
    
}
