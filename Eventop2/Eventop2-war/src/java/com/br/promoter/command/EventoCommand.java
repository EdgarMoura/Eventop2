/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.command;

import com.br.promoter.model.dao.CaracteristicaDAO;
import com.br.promoter.model.dao.EventoDAO;
import com.br.promoter.model.dao.UsuarioClienteDAO;
import com.br.promoter.model.entities.Caracteristica;
import com.br.promoter.model.entities.Evento;
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
 * @author everton
 */
public class EventoCommand implements Command {
    UsuarioClienteDAO usuarioClienteDAO = lookupUsuarioClienteDAOBean();
    CaracteristicaDAO caracteristicaDAO = lookupCaracteristicaDAOBean();
    EventoDAO eventoDAO = lookupEventoDAOBean();
    
    private String returnPage = "index.jsp";
    private HttpServletRequest request;
    private HttpServletResponse response;

    UsuarioCliente uc;
    Evento evento;
    Caracteristica carct;

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        String action = request.getParameter("action");
        switch (action) {
            
            case "orcamento":
                returnPage = "WEB-INF/jsp/orcamento/orcamento.jsp";
                break;
            case "soliOrcamento":
                Date data = new Date(System.currentTimeMillis());
                SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
                formatarDate.format(data);
                Date data1 = new Date();
                SimpleDateFormat formatador1 = new SimpleDateFormat(request.getParameter("data"));
                formatador1.format(data1);
                
                Integer qtd_participantes = Integer.parseInt(request.getParameter("participantes"));
                String periodo = request.getParameter("periodo");
                String tema = request.getParameter("tema");
                String nome = request.getParameter("nome");
                String email = request.getParameter("email");
                String descricao = request.getParameter("descricao");
                Integer idAfiliado = Integer.parseInt(request.getParameter("idAfiliado"));
                
                carct = new Caracteristica();
                carct.setSolicitadoEm(data);
                carct.setDataEvento(data1);
                carct.setQtdPessoas(qtd_participantes);
                carct.setEmail(email);
                carct.setNome(nome);
                carct.setDescricao(descricao);
                carct.setTema(tema);
                carct.setPeriodo(periodo);
                
                
                
                
                caracteristicaDAO.persist(carct);
                uc = new UsuarioCliente();
                uc = usuarioClienteDAO.findById(idAfiliado);
                
                
                evento = new Evento();
                evento.setStatus("Esperando analise");
                evento.setFkCaract(caracteristicaDAO.findById(carct.getIdCaract()));
                evento.setFkUsuarioevento(uc);
                
                
                eventoDAO.persist(evento);
                break;

        }
    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }

    private EventoDAO lookupEventoDAOBean() {
        try {
            Context c = new InitialContext();
            return (EventoDAO) c.lookup("java:global/Eventop2/Eventop2-ejb/EventoDAO!com.br.promoter.model.dao.EventoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private CaracteristicaDAO lookupCaracteristicaDAOBean() {
        try {
            Context c = new InitialContext();
            return (CaracteristicaDAO) c.lookup("java:global/Eventop2/Eventop2-ejb/CaracteristicaDAO!com.br.promoter.model.dao.CaracteristicaDAO");
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
