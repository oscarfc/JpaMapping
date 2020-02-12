/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
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
@Table(name = "t_options")
@NamedQueries({
    @NamedQuery(name = "TOptions.findAll", query = "SELECT t FROM TOptions t"),
    @NamedQuery(name = "TOptions.findByIdtoptions", query = "SELECT t FROM TOptions t WHERE t.idtoptions = :idtoptions"),
    @NamedQuery(name = "TOptions.findByMesiCalcoloRipristino", query = "SELECT t FROM TOptions t WHERE t.mesiCalcoloRipristino = :mesiCalcoloRipristino"),
    @NamedQuery(name = "TOptions.findByDominio", query = "SELECT t FROM TOptions t WHERE t.dominio = :dominio")})
public class TOptions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtoptions")
    private Integer idtoptions;
    @Basic(optional = false)
    @Column(name = "mesi_calcolo_ripristino")
    private int mesiCalcoloRipristino;
    @Basic(optional = false)
    @Column(name = "dominio")
    private String dominio;

    public TOptions() {
    }

    public TOptions(Integer idtoptions) {
        this.idtoptions = idtoptions;
    }

    public TOptions(Integer idtoptions, int mesiCalcoloRipristino, String dominio) {
        this.idtoptions = idtoptions;
        this.mesiCalcoloRipristino = mesiCalcoloRipristino;
        this.dominio = dominio;
    }

    public Integer getIdtoptions() {
        return idtoptions;
    }

    public void setIdtoptions(Integer idtoptions) {
        this.idtoptions = idtoptions;
    }

    public int getMesiCalcoloRipristino() {
        return mesiCalcoloRipristino;
    }

    public void setMesiCalcoloRipristino(int mesiCalcoloRipristino) {
        this.mesiCalcoloRipristino = mesiCalcoloRipristino;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtoptions != null ? idtoptions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TOptions)) {
            return false;
        }
        TOptions other = (TOptions) object;
        if ((this.idtoptions == null && other.idtoptions != null) || (this.idtoptions != null && !this.idtoptions.equals(other.idtoptions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.TOptions[ idtoptions=" + idtoptions + " ]";
    }

}
