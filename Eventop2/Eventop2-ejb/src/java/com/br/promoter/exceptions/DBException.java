/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.exceptions;

/**
 *
 * @author 1147510
 */
public class DBException extends RuntimeException {
   
    public DBException(DBExceptionEnum msg){
        super(msg.toString());
    }
}
