package persistencesampleschool.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class SchoolGroups {

    private List<SchoolGroup> schoolGroupList;

    public List<SchoolGroup> getSchoolGroupList() {
        return schoolGroupList;
    }            

    public void setSchoolGroupList(List<SchoolGroup> schoolGroupList) {
        this.schoolGroupList = schoolGroupList;
    }
    
    public List<SchoolGroup> findAll(EntityManager entityManager) {
        // Load data from database
        Query query = entityManager.createNamedQuery("SchoolGroup.findAll");
        schoolGroupList = query.getResultList();
        return schoolGroupList;
    } 
}
