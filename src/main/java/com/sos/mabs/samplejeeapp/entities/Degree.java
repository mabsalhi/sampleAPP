/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.samplejeeapp.entities;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abdel
 */
@Entity
@Table(name = "t_degree")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Degree.findAll", query = "SELECT d FROM Degree d"),
    @NamedQuery(name = "Degree.findByIdDegree", query = "SELECT d FROM Degree d WHERE d.idDegree = :idDegree"),
    @NamedQuery(name = "Degree.findByEntitled", query = "SELECT d FROM Degree d WHERE d.entitled = :entitled"),
    @NamedQuery(name = "Degree.findByType", query = "SELECT d FROM Degree d WHERE d.type = :type"),
    @NamedQuery(name = "Degree.findByComment", query = "SELECT d FROM Degree d WHERE d.comment = :comment")})
public class Degree implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_degree")
    private Integer idDegree;
    @Version
    @Column(name = "optimistic_lock")
    private Integer version;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "entitled")
    private String entitled;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "comment")
    private String comment;
    @OneToMany(mappedBy = "degree")
    private List<Qualification> qualificationList;

    public Degree() {
    }

    public Degree(Integer idDegree) {
        this.idDegree = idDegree;
    }

    public Degree(Integer idDegree, String entitled, String type, String comment) {
        this.idDegree = idDegree;
        this.entitled = entitled;
        this.type = type;
        this.comment = comment;
    }

    public Integer getIdDegree() {
        return idDegree;
    }

    public void setIdDegree(Integer idDegree) {
        this.idDegree = idDegree;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getEntitled() {
        return entitled;
    }

    public void setEntitled(String entitled) {
        this.entitled = entitled;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @XmlTransient
    public List<Qualification> getQualificationList() {
        return qualificationList;
    }

    public void setQualificationList(List<Qualification> qualificationList) {
        this.qualificationList = qualificationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDegree != null ? idDegree.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Degree)) {
            return false;
        }
        Degree other = (Degree) object;
        if ((this.idDegree == null && other.idDegree != null) || (this.idDegree != null && !this.idDegree.equals(other.idDegree))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return entitled;
    }
    
}
