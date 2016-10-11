/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.model.dao;

import com.br.promoter.exceptions.DBException;
import com.br.promoter.exceptions.DBExceptionEnum;
import com.br.promoter.model.entities.InfoCliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author 1147510
 */
@Stateless
@LocalBean
public class InfoClienteDAO implements GenericDAO<InfoCliente> {

    @PersistenceContext(unitName = "Eventop2_pu", type = PersistenceContextType.TRANSACTION)
    EntityManager em;

    @Override
    public void persist(InfoCliente e) {
        try {
            em.persist(e);
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.PERSIST_ERROR);
        }
    }

    @Override
    public List<InfoCliente> find() {
        List<InfoCliente> lista = em.createNamedQuery("InfoCliente.findAll", InfoCliente.class).getResultList();
        if (lista == null) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return lista;
    }

    @Override
    public InfoCliente findById(Integer id) {
        InfoCliente infocliente = em.find(InfoCliente.class, id);
        if (infocliente == null) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return infocliente;
    }

    public InfoCliente findByEmail(String email){
      InfoCliente infoemail = null;
        List<InfoCliente> lista = em.createNamedQuery("InfoCliente.findByEmail", InfoCliente.class).setParameter("email", email).getResultList();
        if(lista!=null && !lista.isEmpty()) 
           infoemail = lista.get(0);
        
        return infoemail;   
   }
    
    public InfoCliente findByCpf(String cpf){
      InfoCliente infocpf = null;
        List<InfoCliente> lista = em.createNamedQuery("InfoCliente.findByCpf", InfoCliente.class).setParameter("cpf", cpf).getResultList();
        if(lista!=null && !lista.isEmpty()) 
           infocpf  = lista.get(0);
        
        return infocpf ;   
   }
    
      public InfoCliente findByName(String nomeCliente){
      InfoCliente user = null;
        List<InfoCliente> lista = em.createNamedQuery("InfoCliente.findByNomecliente", InfoCliente.class).setParameter("nomecliente",nomeCliente).getResultList();
        if(lista!=null && !lista.isEmpty()) 
            user = lista.get(0);
        
        return user;   
   }
    
    
    @Override
    public void remove(Integer id) {
        try {
            em.remove(em.find(InfoCliente.class, id));
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.REMOVE_ERROR);
        }
    }

    @Override
    public void update(InfoCliente e) {
        try {
            em.merge(e);
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.REMOVE_ERROR);
        }

    }

}
