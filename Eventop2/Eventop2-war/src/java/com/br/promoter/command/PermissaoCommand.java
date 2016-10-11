/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.command;

import com.br.promoter.model.dao.PermissaoDAO;
import com.br.promoter.model.entities.Permissao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author moura
 */
public class PermissaoCommand implements Command{
    PermissaoDAO permissaoDAO = lookupPermissaoDAOBean();
   
    private String returnPage = "WEB-INF/jsp/permissao/visualizar.jsp";
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    
    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
       this.request = request;
       this.response = response;
    }

    @Override
    public void execute() {
      String action = request.getParameter("action");
      Long idpermissao;
      String titlo;
       
      
        switch(action){
            case "atualiza":
            
                request.getSession().setAttribute("permissoes", permissaoDAO.find());
                
                returnPage = "WEB-INF/jsp/permissao/atualizar.jsp";
                break;
            case "atualiza.confirma":

                idpermissao = Long.parseLong(request.getParameter("permissoes"));
                titlo = request.getParameter("titlo");
                
                
                Permissao permissao;
                permissao = permissaoDAO.findById(idpermissao);
                permissao.setTitlo(titlo);
                permissaoDAO.update(permissao);
     
                request.getSession().setAttribute("permissoes", permissaoDAO.find());
                break;
            case "insere":
               
                returnPage = "WEB-INF/jsp/permissao/inserir.jsp";
                break;
            case "insere.confirma":

                titlo = request.getParameter("titlo");
                
                permissao = new Permissao();
                permissao.setTitlo(titlo);
                permissaoDAO.persist(permissao);
                
                
                request.getSession().setAttribute("permissoes", permissaoDAO.find());
                break;
            case "deleta":
               
                request.getSession().setAttribute("permissoes", permissaoDAO.find());
                
                returnPage = "WEB-INF/jsp/permissao/deletar.jsp";
                break;
            case "deleta.confirma":
                idpermissao = Long.parseLong(request.getParameter("permissoes"));
                
                permissaoDAO.remove(idpermissao);
                 
                request.getSession().setAttribute("permissoes", permissaoDAO.find());
                break;
            case "visualiza":
             
                request.getSession().setAttribute("permissoes", permissaoDAO.find());
                break;
            default:
                break;
        }
    
    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }

    private PermissaoDAO lookupPermissaoDAOBean() {
        try {
            Context c = new InitialContext();
            return (PermissaoDAO) c.lookup("java:global/Eventop2/Eventop2-ejb/PermissaoDAO!com.br.promoter.model.dao.PermissaoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

   
    
}
