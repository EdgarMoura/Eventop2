/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.model.dao;

import com.br.promoter.exceptions.DBException;
import com.br.promoter.exceptions.DBExceptionEnum;
import com.br.promoter.model.entities.Solicitacao;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author moura
 */
@Stateless
@LocalBean
public class SolicitacaoDAO implements GenericDAO<Solicitacao>{
    @PersistenceContext(unitName = "Eventop2_pu", type = PersistenceContextType.TRANSACTION)
    EntityManager em;

    @Override
    public void persist(Solicitacao e) {
        try {
            em.persist(e);
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.PERSIST_ERROR);
        }
    }

    @Override
    public List<Solicitacao> find() {
        List<Solicitacao> lista = em.createNamedQuery("Solicitacao.findAll", Solicitacao.class).getResultList();
        if (lista == null) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return lista;
    }

    @Override
    public Solicitacao findById(Integer id) {
        Solicitacao solicitacoes = em.find(Solicitacao.class, id);
        if (solicitacoes == null) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return solicitacoes;
    }

    @Override
    public void remove(Integer id) {
       try {
            em.remove(em.find(Solicitacao.class, id));
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.REMOVE_ERROR);
        }
    }

    @Override
    public void update(Solicitacao e) {
        try {
            em.merge(e);
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.UPDATE_ERROR);
        }
    }
}
