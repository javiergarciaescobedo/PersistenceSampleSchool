/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencesampleschool.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author javier
 */
@Entity
@Table(name = "SCHOOL_STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolStudent.findAll", query = "SELECT s FROM SchoolStudent s"),
    @NamedQuery(name = "SchoolStudent.findById", query = "SELECT s FROM SchoolStudent s WHERE s.id = :id"),
    @NamedQuery(name = "SchoolStudent.findByName", query = "SELECT s FROM SchoolStudent s WHERE s.name = :name"),
    @NamedQuery(name = "SchoolStudent.findBySurnames", query = "SELECT s FROM SchoolStudent s WHERE s.surnames = :surnames"),
    @NamedQuery(name = "SchoolStudent.findByDateBirth", query = "SELECT s FROM SchoolStudent s WHERE s.dateBirth = :dateBirth"),
    @NamedQuery(name = "SchoolStudent.findByGrade", query = "SELECT s FROM SchoolStudent s WHERE s.grade = :grade")})
public class SchoolStudent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "SURNAMES")
    private String surnames;
    @Column(name = "DATE_BIRTH")
    @Temporal(TemporalType.DATE)
    private Date dateBirth;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GRADE")
    private BigDecimal grade;
    @JoinColumn(name = "SCHOOL_GROUP", referencedColumnName = "ID")
    @ManyToOne
    private SchoolGroup schoolGroup;

    public SchoolStudent() {
    }

    public SchoolStudent(Integer id) {
        this.id = id;
    }

    public SchoolStudent(Integer id, String name, String surnames) {
        this.id = id;
        this.name = name;
        this.surnames = surnames;
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

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public SchoolGroup getSchoolGroup() {
        return schoolGroup;
    }

    public void setSchoolGroup(SchoolGroup schoolGroup) {
        this.schoolGroup = schoolGroup;
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
        if (!(object instanceof SchoolStudent)) {
            return false;
        }
        SchoolStudent other = (SchoolStudent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencesampleschool.model.SchoolStudent[ id=" + id + " ]";
    }
    
}
