/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.model.dao;

import com.br.promoter.exceptions.DBException;
import com.br.promoter.exceptions.DBExceptionEnum;
import com.br.promoter.model.entities.Orcamento;
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
public class OrcamentoDAO implements GenericDAO<Orcamento>{
    @PersistenceContext(unitName = "Eventop2_pu", type = PersistenceContextType.TRANSACTION)
    EntityManager em;

    @Override
    public void persist(Orcamento e) {
       try {
            em.persist(e);
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.PERSIST_ERROR);
        }
    }

    @Override
    public List<Orcamento> find() {
       List<Orcamento> lista = em.createNamedQuery("Orcamento.findAll", Orcamento.class).getResultList();
        if (lista == null) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return lista;
    }

    @Override
    public Orcamento findById(Integer id) {
         Orcamento orcamentos = em.find(Orcamento.class, id);
        if (orcamentos == null) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return orcamentos;
    }

    @Override
    public void remove(Integer id) {
       try {
            em.remove(em.find(Orcamento.class, id));
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.REMOVE_ERROR);
        }
    }

    @Override
    public void update(Orcamento e) {
         try {
            em.merge(e);
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.REMOVE_ERROR);
        }
    }
}
