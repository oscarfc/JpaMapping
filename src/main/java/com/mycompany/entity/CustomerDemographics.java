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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "CustomerDemographics")
@NamedQueries({
    @NamedQuery(name = "CustomerDemographics.findAll", query = "SELECT c FROM CustomerDemographics c"),
    @NamedQuery(name = "CustomerDemographics.findByCustomerTypeID", query = "SELECT c FROM CustomerDemographics c WHERE c.customerTypeID = :customerTypeID")})
public class CustomerDemographics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CustomerTypeID")
    private String customerTypeID;
    @Lob
    @Column(name = "CustomerDesc")
    private String customerDesc;
    @JoinTable(name = "CustomerCustomerDemo", joinColumns = {
        @JoinColumn(name = "CustomerTypeID", referencedColumnName = "CustomerTypeID")}, inverseJoinColumns = {
        @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")})
    @ManyToMany
    private Collection<Customers> customersCollection;

    public CustomerDemographics() {
    }

    public CustomerDemographics(String customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    public String getCustomerTypeID() {
        return customerTypeID;
    }

    public void setCustomerTypeID(String customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    public String getCustomerDesc() {
        return customerDesc;
    }

    public void setCustomerDesc(String customerDesc) {
        this.customerDesc = customerDesc;
    }

    public Collection<Customers> getCustomersCollection() {
        return customersCollection;
    }

    public void setCustomersCollection(Collection<Customers> customersCollection) {
        this.customersCollection = customersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerTypeID != null ? customerTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerDemographics)) {
            return false;
        }
        CustomerDemographics other = (CustomerDemographics) object;
        if ((this.customerTypeID == null && other.customerTypeID != null) || (this.customerTypeID != null && !this.customerTypeID.equals(other.customerTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.CustomerDemographics[ customerTypeID=" + customerTypeID + " ]";
    }

}
