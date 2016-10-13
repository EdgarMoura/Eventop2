/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.command;

import com.br.promoter.exceptions.DBException;
import com.br.promoter.model.dao.InfoClienteDAO;
import com.br.promoter.model.entities.InfoCliente;
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
public class InfoClienteCommand implements Command {
    InfoClienteDAO infoClienteDAO = lookupInfoClienteDAOBean();
   
    private String returnPage = "WEB-INF/jsp/infocliente/visualizar.jsp";
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
      
        Integer idinfocliente;
        String nomecliente;
        String email;
        String telefone;
        String cpf;

        switch (action) {
            case "atualiza":

                request.getSession().setAttribute("infoClientes", infoClienteDAO.find());

                returnPage = "WEB-INF/jsp/infocliente/atualizar.jsp";
                break;
            case "atualiza.confirma":

                idinfocliente = Integer.parseInt(request.getParameter("infoClientes"));
                nomecliente = request.getParameter("nomecliente");
                email = request.getParameter("email");
                telefone = request.getParameter("telefone");
                cpf = request.getParameter("cpf");
               
                
                
                     InfoCliente infocliente;
                     infocliente = infoClienteDAO.findById(idinfocliente);
                     infocliente.setNomecliente(nomecliente);
                     infocliente.setEmail(email);
                     infocliente.setTelefone(telefone);
                     infocliente.setCpf(cpf);
                             
                   

                    try {
                        infoClienteDAO.update(infocliente);
                        request.getSession().setAttribute("infoClientes", infoClienteDAO.find());
                    } catch (DBException ex) {
                        request.getSession().setAttribute("errormsg", "<p class='msg'>Erro na conexão com o banco. Tente novamente!</p>");
                        returnPage = "WEB-INF/jsp/infocliente/atualizar.jsp";

                    }
                
                break;
            case "insere":

                returnPage = "WEB-INF/jsp/infocliente/inserir.jsp";
                break;
            case "insere.confirma":

                nomecliente = request.getParameter("nomecliente");
                email = request.getParameter("email");
                telefone = request.getParameter("telefone");
                cpf = request.getParameter("cpf");

                
                
                InfoCliente infoEmail = infoClienteDAO.findByEmail(email);
                InfoCliente infoCpf = infoClienteDAO.findByCpf(cpf);

                if (infoEmail != null) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Email já existente!</p>");
                    returnPage = "WEB-INF/jsp/infocliente/inserir.jsp";
                }else if(infoCpf != null){ 
                 request.getSession().setAttribute("errormsg", "<p class='msg'>CPF já existente!</p>");
                 returnPage = "WEB-INF/jsp/infocliente/inserir.jsp";
                }else if (nomecliente.isEmpty() && email.isEmpty() && telefone.isEmpty()) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Preencha o formulário!</p>");
                    returnPage = "WEB-INF/jsp/infocliente/inserir.jsp";
                } else {

                    infocliente = new InfoCliente();
                    infocliente.setNomecliente(nomecliente);
                    infocliente.setEmail(email);
                    infocliente.setTelefone(telefone);
                    infocliente.setCpf(cpf);
                    
                    
                   

                    try {
                        infoClienteDAO.persist(infocliente);
                        request.getSession().setAttribute("infoClientes", infoClienteDAO.find());

                    } catch (DBException ex) {
                        request.getSession().setAttribute("errormsg", "<p class='msg'>Erro na conexão com o banco. Tente novamente!</p>");
                        returnPage = "WEB-INF/jsp/infocliente/inserir.jsp";
                    }
                }
                break;
            case "deleta":

                request.getSession().setAttribute("infoClientes", infoClienteDAO.find());

                returnPage = "WEB-INF/jsp/infocliente/deletar.jsp";
                break;
            case "deleta.confirma":

                idinfocliente = Integer.parseInt(request.getParameter("infoClientes"));

                infoClienteDAO.remove(idinfocliente);

                request.getSession().setAttribute("infoClientes", infoClienteDAO.find());
                break;
            case "visualiza":

                request.getSession().setAttribute("infoClientes", infoClienteDAO.find());
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

    
    
}
