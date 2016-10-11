/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.model.dao;

import java.util.List;

/**
 *
 * @author 1147510
 * @param <E>
 */
public interface GenericDAO<E> {
    public void persist (E e);
    public List<E> find();
    public E findById(long id);
    public void remove(long id);
    public void update(E e);
    
}
