/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.command;

import com.br.promoter.exceptions.DBException;
import com.br.promoter.model.dao.InfoClienteDAO;
import com.br.promoter.model.dao.PermissaoDAO;
import com.br.promoter.model.dao.UsuarioClienteDAO;
import com.br.promoter.model.entities.Permissao;
import com.br.promoter.model.entities.UsuarioCliente;
import com.br.promoter.util.CriptografiaMd5;
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
public class UsuarioClienteCommand implements Command {
    UsuarioClienteDAO usuarioClienteDAO = lookupUsuarioClienteDAOBean();
    PermissaoDAO permissaoDAO = lookupPermissaoDAOBean();
    InfoClienteDAO infoClienteDAO = lookupInfoClienteDAOBean();
    
    
    private String returnPage = "WEB-INF/jsp/usuariocliente/visualizar.jsp";
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

        Integer idusuariocliente;
        String username;
        String senha;
        Integer fkPermissao;
        Permissao permissao;
        
        CriptografiaMd5 criptMd5 = new CriptografiaMd5();

        switch (action) {
            case "atualiza":

                request.getSession().setAttribute("usuarioClientes", usuarioClienteDAO.find());
                request.getSession().setAttribute("permissoes", permissaoDAO.find());

                returnPage = "WEB-INF/jsp/usuariocliente/atualizar.jsp";
                break;
            case "atualiza.confirma":

                idusuariocliente = Integer.parseInt(request.getParameter("usuarioClientes"));
                username = request.getParameter("username");
                senha = request.getParameter("senha");
                fkPermissao = Integer.parseInt(request.getParameter("permissoes"));

                UsuarioCliente usuariocliente;
                 usuariocliente = usuarioClienteDAO.findByName(username);

                if (usuariocliente != null) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Usuário já existente!</p>");
                    returnPage = "WEB-INF/jsp/usuariocliente/atualizar.jsp";

                } else {
                    permissao = new Permissao(); 
                    permissao.setIdpermissao(fkPermissao);
                    
                    usuariocliente = usuarioClienteDAO.findById(idusuariocliente);
                    usuariocliente.setUsername(username);
                    usuariocliente.setSenha(criptMd5.md5(senha));
                    usuariocliente.setFkPermissao(permissao);
                    
                   

                    try {
                        usuarioClienteDAO.update(usuariocliente);
                        request.getSession().setAttribute("usuarioClientes", usuarioClienteDAO.find());
                    } catch (DBException ex) {
                        request.getSession().setAttribute("errormsg", "<p class='msg'>Erro na conexão com o banco. Tente novamente!</p>");
                        returnPage = "WEB-INF/jsp/usuariocliente/atualizar.jsp";
                    }

                }
                break;
            case "insere":
                request.getSession().setAttribute("permissoes", permissaoDAO.find());

                returnPage = "WEB-INF/jsp/usuariocliente/inserir.jsp";
                break;
            case "insere.confirma":

                username = request.getParameter("username");
                senha = request.getParameter("senha");
                fkPermissao = Integer.parseInt(request.getParameter("permissoes"));
                
                
                UsuarioCliente usuarioCliente = usuarioClienteDAO.findByName(username);

                if (usuarioCliente != null) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Usuário já existente!</p>");
                    returnPage = "WEB-INF/jsp/usuariocliente/inserir.jsp";
                } else {
                    
                    permissao = new Permissao(); 
                    permissao.setIdpermissao(fkPermissao);
                    
                    
                    usuariocliente = new UsuarioCliente();
                    usuariocliente.setUsername(username);
                    usuariocliente.setSenha(criptMd5.md5(senha));
                    usuariocliente.setFkPermissao(permissao);

                    try {
                       usuarioClienteDAO.persist(usuariocliente);
                       request.getSession().setAttribute("usuarioClientes", usuarioClienteDAO.find());

                    } catch (DBException ex) {
                        request.getSession().setAttribute("errormsg", "<p class='msg'>Erro na conexão com o banco. Tente novamente!</p>");
                        returnPage = "WEB-INF/jsp/usuariocliente/inserir.jsp";
                    }

                }
                break;
            case "deleta":

                request.getSession().setAttribute("usuarioClientes", usuarioClienteDAO.find());

                returnPage = "WEB-INF/jsp/usuariocliente/deletar.jsp";
                break;
            case "deleta.confirma":

                 idusuariocliente = Integer.parseInt(request.getParameter("usuarioClientes"));

                usuarioClienteDAO.remove(idusuariocliente);

                request.getSession().setAttribute("usuarioClientes", usuarioClienteDAO.find());
                break;
            case "visualiza":

                request.getSession().setAttribute("usuarioClientes", usuarioClienteDAO.find());
                break;
            case "visualizaTudo":
                request.getSession().setAttribute("usuarioClientes", usuarioClienteDAO.find());
                request.getSession().setAttribute("infoClientes", infoClienteDAO.find());
                returnPage = "WEB-INF/jsp/usuariocliente/todasInformacoes.jsp";
                break;
            default:
                break;
        }
    
    }

    @Override
    public String getReturnPage() {
      return returnPage;
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

    private PermissaoDAO lookupPermissaoDAOBean() {
        try {
            Context c = new InitialContext();
            return (PermissaoDAO) c.lookup("java:global/Eventop2/Eventop2-ejb/PermissaoDAO!com.br.promoter.model.dao.PermissaoDAO");
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

    
    
    
}
