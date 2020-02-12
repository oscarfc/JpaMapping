/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

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

/**
 *
 * @author tss
 */
@Entity
@Table(name = "Shippers")
@NamedQueries({
    @NamedQuery(name = "Shippers.findAll", query = "SELECT s FROM Shippers s"),
    @NamedQuery(name = "Shippers.findByShipperID", query = "SELECT s FROM Shippers s WHERE s.shipperID = :shipperID"),
    @NamedQuery(name = "Shippers.findByCompanyName", query = "SELECT s FROM Shippers s WHERE s.companyName = :companyName"),
    @NamedQuery(name = "Shippers.findByPhone", query = "SELECT s FROM Shippers s WHERE s.phone = :phone")})
public class Shippers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ShipperID")
    private Integer shipperID;
    @Basic(optional = false)
    @Column(name = "CompanyName")
    private String companyName;
    @Column(name = "Phone")
    private String phone;
    @OneToMany(mappedBy = "shipVia")
    private Collection<Orders> ordersCollection;

    public Shippers() {
    }

    public Shippers(Integer shipperID) {
        this.shipperID = shipperID;
    }

    public Shippers(Integer shipperID, String companyName) {
        this.shipperID = shipperID;
        this.companyName = companyName;
    }

    public Integer getShipperID() {
        return shipperID;
    }

    public void setShipperID(Integer shipperID) {
        this.shipperID = shipperID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shipperID != null ? shipperID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shippers)) {
            return false;
        }
        Shippers other = (Shippers) object;
        if ((this.shipperID == null && other.shipperID != null) || (this.shipperID != null && !this.shipperID.equals(other.shipperID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Shippers[ shipperID=" + shipperID + " ]";
    }

}
