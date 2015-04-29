package es.javiergarciaescobedo.persistencesampleschool.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ClassGroups {

    private List<ClassGroup> classGroupList;
    private EntityManager entityManager;

    public ClassGroups(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<ClassGroup> getClassGroupList() {
        return classGroupList;
    }            
    
    public ClassGroup createClassGroup() {
        ClassGroup classGroup = new ClassGroup(0, "");
        classGroupList.add(classGroup);
        return classGroup;
    }
    
    public void loadFromDatabase() {
        Query query = entityManager.createNamedQuery("ClassGroup.findAll");
        classGroupList = query.getResultList();
    }
    
}
