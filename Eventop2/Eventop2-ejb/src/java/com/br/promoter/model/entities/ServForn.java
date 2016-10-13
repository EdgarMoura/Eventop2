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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author moura
 */
@Entity
@Table(name = "SERV_FORN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServForn.findAll", query = "SELECT s FROM ServForn s"),
    @NamedQuery(name = "ServForn.findByIdServforn", query = "SELECT s FROM ServForn s WHERE s.idServforn = :idServforn"),
    @NamedQuery(name = "ServForn.findByStatus", query = "SELECT s FROM ServForn s WHERE s.status = :status")})
public class ServForn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SERVFORN")
    private Integer idServforn;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "ID_FORNECEDOR", referencedColumnName = "ID_FORNECEDOR")
    @ManyToOne(optional = false)
    private Fornecedor idFornecedor;
    @JoinColumn(name = "ID_SERVICO", referencedColumnName = "ID_SERVICO")
    @ManyToOne(optional = false)
    private Servico idServico;

    public ServForn() {
    }

    public ServForn(Integer idServforn) {
        this.idServforn = idServforn;
    }

    public Integer getIdServforn() {
        return idServforn;
    }

    public void setIdServforn(Integer idServforn) {
        this.idServforn = idServforn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Fornecedor getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Fornecedor idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Servico getIdServico() {
        return idServico;
    }

    public void setIdServico(Servico idServico) {
        this.idServico = idServico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServforn != null ? idServforn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServForn)) {
            return false;
        }
        ServForn other = (ServForn) object;
        if ((this.idServforn == null && other.idServforn != null) || (this.idServforn != null && !this.idServforn.equals(other.idServforn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.promoter.model.entities.ServForn[ idServforn=" + idServforn + " ]";
    }
    
}
