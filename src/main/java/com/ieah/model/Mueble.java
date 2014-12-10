/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieah.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author T107
 */
@Entity
@Table(name = "mueble")
@NamedQueries({
    @NamedQuery(name = "Mueble.findAll", query = "SELECT m FROM Mueble m")})
public class Mueble implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMueble")
    private Integer idMueble;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "tipo")
    private String tipo;

    public Mueble() {
    }

    public Mueble(Integer idMueble) {
        this.idMueble = idMueble;
    }

    public Integer getIdMueble() {
        return idMueble;
    }

    public void setIdMueble(Integer idMueble) {
        this.idMueble = idMueble;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMueble != null ? idMueble.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mueble)) {
            return false;
        }
        Mueble other = (Mueble) object;
        if ((this.idMueble == null && other.idMueble != null) || (this.idMueble != null && !this.idMueble.equals(other.idMueble))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ieah.model.Mueble[ idMueble=" + idMueble + " ]";
    }
    
}
