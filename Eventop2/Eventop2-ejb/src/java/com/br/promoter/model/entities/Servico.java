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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author moura
 */
@Entity
@Table(name = "SERVICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servico.findAll", query = "SELECT s FROM Servico s"),
    @NamedQuery(name = "Servico.findByIdServico", query = "SELECT s FROM Servico s WHERE s.idServico = :idServico"),
    @NamedQuery(name = "Servico.findByNome", query = "SELECT s FROM Servico s WHERE s.nome = :nome"),
    @NamedQuery(name = "Servico.findByPrecoBase", query = "SELECT s FROM Servico s WHERE s.precoBase = :precoBase"),
    @NamedQuery(name = "Servico.findByDescricao", query = "SELECT s FROM Servico s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "Servico.findByIdFornecedor", query = "SELECT s FROM Servico s WHERE s.idFornecedor = :idFornecedor")})
public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SERVICO")
    private Integer idServico;
    @Size(max = 15)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECO_BASE")
    private double precoBase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FORNECEDOR")
    private int idFornecedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServico")
    private List<ServForn> servFornList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServico")
    private List<ServicoPedido> servicoPedidoList;

    public Servico() {
    }

    public Servico(Integer idServico) {
        this.idServico = idServico;
    }

    public Servico(Integer idServico, double precoBase, String descricao, int idFornecedor) {
        this.idServico = idServico;
        this.precoBase = precoBase;
        this.descricao = descricao;
        this.idFornecedor = idFornecedor;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    @XmlTransient
    public List<ServForn> getServFornList() {
        return servFornList;
    }

    public void setServFornList(List<ServForn> servFornList) {
        this.servFornList = servFornList;
    }

    @XmlTransient
    public List<ServicoPedido> getServicoPedidoList() {
        return servicoPedidoList;
    }

    public void setServicoPedidoList(List<ServicoPedido> servicoPedidoList) {
        this.servicoPedidoList = servicoPedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServico != null ? idServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servico)) {
            return false;
        }
        Servico other = (Servico) object;
        if ((this.idServico == null && other.idServico != null) || (this.idServico != null && !this.idServico.equals(other.idServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.promoter.model.entities.Servico[ idServico=" + idServico + " ]";
    }
    
}
