package es.javiergarciaescobedo.persistencesampleschool;

import es.javiergarciaescobedo.persistencesampleschool.entity.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/*
Follow these steps if you want some data samples:
- Create a database conection with this path (check YOURPATHTO):
    jdbc:derby:YOURPATHTO/PersistenceSampleSchool/School;create=true
- Open sql/create.sql file from this project in NetBeans and run the script,
selecting above connection
- Disconnect above database connection inside NetBeans
*/

public class Main {
    
    public static void main(String[] args) {
        // Connection with database using an entity manager
        EntityManager entityManager = 
                Persistence.createEntityManagerFactory("PersistenceSampleSchoolPU")
                        .createEntityManager();
        // Execute a query (a generated named query in entity class)
        Query query = entityManager.createNamedQuery("Student.findAll");
        // Get an objects list as result of previous query
        List<Student> resultList = query.getResultList();
        // Iterate the list getting every object
        for (Student student : resultList) {
            System.out.println(student.getSurnames() + "," + 
                    student.getName() + "(" + 
                    student.getClassGroup().getName() + ")");
        }
        // Close connection
        entityManager.close();
    }
    
}
