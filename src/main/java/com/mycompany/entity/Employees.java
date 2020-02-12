/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "Employees")
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
    @NamedQuery(name = "Employees.findByEmployeeID", query = "SELECT e FROM Employees e WHERE e.employeeID = :employeeID"),
    @NamedQuery(name = "Employees.findByLastName", query = "SELECT e FROM Employees e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Employees.findByFirstName", query = "SELECT e FROM Employees e WHERE e.firstName = :firstName"),
    @NamedQuery(name = "Employees.findByTitle", query = "SELECT e FROM Employees e WHERE e.title = :title"),
    @NamedQuery(name = "Employees.findByTitleOfCourtesy", query = "SELECT e FROM Employees e WHERE e.titleOfCourtesy = :titleOfCourtesy"),
    @NamedQuery(name = "Employees.findByBirthDate", query = "SELECT e FROM Employees e WHERE e.birthDate = :birthDate"),
    @NamedQuery(name = "Employees.findByHireDate", query = "SELECT e FROM Employees e WHERE e.hireDate = :hireDate"),
    @NamedQuery(name = "Employees.findByAddress", query = "SELECT e FROM Employees e WHERE e.address = :address"),
    @NamedQuery(name = "Employees.findByCity", query = "SELECT e FROM Employees e WHERE e.city = :city"),
    @NamedQuery(name = "Employees.findByRegion", query = "SELECT e FROM Employees e WHERE e.region = :region"),
    @NamedQuery(name = "Employees.findByPostalCode", query = "SELECT e FROM Employees e WHERE e.postalCode = :postalCode"),
    @NamedQuery(name = "Employees.findByCountry", query = "SELECT e FROM Employees e WHERE e.country = :country"),
    @NamedQuery(name = "Employees.findByHomePhone", query = "SELECT e FROM Employees e WHERE e.homePhone = :homePhone"),
    @NamedQuery(name = "Employees.findByExtension", query = "SELECT e FROM Employees e WHERE e.extension = :extension"),
    @NamedQuery(name = "Employees.findByPhotoPath", query = "SELECT e FROM Employees e WHERE e.photoPath = :photoPath"),
    @NamedQuery(name = "Employees.findBySalary", query = "SELECT e FROM Employees e WHERE e.salary = :salary")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EmployeeID")
    private Integer employeeID;
    @Basic(optional = false)
    @Column(name = "LastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "Title")
    private String title;
    @Column(name = "TitleOfCourtesy")
    private String titleOfCourtesy;
    @Column(name = "BirthDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    @Column(name = "HireDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;
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
    @Column(name = "HomePhone")
    private String homePhone;
    @Column(name = "Extension")
    private String extension;
    @Lob
    @Column(name = "Photo")
    private byte[] photo;
    @Basic(optional = false)
    @Lob
    @Column(name = "Notes")
    private String notes;
    @Column(name = "PhotoPath")
    private String photoPath;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Salary")
    private Float salary;
    @JoinTable(name = "EmployeeTerritories", joinColumns = {
        @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")}, inverseJoinColumns = {
        @JoinColumn(name = "TerritoryID", referencedColumnName = "TerritoryID")})
    @ManyToMany
    private Collection<Territories> territoriesCollection;
    @OneToMany(mappedBy = "employeeID")
    private Collection<Orders> ordersCollection;
    @OneToMany(mappedBy = "reportsTo")
    private Collection<Employees> employeesCollection;
    @JoinColumn(name = "ReportsTo", referencedColumnName = "EmployeeID")
    @ManyToOne
    private Employees reportsTo;

    public Employees() {
    }

    public Employees(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Employees(Integer employeeID, String lastName, String firstName, String notes) {
        this.employeeID = employeeID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.notes = notes;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleOfCourtesy() {
        return titleOfCourtesy;
    }

    public void setTitleOfCourtesy(String titleOfCourtesy) {
        this.titleOfCourtesy = titleOfCourtesy;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
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

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Collection<Territories> getTerritoriesCollection() {
        return territoriesCollection;
    }

    public void setTerritoriesCollection(Collection<Territories> territoriesCollection) {
        this.territoriesCollection = territoriesCollection;
    }

    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }

    public Employees getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employees reportsTo) {
        this.reportsTo = reportsTo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeID != null ? employeeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.employeeID == null && other.employeeID != null) || (this.employeeID != null && !this.employeeID.equals(other.employeeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Employees[ employeeID=" + employeeID + " ]";
    }

}
