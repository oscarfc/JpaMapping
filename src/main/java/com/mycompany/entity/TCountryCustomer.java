/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "t_CountryCustomer")
@NamedQueries({
    @NamedQuery(name = "TCountryCustomer.findAll", query = "SELECT t FROM TCountryCustomer t"),
    @NamedQuery(name = "TCountryCustomer.findByIdCountryCustomer", query = "SELECT t FROM TCountryCustomer t WHERE t.idCountryCustomer = :idCountryCustomer"),
    @NamedQuery(name = "TCountryCustomer.findByCountry", query = "SELECT t FROM TCountryCustomer t WHERE t.country = :country"),
    @NamedQuery(name = "TCountryCustomer.findByPricePack", query = "SELECT t FROM TCountryCustomer t WHERE t.pricePack = :pricePack")})
public class TCountryCustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_CountryCustomer")
    private Integer idCountryCustomer;
    @Basic(optional = false)
    @Column(name = "country")
    private String country;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "pricePack")
    private BigDecimal pricePack;

    public TCountryCustomer() {
    }

    public TCountryCustomer(Integer idCountryCustomer) {
        this.idCountryCustomer = idCountryCustomer;
    }

    public TCountryCustomer(Integer idCountryCustomer, String country, BigDecimal pricePack) {
        this.idCountryCustomer = idCountryCustomer;
        this.country = country;
        this.pricePack = pricePack;
    }

    public Integer getIdCountryCustomer() {
        return idCountryCustomer;
    }

    public void setIdCountryCustomer(Integer idCountryCustomer) {
        this.idCountryCustomer = idCountryCustomer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getPricePack() {
        return pricePack;
    }

    public void setPricePack(BigDecimal pricePack) {
        this.pricePack = pricePack;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCountryCustomer != null ? idCountryCustomer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TCountryCustomer)) {
            return false;
        }
        TCountryCustomer other = (TCountryCustomer) object;
        if ((this.idCountryCustomer == null && other.idCountryCustomer != null) || (this.idCountryCustomer != null && !this.idCountryCustomer.equals(other.idCountryCustomer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.TCountryCustomer[ idCountryCustomer=" + idCountryCustomer + " ]";
    }

}
