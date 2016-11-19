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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "ORCAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamento.findAll", query = "SELECT o FROM Orcamento o"),
    @NamedQuery(name = "Orcamento.findByIdOrcamento", query = "SELECT o FROM Orcamento o WHERE o.idOrcamento = :idOrcamento"),
    @NamedQuery(name = "Orcamento.findBySolicitadoEm", query = "SELECT o FROM Orcamento o WHERE o.solicitadoEm = :solicitadoEm"),
    @NamedQuery(name = "Orcamento.findByDataEvento", query = "SELECT o FROM Orcamento o WHERE o.dataEvento = :dataEvento"),
    @NamedQuery(name = "Orcamento.findByQtdPessoas", query = "SELECT o FROM Orcamento o WHERE o.qtdPessoas = :qtdPessoas"),
    @NamedQuery(name = "Orcamento.findByPeriodo", query = "SELECT o FROM Orcamento o WHERE o.periodo = :periodo"),
    @NamedQuery(name = "Orcamento.findByDescricao", query = "SELECT o FROM Orcamento o WHERE o.descricao = :descricao"),
    @NamedQuery(name = "Orcamento.findByTema", query = "SELECT o FROM Orcamento o WHERE o.tema = :tema")})
public class Orcamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ORCAMENTO")
    private Integer idOrcamento;
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
    @Size(max = 255)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Size(max = 30)
    @Column(name = "TEMA")
    private String tema;
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

    public Orcamento(Integer idOrcamento, Date solicitadoEm, Date dataEvento, int qtdPessoas) {
        this.idOrcamento = idOrcamento;
        this.solicitadoEm = solicitadoEm;
        this.dataEvento = dataEvento;
        this.qtdPessoas = qtdPessoas;
    }

    public Integer getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(Integer idOrcamento) {
        this.idOrcamento = idOrcamento;
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
