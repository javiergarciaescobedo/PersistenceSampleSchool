package es.javiergarciaescobedo.persistencesampleschool;

import es.javiergarciaescobedo.persistencesampleschool.entity.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class InsertStudent {

    static EntityManager entityManager;
    static List<Student> students;
    
    public static void main(String[] args) {
        entityManager = Persistence.createEntityManagerFactory("PersistenceSampleSchoolPU")
                        .createEntityManager();
        Query query = entityManager.createNamedQuery("Student.findAll");
        students = query.getResultList();

        Student student = new Student();
        student.setName("MIGUEL ANGEL");
        student.setSurnames("MONTOYA GONZALEZ");
        insertStudent(student);
        
        showStudents();
        
        entityManager.close();
    }
    
    public static void insertStudent(Student student) {
        entityManager.getTransaction().begin(); 
        entityManager.persist(student); 
        entityManager.getTransaction().commit();
        
        students.add(student);
    }
    
    public static void showStudents() {
        for (Student student : students) {
            System.out.print(student.getSurnames() + "," + 
                    student.getName());
            if(student.getClassGroup() != null) {
                System.out.print("(" + student.getClassGroup().getName() + ")");
            }
            System.out.println();
        }        
    }
    
    
    
}
