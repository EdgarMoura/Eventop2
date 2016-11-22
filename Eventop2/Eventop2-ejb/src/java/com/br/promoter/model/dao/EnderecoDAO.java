/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.model.dao;

import com.br.promoter.exceptions.DBException;
import com.br.promoter.exceptions.DBExceptionEnum;
import com.br.promoter.model.entities.Endereco;
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
public class EnderecoDAO implements GenericDAO<Endereco>{
     @PersistenceContext(unitName = "Eventop2_pu", type = PersistenceContextType.TRANSACTION)
     EntityManager em;

    @Override
    public void persist(Endereco e) {
        try {
            em.persist(e);
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.PERSIST_ERROR);
        }
    }

    @Override
    public List<Endereco> find() {
       List<Endereco> lista = em.createNamedQuery("Endereco.findAll", Endereco.class).getResultList();
        if (lista == null) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return lista;
    }

    @Override
    public Endereco findById(Integer id) {
         Endereco enderecos = em.find(Endereco.class, id);
        if (enderecos == null) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return enderecos;
    }

    @Override
    public void remove(Integer id) {
        try {
            em.remove(em.find(Endereco.class, id));
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.REMOVE_ERROR);
        }
    }

    @Override
    public void update(Endereco e) {
         try {
            em.merge(e);
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.UPDATE_ERROR);
        }
    }
}
