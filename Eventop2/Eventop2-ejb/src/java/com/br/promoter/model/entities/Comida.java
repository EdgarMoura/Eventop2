/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author moura
 */
@Entity
@Table(name = "COMIDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comida.findAll", query = "SELECT c FROM Comida c"),
    @NamedQuery(name = "Comida.findByIdComida", query = "SELECT c FROM Comida c WHERE c.idComida = :idComida"),
    @NamedQuery(name = "Comida.findByDecricaoComida", query = "SELECT c FROM Comida c WHERE c.decricaoComida = :decricaoComida")})
public class Comida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_COMIDA")
    private Integer idComida;
    @Size(max = 200)
    @Column(name = "DECRICAO_COMIDA")
    private String decricaoComida;
    @JoinColumn(name = "ID_COMIDA", referencedColumnName = "ID_ORCAMENTO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Orcamento orcamento;

    public Comida() {
    }

    public Comida(Integer idComida) {
        this.idComida = idComida;
    }

    public Integer getIdComida() {
        return idComida;
    }

    public void setIdComida(Integer idComida) {
        this.idComida = idComida;
    }

    public String getDecricaoComida() {
        return decricaoComida;
    }

    public void setDecricaoComida(String decricaoComida) {
        this.decricaoComida = decricaoComida;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComida != null ? idComida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comida)) {
            return false;
        }
        Comida other = (Comida) object;
        if ((this.idComida == null && other.idComida != null) || (this.idComida != null && !this.idComida.equals(other.idComida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.promoter.model.entities.Comida[ idComida=" + idComida + " ]";
    }
    
}
