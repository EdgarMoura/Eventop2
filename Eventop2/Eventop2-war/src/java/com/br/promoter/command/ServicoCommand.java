/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.command;

import com.br.promoter.exceptions.DBException;
import com.br.promoter.model.dao.InfoClienteDAO;
import com.br.promoter.model.dao.ServicoDAO;
import com.br.promoter.model.dao.UsuarioClienteDAO;
import com.br.promoter.model.entities.Servico;
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
public class ServicoCommand  implements Command{
    InfoClienteDAO infoClienteDAO = lookupInfoClienteDAOBean();
    UsuarioClienteDAO usuarioClienteDAO = lookupUsuarioClienteDAOBean();
    ServicoDAO servicoDAO = lookupServicoDAOBean();

    private String returnPage = "WEB-INF/jsp/servico/visualizar.jsp";
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
      
        Integer idServico;
        String tipoServico;
        String descricao;
        Integer fk_usuarioFornecedor;
        

        switch (action) {
            case "atualiza":

                request.getSession().setAttribute("servicos", servicoDAO.find());
                request.getSession().setAttribute("fkuser", usuarioClienteDAO.find());
                returnPage = "WEB-INF/jsp/servico/atualizar.jsp";
                break;
            case "atualiza.confirma":

                idServico = Integer.parseInt(request.getParameter("servicos"));
                tipoServico = request.getParameter("tpServico");
                descricao = request.getParameter("descricao");
                fk_usuarioFornecedor = Integer.parseInt(request.getParameter("fkuser"));
                
                    UsuarioCliente uc = new UsuarioCliente();
                    uc.setIdusuariocliente(fk_usuarioFornecedor);
                
                     Servico servico;
                     servico = servicoDAO.findById(idServico);
                     servico.setTipoServico(tipoServico);
                     servico.setDescricao(descricao);
                     servico.setFkUsuarioFornecedor(uc);
                     
                             
                   

                    try {
                        servicoDAO.update(servico);
                        request.getSession().setAttribute("servicos", servicoDAO.find());
                    } catch (DBException ex) {
                        request.getSession().setAttribute("errormsg", "<p class='msg'>Erro na conexão com o banco. Tente novamente!</p>");
                        returnPage = "WEB-INF/jsp/servico/atualizar.jsp";

                    }
                
                break;
            case "insere":

                returnPage = "WEB-INF/jsp/servico/inserir.jsp";
                break;
            case "insere.confirma":

                tipoServico = request.getParameter("tpServico");
                descricao = request.getParameter("descricao");
                fk_usuarioFornecedor = Integer.parseInt(request.getParameter("fkuser"));
                
                
                 
                UsuarioCliente uc1 = new UsuarioCliente();
                uc1.setIdusuariocliente(fk_usuarioFornecedor);
                    
                Servico servico1 = new Servico();
                servico1.setTipoServico(tipoServico);
                servico1.setDescricao(descricao);
                servico1.setFkUsuarioFornecedor(uc1);
                     

                    try {
                        servicoDAO.persist(servico1);
                        request.setAttribute("servicos", servicoDAO.find());

                    } catch (DBException ex) {
                        request.getSession().setAttribute("errormsg", "<p class='msg'>Erro na conexão com o banco. Tente novamente!</p>");
                        returnPage = "WEB-INF/jsp/servico/inserir.jsp";
                    }
                
                break;
            case "deleta":

              
                request.getSession().setAttribute("servicos", servicoDAO.find());
                returnPage = "WEB-INF/jsp/servico/deletar.jsp";
                break;
            case "deleta.confirma":

                idServico = Integer.parseInt(request.getParameter("servicos"));

                servicoDAO.remove(idServico);

                request.getSession().setAttribute("servicos", servicoDAO.find());
                break;
            case "visualiza":
                
                request.getSession().setAttribute("servicos", servicoDAO.find());
                break;
                
            case "mostrar":
                
                request.getSession().setAttribute("infoClientes", infoClienteDAO.find());
                request.getSession().setAttribute("servicos", servicoDAO.find());
                returnPage = "servico.jsp";
                break;
            default:
                break;
        }
      
    }

    @Override
    public String getReturnPage() {
       return returnPage;  
    }

    private ServicoDAO lookupServicoDAOBean() {
        try {
            Context c = new InitialContext();
            return (ServicoDAO) c.lookup("java:global/Eventop2/Eventop2-ejb/ServicoDAO!com.br.promoter.model.dao.ServicoDAO");
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
