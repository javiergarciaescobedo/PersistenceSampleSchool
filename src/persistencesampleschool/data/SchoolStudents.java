package persistencesampleschool.data;

import java.util.List;

public class SchoolStudents {

    private List<SchoolStudent> schoolStudentList;

    public List<SchoolStudent> getSchoolStudentList() {
        return schoolStudentList;
    }            

    public void setSchoolGroupList(List<SchoolStudent> schoolStudentList) {
        this.schoolStudentList = schoolStudentList;
    }
    
}
