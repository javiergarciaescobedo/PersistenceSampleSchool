package persistencesampleschool.model;

import javax.swing.table.AbstractTableModel;
import persistencesampleschool.data.SchoolStudent;
import persistencesampleschool.data.SchoolStudents;

public class SchoolStudentsTableModel extends AbstractTableModel {

    private SchoolStudents schoolStudents;

    public SchoolStudentsTableModel(SchoolStudents schoolStudents) {
        this.schoolStudents = schoolStudents;
    }
    
    @Override
    public int getRowCount() {
        return schoolStudents.getSchoolStudentList().size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SchoolStudent schoolStudent = schoolStudents.getSchoolStudentList().get(rowIndex);
        switch(columnIndex) {
            case 0:
                return schoolStudent.getSurnames() + ", " + schoolStudent.getName();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Estudiante";
            default:
                return null;
        }
    }    
    
}
