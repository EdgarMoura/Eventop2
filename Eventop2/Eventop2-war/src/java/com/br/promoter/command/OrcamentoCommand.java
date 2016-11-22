package com.br.promoter.command;

import com.br.promoter.model.dao.ComidaDAO;
import com.br.promoter.model.dao.EnderecoDAO;
import com.br.promoter.model.dao.OrcamentoDAO;
import com.br.promoter.model.dao.ProdutoDAO;
import com.br.promoter.model.dao.SolicitacaoDAO;
import com.br.promoter.model.dao.UsuarioClienteDAO;
import com.br.promoter.model.entities.Comida;
import com.br.promoter.model.entities.Endereco;
import com.br.promoter.model.entities.Orcamento;
import com.br.promoter.model.entities.Produto;
import com.br.promoter.model.entities.Solicitacao;
import com.br.promoter.model.entities.UsuarioCliente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author moura
 */
public class OrcamentoCommand implements Command {
    SolicitacaoDAO solicitacaoDAO = lookupSolicitacaoDAOBean();
    UsuarioClienteDAO usuarioClienteDAO = lookupUsuarioClienteDAOBean();
    ProdutoDAO produtoDAO = lookupProdutoDAOBean();
    OrcamentoDAO orcamentoDAO1 = lookupOrcamentoDAOBean1();
    EnderecoDAO enderecoDAO = lookupEnderecoDAOBean();
    ComidaDAO comidaDAO = lookupComidaDAOBean();
    OrcamentoDAO orcamentoDAO = lookupOrcamentoDAOBean();

    Solicitacao solicitacao;
    Endereco endereco;
    Comida comida;
    Produto produto;
    Orcamento orcamento;
    UsuarioCliente usuario;
    
    private String returnPage = "orcamento.jsp";
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
      
     switch (action){
         case "orcamento":
               returnPage = "orcamento.jsp";
                
                break;
          case "orcamentoPromoter":
              Integer idSolicitacao = Integer.parseInt(request.getParameter("atender"));
              request.getSession().setAttribute("solicitacao", solicitacaoDAO.findById(idSolicitacao));
              returnPage = "WEB-INF/jsp/orcamento/orcamentoPromoter.jsp";
              
          break;
          case "solicitacoes":
              request.getSession().setAttribute("solicitacoes", solicitacaoDAO.find());
              returnPage = "WEB-INF/jsp/orcamento/solicitacaoCliente.jsp";
          break;
            case "enviarOrcamento":
              orcamento = new Orcamento();
              endereco = new Endereco();
              //==================  SALVAR TODOS OS DADOS ====================
                Integer idSolicitacaoCl = Integer.parseInt(request.getParameter("idSolicitacao"));
                solicitacao = solicitacaoDAO.findById(idSolicitacaoCl);
                System.out.println("Id solicitacao " + request.getParameter("idUsuarioCliente"));
                Integer idUsuarioCliente = Integer.parseInt(request.getParameter("idUsuarioCliente"));
                usuario = usuarioClienteDAO.findById(idUsuarioCliente);
                
               // orcamento.s(endereco.getIdEndereco());
                
                orcamento.setFkSolicitacao(solicitacao);
                orcamento.setFkUsuariopromoter(usuario);
                
                 //==================  DADOS ENDERECO E LOCAL ====================
               String logradouro = request.getParameter("logradouro");
                Integer numero = Integer.parseInt(request.getParameter("numero"));
                String bairro = request.getParameter("bairro");
                String cep    = request.getParameter("cep");
                String cidade    = request.getParameter("cidade");
                String estado    = request.getParameter("estado");
                Integer capacidade = Integer.parseInt(request.getParameter("capacidade"));
                Integer valor    = Integer.parseInt(request.getParameter("valor"));
                String ambiente  = request.getParameter("ambiente");
                
                endereco.setLogradouro(logradouro);
                endereco.setNumero(numero);
                endereco.setBairro(bairro);
                endereco.setCep(cep);
                endereco.setCidade(cidade);
                endereco.setEstado(estado);
                endereco.setCapacidade(capacidade);
                endereco.setValor(valor);
                endereco.setDescricao(ambiente);
                orcamento.setEndereco(endereco);
                endereco.setOrcamento(orcamento);
                
                orcamentoDAO.persist(orcamento);
                
                //==================  DADOS SERVIÇOS  ====================
                String nomeBr    = request.getParameter("pulapula");
                String nomeCa    = request.getParameter("camaelastica");
                String nomePs    = request.getParameter("pisciniabol");
                produto = new Produto();
                  if("on".equals(nomeBr)){
                    //Cria o PulaPula
                    produto.setNome("Pula Pula");
                    Integer vlPula = Integer.parseInt(request.getParameter("vlPula"));
                    produto.setValor(vlPula);
                    produto.setFkOrcamento(orcamento);
                    produtoDAO.persist(produto);
                }
                if("on".equals(nomeCa)){
                    //Cria o Cama
                    produto.setNome("Cama Elastica");
                    Integer vlCama = Integer.parseInt(request.getParameter("vlCama"));
                    produto.setValor(vlCama);
                    produto.setFkOrcamento(orcamento);
                    produtoDAO.persist(produto);
                }
                if("on".equals(nomePs)){
                    //Cria o Piscina
                    produto.setNome("Piscina de Bolinha");
                    Integer vlPisc = Integer.parseInt(request.getParameter("vlpisc"));
                    produto.setValor(vlPisc);
                    produto.setFkOrcamento(orcamento);
                    produtoDAO.persist(produto);
                }
              
             
                
                  //==================  DADOS CARDAPIO  ====================              
                String cardapio = request.getParameter("cardapio");
                System.out.println("Comida porra " + cardapio);
                comida = new Comida();
                comida.setOrcamento(orcamento);
                orcamento.setComida(comida);
                comida.setDecricaoComida(cardapio);
                
                comidaDAO.persist(comida);
                
                
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

    private ComidaDAO lookupComidaDAOBean() {
        try {
            Context c = new InitialContext();
            return (ComidaDAO) c.lookup("java:global/Eventop2/Eventop2-ejb/ComidaDAO!com.br.promoter.model.dao.ComidaDAO");
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

    private OrcamentoDAO lookupOrcamentoDAOBean1() {
        try {
            Context c = new InitialContext();
            return (OrcamentoDAO) c.lookup("java:global/Eventop2/Eventop2-ejb/OrcamentoDAO!com.br.promoter.model.dao.OrcamentoDAO");
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

    private UsuarioClienteDAO lookupUsuarioClienteDAOBean() {
        try {
            Context c = new InitialContext();
            return (UsuarioClienteDAO) c.lookup("java:global/Eventop2/Eventop2-ejb/UsuarioClienteDAO!com.br.promoter.model.dao.UsuarioClienteDAO");
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

}
