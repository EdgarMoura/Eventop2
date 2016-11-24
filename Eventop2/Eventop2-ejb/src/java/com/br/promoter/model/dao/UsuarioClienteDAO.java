/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.model.dao;

import com.br.promoter.exceptions.DBException;
import com.br.promoter.exceptions.DBExceptionEnum;
import com.br.promoter.model.entities.UsuarioCliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author 1147510
 */
@Stateless
@LocalBean
public class UsuarioClienteDAO implements GenericDAO<UsuarioCliente> {

    @PersistenceContext(unitName = "Eventop2_pu", type = PersistenceContextType.TRANSACTION)
    EntityManager em;

    @Override
    public void persist(UsuarioCliente e) {
        try {
            em.persist(e);
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.PERSIST_ERROR);
        }
    }

    @Override
    public List<UsuarioCliente> find() {
        List<UsuarioCliente> lista = em.createNamedQuery("UsuarioCliente.findAll", UsuarioCliente.class).getResultList();
        if (lista == null) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return lista;
    }
    
      
    
    

    @Override
    public UsuarioCliente findById(Integer id) {
        UsuarioCliente usuarioCliente = em.find(UsuarioCliente.class, id);
        if (usuarioCliente == null) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return usuarioCliente;
    }

    public UsuarioCliente findByName(String username) {
        UsuarioCliente user = null;
        List<UsuarioCliente> lista = em.createNamedQuery("UsuarioCliente.findByUsername", UsuarioCliente.class).setParameter("username", username).getResultList();
        if (lista != null && !lista.isEmpty()) {
            user = lista.get(0);
        }

        return user;
    }
    
    public UsuarioCliente findByPassword(String password) {
        UsuarioCliente user = null;
        List<UsuarioCliente> lista = em.createNamedQuery("UsuarioCliente.findBySenha", UsuarioCliente.class).setParameter("password", password).getResultList();
        if (lista != null && !lista.isEmpty()) {
            user = lista.get(0);
        }

        return user;
    }

    @Override
    public void remove(Integer id) {
        try {
            em.remove(em.find(UsuarioCliente.class, id));
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.REMOVE_ERROR);
        }
    }

    public void removeByName(UsuarioCliente e) {
        try {
            em.remove(em.merge(e));
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.REMOVE_ERROR);
        }
    }

    @Override
    public void update(UsuarioCliente e) {
        try {
            em.merge(e);
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.UPDATE_ERROR);
        }

    }

}
