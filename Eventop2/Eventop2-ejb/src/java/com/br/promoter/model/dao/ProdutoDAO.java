/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.model.dao;

import com.br.promoter.exceptions.DBException;
import com.br.promoter.exceptions.DBExceptionEnum;
import com.br.promoter.model.entities.Produto;
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
public class ProdutoDAO implements GenericDAO<Produto>{

    @PersistenceContext(unitName = "Eventop2_pu", type = PersistenceContextType.TRANSACTION)
    EntityManager em;
    @Override
    public void persist(Produto e) {
      try {
            em.persist(e);
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.PERSIST_ERROR);
        }
    }

    @Override
    public List<Produto> find() {
        List<Produto> lista = em.createNamedQuery("Produto.findAll",Produto.class).getResultList();
        if (lista == null) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return lista;
    }

    @Override
    public Produto findById(Integer id) {
        Produto produtos = em.find(Produto.class, id);
        if (produtos == null) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return produtos;
    }

    @Override
    public void remove(Integer id) {
       try {
        em.remove(em.find(Produto.class, id));
      } catch (Exception ex) {
        throw new DBException(DBExceptionEnum.REMOVE_ERROR);
      }
   }
       

    @Override
    public void update(Produto e) {
       try {
            em.merge(e);
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.UPDATE_ERROR);
        }
    }
    
}


