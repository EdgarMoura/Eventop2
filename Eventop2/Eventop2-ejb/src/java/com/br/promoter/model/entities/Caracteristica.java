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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "CARACTERISTICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caracteristica.findAll", query = "SELECT c FROM Caracteristica c"),
    @NamedQuery(name = "Caracteristica.findByIdCaract", query = "SELECT c FROM Caracteristica c WHERE c.idCaract = :idCaract"),
    @NamedQuery(name = "Caracteristica.findBySolicitadoEm", query = "SELECT c FROM Caracteristica c WHERE c.solicitadoEm = :solicitadoEm"),
    @NamedQuery(name = "Caracteristica.findByDataEvento", query = "SELECT c FROM Caracteristica c WHERE c.dataEvento = :dataEvento"),
    @NamedQuery(name = "Caracteristica.findByQtdPessoas", query = "SELECT c FROM Caracteristica c WHERE c.qtdPessoas = :qtdPessoas"),
    @NamedQuery(name = "Caracteristica.findByPeriodo", query = "SELECT c FROM Caracteristica c WHERE c.periodo = :periodo"),
    @NamedQuery(name = "Caracteristica.findByNome", query = "SELECT c FROM Caracteristica c WHERE c.nome = :nome"),
    @NamedQuery(name = "Caracteristica.findByEmail", query = "SELECT c FROM Caracteristica c WHERE c.email = :email"),
    @NamedQuery(name = "Caracteristica.findByDescricao", query = "SELECT c FROM Caracteristica c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Caracteristica.findByTema", query = "SELECT c FROM Caracteristica c WHERE c.tema = :tema")})
public class Caracteristica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CARACT")
    private Integer idCaract;
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
    @Size(max = 30)
    @Column(name = "PERIODO")
    private String periodo;
    @Size(max = 30)
    @Column(name = "NOME")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 255)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Size(max = 30)
    @Column(name = "TEMA")
    private String tema;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCaract")
    private List<Evento> eventoList;

    public Caracteristica() {
    }

    public Caracteristica(Integer idCaract) {
        this.idCaract = idCaract;
    }

    public Caracteristica(Integer idCaract, Date solicitadoEm, Date dataEvento, int qtdPessoas) {
        this.idCaract = idCaract;
        this.solicitadoEm = solicitadoEm;
        this.dataEvento = dataEvento;
        this.qtdPessoas = qtdPessoas;
    }

    public Integer getIdCaract() {
        return idCaract;
    }

    public void setIdCaract(Integer idCaract) {
        this.idCaract = idCaract;
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

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCaract != null ? idCaract.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caracteristica)) {
            return false;
        }
        Caracteristica other = (Caracteristica) object;
        if ((this.idCaract == null && other.idCaract != null) || (this.idCaract != null && !this.idCaract.equals(other.idCaract))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.promoter.model.entities.Caracteristica[ idCaract=" + idCaract + " ]";
    }
    
}
