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
@Table(name = "ANUNCIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anuncio.findAll", query = "SELECT a FROM Anuncio a"),   
    @NamedQuery(name = "Anuncio.findByIdAnuncio", query = "SELECT a FROM Anuncio a WHERE a.idAnuncio = :idAnuncio"),
    @NamedQuery(name = "Anuncio.findByTipoAnuncio", query = "SELECT a FROM Anuncio a WHERE a.tipoAnuncio = :tipoAnuncio"),
    @NamedQuery(name = "Anuncio.findByDescricao", query = "SELECT a FROM Anuncio a WHERE a.descricao = :descricao")})
public class Anuncio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ANUNCIO")
    private Integer idAnuncio;
    @Size(max = 150)
    @Column(name = "TIPO_ANUNCIO")
    private String tipoAnuncio;
    @Size(max = 150)
    @Column(name = "DESCRICAO")
    private String descricao;
    @JoinColumn(name = "FK_USUARIO", referencedColumnName = "IDUSUARIOCLIENTE")
    @ManyToOne
    private UsuarioCliente fkUsuario;

    public Anuncio() {
    }

    public Anuncio(Integer idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public Integer getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(Integer idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getTipoAnuncio() {
        return tipoAnuncio;
    }

    public void setTipoAnuncio(String tipoAnuncio) {
        this.tipoAnuncio = tipoAnuncio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public UsuarioCliente getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(UsuarioCliente fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnuncio != null ? idAnuncio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anuncio)) {
            return false;
        }
        Anuncio other = (Anuncio) object;
        if ((this.idAnuncio == null && other.idAnuncio != null) || (this.idAnuncio != null && !this.idAnuncio.equals(other.idAnuncio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.promoter.model.entities.Anuncio[ idAnuncio=" + idAnuncio + " ]";
    }
    
}
