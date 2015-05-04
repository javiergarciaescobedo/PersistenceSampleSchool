package persistencesampleschool.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class SchoolStudents {

    private List<SchoolStudent> schoolStudentList;

    public List<SchoolStudent> getSchoolStudentList() {
        return schoolStudentList;
    }            

    public void setSchoolGroupList(List<SchoolStudent> schoolStudentList) {
        this.schoolStudentList = schoolStudentList;
    }
    
    public List<SchoolStudent> findAll(EntityManager entityManager) {
        // Load data from database
        Query query = entityManager.createNamedQuery("SchoolStudent.findAll");
        schoolStudentList = query.getResultList();
        return schoolStudentList;
    } 
    
}
