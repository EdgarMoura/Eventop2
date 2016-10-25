/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.command;

import com.br.promoter.exceptions.DBException;
import com.br.promoter.model.dao.AnuncioDAO;
import com.br.promoter.model.dao.InfoClienteDAO;
import com.br.promoter.model.dao.UsuarioClienteDAO;
import com.br.promoter.model.entities.Anuncio;
import com.br.promoter.model.entities.UsuarioCliente;
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
public class AnuncioCommand implements Command {
    InfoClienteDAO infoClienteDAO = lookupInfoClienteDAOBean();
    UsuarioClienteDAO usuarioClienteDAO = lookupUsuarioClienteDAOBean();
    AnuncioDAO anuncioDAO = lookupAnuncioDAOBean();
    
    
    private String returnPage = "WEB-INF/jsp/anuncio/visualizar.jsp";
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
      
        Integer idAnuncio;
        String tipoAnuncio;
        String descricao;
        Integer fk_usuario;
        

        switch (action) {
            case "atualiza":

                request.getSession().setAttribute("anuncios", anuncioDAO.find());
                request.getSession().setAttribute("fkuser", usuarioClienteDAO.find());
                returnPage = "WEB-INF/jsp/anuncio/atualizar.jsp";
                break;
            case "atualiza.confirma":

                idAnuncio = Integer.parseInt(request.getParameter("anuncios"));
                tipoAnuncio = request.getParameter("tpAnuncio");
                descricao = request.getParameter("descricao");
                fk_usuario = Integer.parseInt(request.getParameter("fkuser"));
                
                    UsuarioCliente uc = new UsuarioCliente();
                    uc.setIdusuariocliente(fk_usuario);
                
                     Anuncio anuncio;
                     anuncio = anuncioDAO.findById(idAnuncio);
                     anuncio.setTipoAnuncio(tipoAnuncio);
                     anuncio.setDescricao(descricao);
                     anuncio.setFkUsuario(uc);
                     
                             
                   

                    try {
                        anuncioDAO.update(anuncio);
                        request.getSession().setAttribute("anuncios", anuncioDAO.find());
                    } catch (DBException ex) {
                        request.getSession().setAttribute("errormsg", "<p class='msg'>Erro na conexão com o banco. Tente novamente!</p>");
                        returnPage = "WEB-INF/jsp/anuncio/atualizar.jsp";

                    }
                
                break;
            case "insere":

                returnPage = "WEB-INF/jsp/anuncio/inserir.jsp";
                break;
            case "insere.confirma":

                tipoAnuncio = request.getParameter("tpAnuncio");
                descricao = request.getParameter("descricao");
                fk_usuario = Integer.parseInt(request.getParameter("fkuser"));
                
                
                 
                UsuarioCliente uc1 = new UsuarioCliente();
                uc1.setIdusuariocliente(fk_usuario);
                    
                Anuncio anuncio1 = new Anuncio();
                anuncio1.setTipoAnuncio(tipoAnuncio);
                anuncio1.setDescricao(descricao);
                anuncio1.setFkUsuario(uc1);
                     

                    try {
                        anuncioDAO.persist(anuncio1);
                        request.setAttribute("anuncios", anuncioDAO.find());

                    } catch (DBException ex) {
                        request.getSession().setAttribute("errormsg", "<p class='msg'>Erro na conexão com o banco. Tente novamente!</p>");
                        returnPage = "WEB-INF/jsp/anuncio/inserir.jsp";
                    }
                
                break;
            case "deleta":

              
                request.getSession().setAttribute("anuncios", anuncioDAO.find());
                returnPage = "WEB-INF/jsp/anuncio/deletar.jsp";
                break;
            case "deleta.confirma":

                idAnuncio = Integer.parseInt(request.getParameter("anuncios"));

                anuncioDAO.remove(idAnuncio);

                request.getSession().setAttribute("anuncios", anuncioDAO.find());
                break;
            case "visualiza":
                
                request.getSession().setAttribute("anuncios", anuncioDAO.find());
                break;
                
            case "mostrar":
                
                request.getSession().setAttribute("infoClientes", infoClienteDAO.find());
                request.getSession().setAttribute("anuncios", anuncioDAO.find());
                returnPage = "anuncio.jsp";
                break;
            default:
                break;
        }
      
    }

    @Override
    public String getReturnPage() {
       return returnPage;  
    }

    private AnuncioDAO lookupAnuncioDAOBean() {
        try {
            Context c = new InitialContext();
            return (AnuncioDAO) c.lookup("java:global/Eventop2/Eventop2-ejb/AnuncioDAO!com.br.promoter.model.dao.AnuncioDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private UsuarioClienteDAO lookupUsuarioClienteDAOBean() {
        try {
            Context c = new InitialContext();
            return (UsuarioClienteDAO) c.lookup("java:global/Eventop2/Eventop2-ejb/UsuarioClienteDAO!com.br.promoter.model.dao.UsuarioClienteDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private InfoClienteDAO lookupInfoClienteDAOBean() {
        try {
            Context c = new InitialContext();
            return (InfoClienteDAO) c.lookup("java:global/Eventop2/Eventop2-ejb/InfoClienteDAO!com.br.promoter.model.dao.InfoClienteDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
