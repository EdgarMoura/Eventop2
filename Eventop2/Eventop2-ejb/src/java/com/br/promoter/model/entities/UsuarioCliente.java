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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author moura
 */
@Entity
@Table(name = "USUARIOCLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioCliente.findAll", query = "SELECT u FROM UsuarioCliente u"),
    @NamedQuery(name = "UsuarioCliente.findByIdusuariocliente", query = "SELECT u FROM UsuarioCliente u WHERE u.idusuariocliente = :idusuariocliente"),
    @NamedQuery(name = "UsuarioCliente.findByUsername", query = "SELECT u FROM UsuarioCliente u WHERE u.username = :username"),
    @NamedQuery(name = "UsuarioCliente.findBySenha", query = "SELECT u FROM UsuarioCliente u WHERE u.senha = :senha")})
public class UsuarioCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDUSUARIOCLIENTE")
    private Integer idusuariocliente;
    @Size(max = 40)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 32)
    @Column(name = "SENHA")
    private String senha;
    @JoinColumn(name = "IDPERMISSAO", referencedColumnName = "IDPERMISSAO")
    @ManyToOne
    private Permissao idpermissao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuariocliente")
    private List<Orcamento> orcamentoList;
    @OneToMany(mappedBy = "idusuariocliente")
    private List<Endereco> enderecoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuarioCliente")
    private InfoCliente infoCliente;

    public UsuarioCliente() {
    }

    public UsuarioCliente(Integer idusuariocliente) {
        this.idusuariocliente = idusuariocliente;
    }

    public Integer getIdusuariocliente() {
        return idusuariocliente;
    }

    public void setIdusuariocliente(Integer idusuariocliente) {
        this.idusuariocliente = idusuariocliente;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Permissao getIdpermissao() {
        return idpermissao;
    }

    public void setIdpermissao(Permissao idpermissao) {
        this.idpermissao = idpermissao;
    }

    @XmlTransient
    public List<Orcamento> getOrcamentoList() {
        return orcamentoList;
    }

    public void setOrcamentoList(List<Orcamento> orcamentoList) {
        this.orcamentoList = orcamentoList;
    }

    @XmlTransient
    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    public InfoCliente getInfoCliente() {
        return infoCliente;
    }

    public void setInfoCliente(InfoCliente infoCliente) {
        this.infoCliente = infoCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuariocliente != null ? idusuariocliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioCliente)) {
            return false;
        }
        UsuarioCliente other = (UsuarioCliente) object;
        if ((this.idusuariocliente == null && other.idusuariocliente != null) || (this.idusuariocliente != null && !this.idusuariocliente.equals(other.idusuariocliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.promoter.model.entities.UsuarioCliente[ idusuariocliente=" + idusuariocliente + " ]";
    }
    
}
