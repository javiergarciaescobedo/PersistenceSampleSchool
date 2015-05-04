/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencesampleschool.data;

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

/**
 *
 * @author javier
 */
@Entity
@Table(name = "SCHOOL_GROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolGroup.findAll", query = "SELECT s FROM SchoolGroup s"),
    @NamedQuery(name = "SchoolGroup.findById", query = "SELECT s FROM SchoolGroup s WHERE s.id = :id"),
    @NamedQuery(name = "SchoolGroup.findByName", query = "SELECT s FROM SchoolGroup s WHERE s.name = :name"),
    @NamedQuery(name = "SchoolGroup.findByCapacity", query = "SELECT s FROM SchoolGroup s WHERE s.capacity = :capacity")})
public class SchoolGroup implements Serializable {
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
    @OneToMany(mappedBy = "schoolGroup")
    private Collection<SchoolStudent> schoolStudentCollection;

    public SchoolGroup() {
    }

    public SchoolGroup(Integer id) {
        this.id = id;
    }

    public SchoolGroup(Integer id, String name) {
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
    public Collection<SchoolStudent> getSchoolStudentCollection() {
        return schoolStudentCollection;
    }

    public void setSchoolStudentCollection(Collection<SchoolStudent> schoolStudentCollection) {
        this.schoolStudentCollection = schoolStudentCollection;
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
        if (!(object instanceof SchoolGroup)) {
            return false;
        }
        SchoolGroup other = (SchoolGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencesampleschool.model.SchoolGroup[ id=" + id + " ]";
    }
    
}
