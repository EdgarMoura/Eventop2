/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.model.dao;

import com.br.promoter.exceptions.DBException;
import com.br.promoter.exceptions.DBExceptionEnum;
import com.br.promoter.model.entities.Comida;
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
public class ComidaDAO implements GenericDAO<Comida>{
    @PersistenceContext(unitName = "Eventop2_pu", type = PersistenceContextType.TRANSACTION)
    EntityManager em;

    @Override
    public void persist(Comida e) {
        
         try {
            em.persist(e);
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.PERSIST_ERROR);
        }
    }

    @Override
    public List<Comida> find() {
        List<Comida> lista = em.createNamedQuery("Comida.findAll", Comida.class).getResultList();
        if (lista == null) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return lista;
    }

    @Override
    public Comida findById(Integer id) {
       Comida comidas = em.find(Comida.class, id);
        if (comidas == null) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return comidas;
    }

    @Override
    public void remove(Integer id) {
         try {
            em.remove(em.find(Comida.class, id));
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.REMOVE_ERROR);
        }
    }

    @Override
    public void update(Comida e) {
        try {
            em.merge(e);
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.UPDATE_ERROR);
        }
    }
}
