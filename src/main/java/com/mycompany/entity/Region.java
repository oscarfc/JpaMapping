/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "Region")
@NamedQueries({
    @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r"),
    @NamedQuery(name = "Region.findByRegionID", query = "SELECT r FROM Region r WHERE r.regionID = :regionID"),
    @NamedQuery(name = "Region.findByRegionDescription", query = "SELECT r FROM Region r WHERE r.regionDescription = :regionDescription")})
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RegionID")
    private Integer regionID;
    @Basic(optional = false)
    @Column(name = "RegionDescription")
    private String regionDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regionID")
    private Collection<Territories> territoriesCollection;

    public Region() {
    }

    public Region(Integer regionID) {
        this.regionID = regionID;
    }

    public Region(Integer regionID, String regionDescription) {
        this.regionID = regionID;
        this.regionDescription = regionDescription;
    }

    public Integer getRegionID() {
        return regionID;
    }

    public void setRegionID(Integer regionID) {
        this.regionID = regionID;
    }

    public String getRegionDescription() {
        return regionDescription;
    }

    public void setRegionDescription(String regionDescription) {
        this.regionDescription = regionDescription;
    }

    public Collection<Territories> getTerritoriesCollection() {
        return territoriesCollection;
    }

    public void setTerritoriesCollection(Collection<Territories> territoriesCollection) {
        this.territoriesCollection = territoriesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regionID != null ? regionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.regionID == null && other.regionID != null) || (this.regionID != null && !this.regionID.equals(other.regionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Region[ regionID=" + regionID + " ]";
    }

}
