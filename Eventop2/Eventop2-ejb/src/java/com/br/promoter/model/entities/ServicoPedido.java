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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author moura
 */
@Entity
@Table(name = "SERVICO_PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicoPedido.findAll", query = "SELECT s FROM ServicoPedido s"),
    @NamedQuery(name = "ServicoPedido.findByIdServicoPedido", query = "SELECT s FROM ServicoPedido s WHERE s.idServicoPedido = :idServicoPedido"),
    @NamedQuery(name = "ServicoPedido.findBySubTotal", query = "SELECT s FROM ServicoPedido s WHERE s.subTotal = :subTotal")})
public class ServicoPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SERVICO_PEDIDO")
    private Integer idServicoPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUB_TOTAL")
    private double subTotal;
    @JoinColumn(name = "ID_ORCAMENTO", referencedColumnName = "ID_ORCAMENTO")
    @ManyToOne(optional = false)
    private Orcamento idOrcamento;
    @JoinColumn(name = "ID_SERVICO", referencedColumnName = "ID_SERVICO")
    @ManyToOne(optional = false)
    private Servico idServico;

    public ServicoPedido() {
    }

    public ServicoPedido(Integer idServicoPedido) {
        this.idServicoPedido = idServicoPedido;
    }

    public ServicoPedido(Integer idServicoPedido, double subTotal) {
        this.idServicoPedido = idServicoPedido;
        this.subTotal = subTotal;
    }

    public Integer getIdServicoPedido() {
        return idServicoPedido;
    }

    public void setIdServicoPedido(Integer idServicoPedido) {
        this.idServicoPedido = idServicoPedido;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Orcamento getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(Orcamento idOrcamento) {
        this.idOrcamento = idOrcamento;
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
        hash += (idServicoPedido != null ? idServicoPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicoPedido)) {
            return false;
        }
        ServicoPedido other = (ServicoPedido) object;
        if ((this.idServicoPedido == null && other.idServicoPedido != null) || (this.idServicoPedido != null && !this.idServicoPedido.equals(other.idServicoPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.promoter.model.entities.ServicoPedido[ idServicoPedido=" + idServicoPedido + " ]";
    }
    
}
