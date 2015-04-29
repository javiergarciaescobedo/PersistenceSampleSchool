package es.javiergarciaescobedo.persistencesampleschool.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "CLASS_GROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClassGroup.findAll", query = "SELECT c FROM ClassGroup c"),
    @NamedQuery(name = "ClassGroup.findById", query = "SELECT c FROM ClassGroup c WHERE c.id = :id"),
    @NamedQuery(name = "ClassGroup.findByName", query = "SELECT c FROM ClassGroup c WHERE c.name = :name"),
    @NamedQuery(name = "ClassGroup.findByCapacity", query = "SELECT c FROM ClassGroup c WHERE c.capacity = :capacity")})
public class ClassGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "CAPACITY")
    private Integer capacity;
    @OneToMany(mappedBy = "classGroup")
    private Collection<Student> studentCollection;

    public ClassGroup() {
    }

    public ClassGroup(Integer id) {
        this.id = id;
    }

    public ClassGroup(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassGroup)) {
            return false;
        }
        ClassGroup other = (ClassGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.javiergarciaescobedo.persistencesampleschool.entity.ClassGroup[ id=" + id + " ]";
    }
    
}
