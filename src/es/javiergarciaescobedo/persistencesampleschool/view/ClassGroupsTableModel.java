package es.javiergarciaescobedo.persistencesampleschool.view;

import es.javiergarciaescobedo.persistencesampleschool.model.ClassGroups;
import es.javiergarciaescobedo.persistencesampleschool.model.ClassGroup;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class ClassGroupsTableModel extends AbstractTableModel {

    private ClassGroups classGroups;
    private boolean dataChanged;

    public ClassGroupsTableModel(ClassGroups classGroups) {
        this.classGroups = classGroups;
        this.addTableModelListener(new ClassGroupsTableModelListener());
        this.dataChanged = false;
    }

    public boolean isDataChanged() {
        return dataChanged;
    }

    public void setDataChanged(boolean dataChanged) {
        this.dataChanged = dataChanged;
    }
    
    @Override
    public int getRowCount() {
        return classGroups.getClassGroupList().size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ClassGroup classGroup = classGroups.getClassGroupList().get(rowIndex);
        switch(columnIndex) {
            case 0:
                return classGroup.getName();
            case 1:
                return classGroup.getCapacity();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Nombre";
            case 1:
                return "Capacidad";
            default:
                return null;
        }
    }    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        ClassGroup classGroup = classGroups.getClassGroupList().get(rowIndex);
        switch(columnIndex) {
            case 0:
                classGroup.setName((String)aValue);
                break;
            case 1:
                classGroup.setCapacity(Integer.valueOf(String.valueOf(aValue)));
                break;
        }     
        dataChanged = true;
    }
    
    private class ClassGroupsTableModelListener implements TableModelListener {

        @Override
        public void tableChanged(TableModelEvent e) {
            setDataChanged(true);
        }
        
    }
}
