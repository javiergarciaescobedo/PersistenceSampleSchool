package persistencesampleschool.model;

import persistencesampleschool.data.SchoolGroups;
import persistencesampleschool.data.SchoolGroup;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class SchoolGroupsTableModel extends AbstractTableModel {

    private SchoolGroups schoolGroups;
    private boolean schoolGroupSavePending;

    public SchoolGroupsTableModel(SchoolGroups schoolGroups) {
        this.schoolGroups = schoolGroups;
        this.addTableModelListener(new SchoolGroupsTableModelListener());
        this.schoolGroupSavePending = false;
    }

    public boolean isSchoolGroupSavePending() {
        return schoolGroupSavePending;
    }

    public void setSchoolGroupSavePending(boolean schoolGroupSavePending) {
        this.schoolGroupSavePending = schoolGroupSavePending;
    }
    
    @Override
    public int getRowCount() {
        return schoolGroups.getSchoolGroupList().size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SchoolGroup classGroup = schoolGroups.getSchoolGroupList().get(rowIndex);
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
        SchoolGroup classGroup = schoolGroups.getSchoolGroupList().get(rowIndex);
        switch(columnIndex) {
            case 0:
                classGroup.setName((String)aValue);
                break;
            case 1:
                classGroup.setCapacity(Integer.valueOf(String.valueOf(aValue)));
                break;
        }     
        schoolGroupSavePending = true;
    }
    
    private class SchoolGroupsTableModelListener implements TableModelListener {

        @Override
        public void tableChanged(TableModelEvent e) {
            schoolGroupSavePending = true;
        }
        
    }
}
