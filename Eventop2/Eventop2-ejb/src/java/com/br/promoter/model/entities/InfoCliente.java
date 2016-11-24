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
@Table(name = "INFOCLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoCliente.findAll", query = "SELECT i FROM InfoCliente i"),
    @NamedQuery(name = "InfoCliente.findByIdinfocliente", query = "SELECT i FROM InfoCliente i WHERE i.idinfocliente = :idinfocliente"),
    @NamedQuery(name = "InfoCliente.findByNomecliente", query = "SELECT i FROM InfoCliente i WHERE i.nomecliente = :nomecliente"),
    @NamedQuery(name = "InfoCliente.findByEmail", query = "SELECT i FROM InfoCliente i WHERE i.email = :email"),
    @NamedQuery(name = "InfoCliente.findByTelefone", query = "SELECT i FROM InfoCliente i WHERE i.telefone = :telefone"),
    @NamedQuery(name = "InfoCliente.findByCpf", query = "SELECT i FROM InfoCliente i WHERE i.cpf = :cpf"),
    @NamedQuery(name = "InfoCliente.findByCnpj", query = "SELECT i FROM InfoCliente i WHERE i.cnpj = :cnpj")})
public class InfoCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDINFOCLIENTE")
    private Integer idinfocliente;
    @Size(max = 130)
    @Column(name = "NOMECLIENTE")
    private String nomecliente;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 130)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 18)
    @Column(name = "TELEFONE")
    private String telefone;
    @Size(max = 16)
    @Column(name = "CPF")
    private String cpf;
    @Size(max = 20)
    @Column(name = "CNPJ")
    private String cnpj;
    @JoinColumn(name = "IDINFOCLIENTE", referencedColumnName = "IDUSUARIOCLIENTE", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UsuarioCliente usuarioCliente;

    public InfoCliente() {
    }

    public InfoCliente(Integer idinfocliente) {
        this.idinfocliente = idinfocliente;
    }

    public Integer getIdinfocliente() {
        return idinfocliente;
    }

    public void setIdinfocliente(Integer idinfocliente) {
        this.idinfocliente = idinfocliente;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public UsuarioCliente getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(UsuarioCliente usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinfocliente != null ? idinfocliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoCliente)) {
            return false;
        }
        InfoCliente other = (InfoCliente) object;
        if ((this.idinfocliente == null && other.idinfocliente != null) || (this.idinfocliente != null && !this.idinfocliente.equals(other.idinfocliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idinfocliente+" - " +nomecliente;
    }
    
}
