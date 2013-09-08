/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.samplejeeapp.entities;

import java.io.Serializable;
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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abdel
 */
@Entity
@Table(name = "t_qualification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qualification.findAll", query = "SELECT q FROM Qualification q"),
    @NamedQuery(name = "Qualification.findByIdQualification", query = "SELECT q FROM Qualification q WHERE q.idQualification = :idQualification"),
    @NamedQuery(name = "Qualification.findByGraduateDate", query = "SELECT q FROM Qualification q WHERE q.graduateDate = :graduateDate"),
    @NamedQuery(name = "Qualification.findByIssuance", query = "SELECT q FROM Qualification q WHERE q.issuance = :issuance"),
    @NamedQuery(name = "Qualification.findByMention", query = "SELECT q FROM Qualification q WHERE q.mention = :mention"),
    @NamedQuery(name = "Qualification.findByComment", query = "SELECT q FROM Qualification q WHERE q.comment = :comment")})
public class Qualification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_qualification")
    private Integer idQualification;
    @Version
    @Column(name = "optimistic_lock")
    private Integer version;
    @Basic(optional = false)
    @NotNull
    @Column(name = "graduate_date")
    @Temporal(TemporalType.DATE)
    private Date graduateDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "issuance")
    private String issuance;
    @Size(max = 45)
    @Column(name = "mention")
    private String mention;
    @Size(max = 255)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "id_person", referencedColumnName = "id_person")
    @ManyToOne
    private Person person;
    @JoinColumn(name = "id_degree", referencedColumnName = "id_degree")
    @ManyToOne
    private Degree degree;

    public Qualification() {
    }

    public Qualification(Integer idQualification) {
        this.idQualification = idQualification;
    }

    public Qualification(Integer idQualification, Date graduateDate, String issuance) {
        this.idQualification = idQualification;
        this.graduateDate = graduateDate;
        this.issuance = issuance;
    }

    public Integer getIdQualification() {
        return idQualification;
    }

    public void setIdQualification(Integer idQualification) {
        this.idQualification = idQualification;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    

    public Date getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(Date graduateDate) {
        this.graduateDate = graduateDate;
    }

    public String getIssuance() {
        return issuance;
    }

    public void setIssuance(String issuance) {
        this.issuance = issuance;
    }

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQualification != null ? idQualification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Qualification)) {
            return false;
        }
        Qualification other = (Qualification) object;
        if ((this.idQualification == null && other.idQualification != null) || (this.idQualification != null && !this.idQualification.equals(other.idQualification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sos.mabs.samplejeeapp.entities.Qualification[ idQualification=" + idQualification + " ]";
    }
    
}
