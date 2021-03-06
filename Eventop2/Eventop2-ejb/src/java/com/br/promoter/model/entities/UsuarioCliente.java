/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.model.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
    @OneToMany(mappedBy = "fkUsuarioFornecedor")
    private List<Servico> servicoList;
    @OneToMany(mappedBy = "fkUsuario")
    private List<Anuncio> anuncioList;
    @JoinColumn(name = "FK_PERMISSAO", referencedColumnName = "IDPERMISSAO")
    @ManyToOne
    private Permissao fkPermissao;
    @OneToMany(mappedBy = "fkUsuariopromoter")
    private List<Orcamento> orcamentoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuarioCliente")
    private InfoCliente infoCliente;
    @OneToMany(mappedBy = "fkUsuarioCliente")
    private List<Solicitacao> solicitacaoList;

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

    @XmlTransient
    public List<Servico> getServicoList() {
        return servicoList;
    }

    public void setServicoList(List<Servico> servicoList) {
        this.servicoList = servicoList;
    }

    @XmlTransient
    public List<Anuncio> getAnuncioList() {
        return anuncioList;
    }

    public void setAnuncioList(List<Anuncio> anuncioList) {
        this.anuncioList = anuncioList;
    }

    public Permissao getFkPermissao() {
        return fkPermissao;
    }

    public void setFkPermissao(Permissao fkPermissao) {
        this.fkPermissao = fkPermissao;
    }

    @XmlTransient
    public List<Orcamento> getOrcamentoList() {
        return orcamentoList;
    }

    public void setOrcamentoList(List<Orcamento> orcamentoList) {
        this.orcamentoList = orcamentoList;
    }

    public InfoCliente getInfoCliente() {
        return infoCliente;
    }

    public void setInfoCliente(InfoCliente infoCliente) {
        this.infoCliente = infoCliente;
    }

    @XmlTransient
    public List<Solicitacao> getSolicitacaoList() {
        return solicitacaoList;
    }

    public void setSolicitacaoList(List<Solicitacao> solicitacaoList) {
        this.solicitacaoList = solicitacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuariocliente != null ? idusuariocliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioCliente other = (UsuarioCliente) obj;
        if (!Objects.equals(this.idusuariocliente, other.idusuariocliente)) {
            return false;
        }
        return Objects.equals(this.infoCliente, other.infoCliente);
    }

 @Override
    public String toString() {
        return idusuariocliente+" - " + username;
    }

}
