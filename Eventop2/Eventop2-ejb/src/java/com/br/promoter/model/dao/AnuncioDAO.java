/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.model.dao;

import com.br.promoter.exceptions.DBException;
import com.br.promoter.exceptions.DBExceptionEnum;
import com.br.promoter.model.entities.Anuncio;
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
public class AnuncioDAO implements GenericDAO<Anuncio> {

    @PersistenceContext(unitName = "Eventop2_pu", type = PersistenceContextType.TRANSACTION)
    EntityManager em;

    @Override
    public void persist(Anuncio e) {
        try {
            em.persist(e);
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.PERSIST_ERROR);
        }
    }

    @Override
    public List<Anuncio> find() {
        List<Anuncio> lista = em.createNamedQuery("Anuncio.findAll", Anuncio.class).getResultList();
        if (lista == null) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return lista;
    }

    @Override
    public Anuncio findById(Integer id) {
        Anuncio anuncios = em.find(Anuncio.class, id);
        if (anuncios == null) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return anuncios;
    }

    @Override
    public void remove(Integer id) {
        try {
            em.remove(em.find(Anuncio.class, id));
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.REMOVE_ERROR);
        }
    }

    @Override
    public void update(Anuncio e) {
        try {
            em.merge(e);
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.REMOVE_ERROR);
        }
    }

}
