/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.command;

import com.br.promoter.model.dao.EnderecoDAO;
import com.br.promoter.model.dao.InfoClienteDAO;
import com.br.promoter.model.dao.OrcamentoDAO;
import com.br.promoter.model.dao.ProdutoDAO;
import com.br.promoter.model.dao.SolicitacaoDAO;
import com.br.promoter.model.dao.UsuarioClienteDAO;
import com.br.promoter.model.entities.Orcamento;
import com.br.promoter.model.entities.Solicitacao;
import com.br.promoter.model.entities.UsuarioCliente;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class SolicitacaoCommand implements Command {
    InfoClienteDAO infoClienteDAO = lookupInfoClienteDAOBean();
    ProdutoDAO produtoDAO = lookupProdutoDAOBean();
    UsuarioClienteDAO usuarioClienteDAO = lookupUsuarioClienteDAOBean();
    SolicitacaoDAO solicitacaoDAO = lookupSolicitacaoDAOBean();
    EnderecoDAO enderecoDAO = lookupEnderecoDAOBean();
    OrcamentoDAO orcamentoDAO = lookupOrcamentoDAOBean();
    
    
    
    
    Solicitacao solicitacao;
    UsuarioCliente usuarioCliente;
    Orcamento orcamento;
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
        
        switch (action) {
            case "proposta":
               request.getSession().setAttribute("orcamento", orcamentoDAO.find());
               request.getSession().setAttribute("produto", produtoDAO.find());
               request.getSession().setAttribute("infocliente", infoClienteDAO.find());
               request.getSession().setAttribute("enderecos", enderecoDAO.find());
               returnPage = "proposta.jsp";
                
                break;
            case "solicitacao":
                String nome = request.getParameter("nome");
                String email = request.getParameter("email");
                String telefone = request.getParameter("telefone");
                String tema = request.getParameter("tema");
                String qtdPart = request.getParameter("participantes");
                Date data = new Date(System.currentTimeMillis());
                SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
                formatarDate.format(data);
                Date data1 = new Date();
                SimpleDateFormat formatador1 = new SimpleDateFormat(request.getParameter("data"));
                formatador1.format(data1);
                String periodo = request.getParameter("periodo");
                String descricao = request.getParameter("descricao");
                Integer idUsuario = Integer.parseInt(request.getParameter("idAfiliado"));
                System.out.println("Teste participantes " + qtdPart);
                
                solicitacao = new Solicitacao();
                solicitacao.setNome(nome);
                solicitacao.setEmail(email);
                solicitacao.setTema(tema);
                solicitacao.setQtdPessoas(Integer.parseInt(qtdPart));
                solicitacao.setPeriodo(periodo);
                solicitacao.setSolicitadoEm(data);
                solicitacao.setDataEvento(data1);
                solicitacao.setDescricao(descricao);
                solicitacao.setFkUsuarioCliente(usuarioClienteDAO.findById(idUsuario));
                
                solicitacaoDAO.persist(solicitacao);
                returnPage = "home.jsp";
                
                break;
            
        }
    }

    @Override
    public String getReturnPage() {
      return returnPage;
    
    }

    private OrcamentoDAO lookupOrcamentoDAOBean() {
        try {
            Context c = new InitialContext();
            return (OrcamentoDAO) c.lookup("java:global/Eventop2/Eventop2-ejb/OrcamentoDAO!com.br.promoter.model.dao.OrcamentoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private EnderecoDAO lookupEnderecoDAOBean() {
        try {
            Context c = new InitialContext();
            return (EnderecoDAO) c.lookup("java:global/Eventop2/Eventop2-ejb/EnderecoDAO!com.br.promoter.model.dao.EnderecoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private SolicitacaoDAO lookupSolicitacaoDAOBean() {
        try {
            Context c = new InitialContext();
            return (SolicitacaoDAO) c.lookup("java:global/Eventop2/Eventop2-ejb/SolicitacaoDAO!com.br.promoter.model.dao.SolicitacaoDAO");
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

    private ProdutoDAO lookupProdutoDAOBean() {
        try {
            Context c = new InitialContext();
            return (ProdutoDAO) c.lookup("java:global/Eventop2/Eventop2-ejb/ProdutoDAO!com.br.promoter.model.dao.ProdutoDAO");
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
