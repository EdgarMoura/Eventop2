/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.model.entities;

import java.io.Serializable;
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
    @NamedQuery(name = "Orcamento.findByIdOrcamento", query = "SELECT o FROM Orcamento o WHERE o.idOrcamento = :idOrcamento")})
public class Orcamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ORCAMENTO")
    private Integer idOrcamento;
    @OneToMany(mappedBy = "fkOrcamento")
    private List<Produto> produtoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orcamento")
    private Comida comida;
    @JoinColumn(name = "FK_SOLICITACAO", referencedColumnName = "ID_SOLICITACAO")
    @ManyToOne
    private Solicitacao fkSolicitacao;
    @JoinColumn(name = "FK_USUARIOPROMOTER", referencedColumnName = "IDUSUARIOCLIENTE")
    @ManyToOne
    private UsuarioCliente fkUsuariopromoter;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orcamento")
    private Endereco endereco;

    public Orcamento() {
    }

    public Orcamento(Integer idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public Integer getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(Integer idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public Solicitacao getFkSolicitacao() {
        return fkSolicitacao;
    }

    public void setFkSolicitacao(Solicitacao fkSolicitacao) {
        this.fkSolicitacao = fkSolicitacao;
    }

    public UsuarioCliente getFkUsuariopromoter() {
        return fkUsuariopromoter;
    }

    public void setFkUsuariopromoter(UsuarioCliente fkUsuariopromoter) {
        this.fkUsuariopromoter = fkUsuariopromoter;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
