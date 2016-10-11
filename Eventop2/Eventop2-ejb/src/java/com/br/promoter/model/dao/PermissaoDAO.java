/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.model.dao;

import com.br.promoter.exceptions.DBException;
import com.br.promoter.exceptions.DBExceptionEnum;
import com.br.promoter.model.entities.Permissao;
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
public class PermissaoDAO implements GenericDAO<Permissao> {

    @PersistenceContext(unitName="Eventop2_pu", type=PersistenceContextType.TRANSACTION)
    EntityManager em;
    
    @Override
    public void persist(Permissao e) {
     try{
         em.persist(e);
     }catch(Exception ex){
        throw new DBException(DBExceptionEnum.PERSIST_ERROR); 
     }
    }

    @Override
    public List<Permissao> find() {
    List<Permissao> lista = em.createNamedQuery("Permissao.findAll", Permissao.class).getResultList();
    if(lista == null){
        throw new DBException(DBExceptionEnum.FIND_ERROR);
    }
    return lista;
    }

    @Override
    public Permissao findById(Integer id) {
     Permissao permissao = em.find(Permissao.class, id);
    if(permissao==null){
        throw new DBException(DBExceptionEnum.FIND_ERROR);
    }
    return permissao;
    
    }

    @Override
    public void remove(Integer id) {
     try{
         em.remove(em.find(Permissao.class, id));
     }catch(Exception ex){
         throw new DBException(DBExceptionEnum.REMOVE_ERROR);
     }
    }

    @Override
    public void update(Permissao e) {
      try{
          em.merge(e);
      }catch(Exception ex){
          throw new DBException(DBExceptionEnum.UPDATE_ERROR);
      }
    }

   
}
