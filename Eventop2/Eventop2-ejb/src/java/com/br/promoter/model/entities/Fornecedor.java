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
@Table(name = "FORNECEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByIdFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.idFornecedor = :idFornecedor"),
    @NamedQuery(name = "Fornecedor.findByNome", query = "SELECT f FROM Fornecedor f WHERE f.nome = :nome"),
    @NamedQuery(name = "Fornecedor.findByObservacoes", query = "SELECT f FROM Fornecedor f WHERE f.observacoes = :observacoes"),
    @NamedQuery(name = "Fornecedor.findByCnpj", query = "SELECT f FROM Fornecedor f WHERE f.cnpj = :cnpj")})
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FORNECEDOR")
    private Integer idFornecedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "OBSERVACOES")
    private String observacoes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CNPJ")
    private String cnpj;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFornecedor")
    private List<ServForn> servFornList;

    public Fornecedor() {
    }

    public Fornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Fornecedor(Integer idFornecedor, String nome, String observacoes, String cnpj) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.observacoes = observacoes;
        this.cnpj = cnpj;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @XmlTransient
    public List<ServForn> getServFornList() {
        return servFornList;
    }

    public void setServFornList(List<ServForn> servFornList) {
        this.servFornList = servFornList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFornecedor != null ? idFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.idFornecedor == null && other.idFornecedor != null) || (this.idFornecedor != null && !this.idFornecedor.equals(other.idFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.promoter.model.entities.Fornecedor[ idFornecedor=" + idFornecedor + " ]";
    }
    
}
