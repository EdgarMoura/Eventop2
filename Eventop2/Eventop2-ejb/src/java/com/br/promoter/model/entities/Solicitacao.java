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
@Table(name = "SOLICITACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitacao.findAll", query = "SELECT s FROM Solicitacao s"),
    @NamedQuery(name = "Solicitacao.findByIdSolicitacao", query = "SELECT s FROM Solicitacao s WHERE s.idSolicitacao = :idSolicitacao"),
    @NamedQuery(name = "Solicitacao.findBySolicitadoEm", query = "SELECT s FROM Solicitacao s WHERE s.solicitadoEm = :solicitadoEm"),
    @NamedQuery(name = "Solicitacao.findByDataEvento", query = "SELECT s FROM Solicitacao s WHERE s.dataEvento = :dataEvento"),
    @NamedQuery(name = "Solicitacao.findByQtdPessoas", query = "SELECT s FROM Solicitacao s WHERE s.qtdPessoas = :qtdPessoas"),
    @NamedQuery(name = "Solicitacao.findByPeriodo", query = "SELECT s FROM Solicitacao s WHERE s.periodo = :periodo"),
    @NamedQuery(name = "Solicitacao.findByNome", query = "SELECT s FROM Solicitacao s WHERE s.nome = :nome"),
    @NamedQuery(name = "Solicitacao.findByEmail", query = "SELECT s FROM Solicitacao s WHERE s.email = :email"),
    @NamedQuery(name = "Solicitacao.findByDescricao", query = "SELECT s FROM Solicitacao s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "Solicitacao.findByTema", query = "SELECT s FROM Solicitacao s WHERE s.tema = :tema")})
public class Solicitacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SOLICITACAO")
    private Integer idSolicitacao;
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
    @OneToMany(mappedBy = "fkSolicitacao")
    private List<Orcamento> orcamentoList;
    @JoinColumn(name = "FK_USUARIO_CLIENTE", referencedColumnName = "IDUSUARIOCLIENTE")
    @ManyToOne
    private UsuarioCliente fkUsuarioCliente;

    public Solicitacao() {
    }

    public Solicitacao(Integer idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public Solicitacao(Integer idSolicitacao, Date solicitadoEm, Date dataEvento, int qtdPessoas) {
        this.idSolicitacao = idSolicitacao;
        this.solicitadoEm = solicitadoEm;
        this.dataEvento = dataEvento;
        this.qtdPessoas = qtdPessoas;
    }

    public Integer getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(Integer idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
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
    public List<Orcamento> getOrcamentoList() {
        return orcamentoList;
    }

    public void setOrcamentoList(List<Orcamento> orcamentoList) {
        this.orcamentoList = orcamentoList;
    }

    public UsuarioCliente getFkUsuarioCliente() {
        return fkUsuarioCliente;
    }

    public void setFkUsuarioCliente(UsuarioCliente fkUsuarioCliente) {
        this.fkUsuarioCliente = fkUsuarioCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitacao != null ? idSolicitacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitacao)) {
            return false;
        }
        Solicitacao other = (Solicitacao) object;
        if ((this.idSolicitacao == null && other.idSolicitacao != null) || (this.idSolicitacao != null && !this.idSolicitacao.equals(other.idSolicitacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.promoter.model.entities.Solicitacao[ idSolicitacao=" + idSolicitacao + " ]";
    }
    
}
