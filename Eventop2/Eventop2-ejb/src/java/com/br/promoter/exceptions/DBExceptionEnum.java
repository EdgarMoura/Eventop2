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
public enum DBExceptionEnum {

    PERSIST_ERROR {
        @Override
        public String toString() {
            return "Erro na inserção dos dados!";
        }
    },
    UPDATE_ERROR {
        @Override
        public String toString() {
            return "Erro na atualização dos dados!";
        }
    },
    REMOVE_ERROR {
        @Override
        public String toString() {
            return "Erro na remoção dos dados!";
        }
    },
    FIND_ERROR {
        @Override
        public String toString() {
            return "Erro na leitura dos dados!";
        }
    }

}
