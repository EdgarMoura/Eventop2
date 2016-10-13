/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author moura
 */
@Entity
@Table(name = "ORCAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamento.findAll", query = "SELECT o FROM Orcamento o"),
    @NamedQuery(name = "Orcamento.findByIdOrcamento", query = "SELECT o FROM Orcamento o WHERE o.idOrcamento = :idOrcamento"),
    @NamedQuery(name = "Orcamento.findBySolicitadoEm", query = "SELECT o FROM Orcamento o WHERE o.solicitadoEm = :solicitadoEm"),
    @NamedQuery(name = "Orcamento.findByDataEvento", query = "SELECT o FROM Orcamento o WHERE o.dataEvento = :dataEvento"),
    @NamedQuery(name = "Orcamento.findByQtdPessoas", query = "SELECT o FROM Orcamento o WHERE o.qtdPessoas = :qtdPessoas"),
    @NamedQuery(name = "Orcamento.findByTotal", query = "SELECT o FROM Orcamento o WHERE o.total = :total"),
    @NamedQuery(name = "Orcamento.findByStatus", query = "SELECT o FROM Orcamento o WHERE o.status = :status")})
public class Orcamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ORCAMENTO")
    private Integer idOrcamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOLICITADO_EM")
    @Temporal(TemporalType.DATE)
    private Date solicitadoEm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_EVENTO")
    @Temporal(TemporalType.DATE)
    private Date dataEvento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QTD_PESSOAS")
    private int qtdPessoas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL")
    private Double total;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "IDUSUARIOCLIENTE", referencedColumnName = "IDUSUARIOCLIENTE")
    @ManyToOne(optional = false)
    private UsuarioCliente idusuariocliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrcamento")
    private List<ServicoPedido> servicoPedidoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orcamento")
    private Evento evento;

    public Orcamento() {
    }

    public Orcamento(Integer idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public Orcamento(Integer idOrcamento, Date solicitadoEm, Date dataEvento, int qtdPessoas, String status) {
        this.idOrcamento = idOrcamento;
        this.solicitadoEm = solicitadoEm;
        this.dataEvento = dataEvento;
        this.qtdPessoas = qtdPessoas;
        this.status = status;
    }

    public Integer getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(Integer idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public Date getSolicitadoEm() {
        return solicitadoEm;
    }

    public void setSolicitadoEm(Date solicitadoEm) {
        this.solicitadoEm = solicitadoEm;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UsuarioCliente getIdusuariocliente() {
        return idusuariocliente;
    }

    public void setIdusuariocliente(UsuarioCliente idusuariocliente) {
        this.idusuariocliente = idusuariocliente;
    }

    @XmlTransient
    public List<ServicoPedido> getServicoPedidoList() {
        return servicoPedidoList;
    }

    public void setServicoPedidoList(List<ServicoPedido> servicoPedidoList) {
        this.servicoPedidoList = servicoPedidoList;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrcamento != null ? idOrcamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orcamento)) {
            return false;
        }
        Orcamento other = (Orcamento) object;
        if ((this.idOrcamento == null && other.idOrcamento != null) || (this.idOrcamento != null && !this.idOrcamento.equals(other.idOrcamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.promoter.model.entities.Orcamento[ idOrcamento=" + idOrcamento + " ]";
    }
    
}
