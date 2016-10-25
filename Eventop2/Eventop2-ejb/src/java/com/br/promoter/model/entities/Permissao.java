/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author moura
 */
@Entity
@Table(name = "PERMISSAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permissao.findAll", query = "SELECT p FROM Permissao p"),
    @NamedQuery(name = "Permissao.findByIdpermissao", query = "SELECT p FROM Permissao p WHERE p.idpermissao = :idpermissao"),
    @NamedQuery(name = "Permissao.findByTitlo", query = "SELECT p FROM Permissao p WHERE p.titlo = :titlo")})
public class Permissao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPERMISSAO")
    private Integer idpermissao;
    @Size(max = 20)
    @Column(name = "TITLO")
    private String titlo;
    @OneToMany(mappedBy = "fkPermissao")
    private List<UsuarioCliente> usuarioClienteList;

    public Permissao() {
    }

    public Permissao(Integer idpermissao) {
        this.idpermissao = idpermissao;
    }

    public Integer getIdpermissao() {
        return idpermissao;
    }

    public void setIdpermissao(Integer idpermissao) {
        this.idpermissao = idpermissao;
    }

    public String getTitlo() {
        return titlo;
    }

    public void setTitlo(String titlo) {
        this.titlo = titlo;
    }

    @XmlTransient
    public List<UsuarioCliente> getUsuarioClienteList() {
        return usuarioClienteList;
    }

    public void setUsuarioClienteList(List<UsuarioCliente> usuarioClienteList) {
        this.usuarioClienteList = usuarioClienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpermissao != null ? idpermissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permissao)) {
            return false;
        }
        Permissao other = (Permissao) object;
        if ((this.idpermissao == null && other.idpermissao != null) || (this.idpermissao != null && !this.idpermissao.equals(other.idpermissao))) {
            return false;
        }
        return true;
    }

  @Override
    public String toString() {
        return idpermissao+ " - " + titlo;
    }
}
