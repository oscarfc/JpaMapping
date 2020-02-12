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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "Suppliers")
@NamedQueries({
    @NamedQuery(name = "Suppliers.findAll", query = "SELECT s FROM Suppliers s"),
    @NamedQuery(name = "Suppliers.findBySupplierID", query = "SELECT s FROM Suppliers s WHERE s.supplierID = :supplierID"),
    @NamedQuery(name = "Suppliers.findByCompanyName", query = "SELECT s FROM Suppliers s WHERE s.companyName = :companyName"),
    @NamedQuery(name = "Suppliers.findByContactName", query = "SELECT s FROM Suppliers s WHERE s.contactName = :contactName"),
    @NamedQuery(name = "Suppliers.findByContactTitle", query = "SELECT s FROM Suppliers s WHERE s.contactTitle = :contactTitle"),
    @NamedQuery(name = "Suppliers.findByAddress", query = "SELECT s FROM Suppliers s WHERE s.address = :address"),
    @NamedQuery(name = "Suppliers.findByCity", query = "SELECT s FROM Suppliers s WHERE s.city = :city"),
    @NamedQuery(name = "Suppliers.findByRegion", query = "SELECT s FROM Suppliers s WHERE s.region = :region"),
    @NamedQuery(name = "Suppliers.findByPostalCode", query = "SELECT s FROM Suppliers s WHERE s.postalCode = :postalCode"),
    @NamedQuery(name = "Suppliers.findByCountry", query = "SELECT s FROM Suppliers s WHERE s.country = :country"),
    @NamedQuery(name = "Suppliers.findByPhone", query = "SELECT s FROM Suppliers s WHERE s.phone = :phone"),
    @NamedQuery(name = "Suppliers.findByFax", query = "SELECT s FROM Suppliers s WHERE s.fax = :fax")})
public class Suppliers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SupplierID")
    private Integer supplierID;
    @Basic(optional = false)
    @Column(name = "CompanyName")
    private String companyName;
    @Column(name = "ContactName")
    private String contactName;
    @Column(name = "ContactTitle")
    private String contactTitle;
    @Column(name = "Address")
    private String address;
    @Column(name = "City")
    private String city;
    @Column(name = "Region")
    private String region;
    @Column(name = "PostalCode")
    private String postalCode;
    @Column(name = "Country")
    private String country;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Fax")
    private String fax;
    @Lob
    @Column(name = "HomePage")
    private String homePage;
    @OneToMany(mappedBy = "supplierID")
    private Collection<Products> productsCollection;

    public Suppliers() {
    }

    public Suppliers(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public Suppliers(Integer supplierID, String companyName) {
        this.supplierID = supplierID;
        this.companyName = companyName;
    }

    public Integer getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public Collection<Products> getProductsCollection() {
        return productsCollection;
    }

    public void setProductsCollection(Collection<Products> productsCollection) {
        this.productsCollection = productsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplierID != null ? supplierID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suppliers)) {
            return false;
        }
        Suppliers other = (Suppliers) object;
        if ((this.supplierID == null && other.supplierID != null) || (this.supplierID != null && !this.supplierID.equals(other.supplierID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Suppliers[ supplierID=" + supplierID + " ]";
    }

}
