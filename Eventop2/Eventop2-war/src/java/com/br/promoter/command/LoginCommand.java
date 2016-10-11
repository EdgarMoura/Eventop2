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
import com.br.promoter.model.entities.InfoCliente;
import com.br.promoter.model.entities.Permissao;
import com.br.promoter.model.entities.UsuarioCliente;
import com.br.promoter.util.DateUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author moura
 */
public class LoginCommand implements Command {

    UsuarioClienteDAO usuarioClienteDAO = lookupUsuarioClienteDAOBean();
    PermissaoDAO permissaoDAO = lookupPermissaoDAOBean();
    InfoClienteDAO infoClienteDAO = lookupInfoClienteDAOBean();

    private String returnPage = "index.jsp";
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
        UsuarioCliente users;
        switch (action) {
            case "registrar":
                String nomeCliente = request.getParameter("nomecliente");
                String username = request.getParameter("username");
                String senha1 = request.getParameter("senha1");
                String senha2 = request.getParameter("senha2");
                String dtAniversario = request.getParameter("aniversario");
                String email = request.getParameter("email");
                String cpf = request.getParameter("cpf");
                Integer idpermissao = 2;

                UsuarioCliente user = usuarioClienteDAO.findByName(username);
                InfoCliente infoemail = infoClienteDAO.findByEmail(email);
                InfoCliente infocpf = infoClienteDAO.findByCpf(cpf);

                if (user != null) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Usuário já existente!</p>");
                    returnPage = "index.jsp";

                } else if (infoemail != null) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Email já cadastrado!</p>");

                } else if (infocpf != null) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>CPF já existente!</p>");

                } else if (senha1.equals(senha2)) {

                    Permissao permissao = new Permissao();
                    permissao.setIdpermissao(idpermissao);

                    InfoCliente infocliente = new InfoCliente();
                    infocliente.setNomecliente(nomeCliente);
                    infocliente.setEmail(email);
                    infocliente.setDtaniversario(DateUtil.string2dateOnly(dtAniversario));
                    infocliente.setCpf(cpf);

                    UsuarioCliente uc = new UsuarioCliente();
                    uc.setUsername(username);
                    uc.setSenha(senha1);
                    uc.setIdpermissao(permissao);

                    uc.setInfoCliente(infocliente);
                    infocliente.setUsuarioCliente(uc);

                    try {

                        usuarioClienteDAO.persist(uc);

                        request.getSession().setAttribute("sucessmsg", "<p class='msgsuccess'>Usuário cadastrado com sucesso! Faça o seu login!</p>");
                    } catch (DBException ex) {
                        request.getSession().setAttribute("errormsg", "<p class='msg'>Erro na conexão com o banco. Tente novamente!</p>");
                        returnPage = "index.jsp";
                    }
                } else {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Senhas não conferem!</p>");
                    returnPage = "index.jsp";
                }

                break;
            case "login":
                String username2 = request.getParameter("username");
                String senha = request.getParameter("senha");

                UsuarioCliente user2;

                try {
                    user2 = usuarioClienteDAO.findByName(username2);

                    if (user2.getUsername().equals(username2) && user2.getSenha().equals(senha)) {

                        String check = request.getParameter("lembrar");
                        if ("on".equals(check)) {
                            Cookie cookie = new Cookie("username", username2);
                            cookie.setMaxAge(60 * 60 * 24);
                            response.addCookie(cookie);

                            Cookie cookie2 = new Cookie("senha", senha);
                            cookie2.setMaxAge(60 * 60 * 24);
                            response.addCookie(cookie2);
                        }

                        returnPage = "home.jsp";
                        request.getSession().setAttribute("username", user2);

                    } else {
                        request.getSession().setAttribute("errormsg", "<p class='msg'> Usuário ou Senha incorretos!</p>");
                        returnPage = "index.jsp";
                    }
                } catch (Exception ex3) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Usuário não encontrado!</p>");
                    returnPage = "index.jsp";
                }
                break;

            case "logout":
                request.getSession().setAttribute("username", null);
                returnPage = "index.jsp";
                break;

            case "update.profile":
                String userteste = request.getParameter("user");
                String fullnameh = request.getParameter("fullnameh");
                String nomeCliente1 = request.getParameter("nomecliente");
                String username3 = request.getParameter("username");
                String password1 = request.getParameter("pwd1");
                String password2 = request.getParameter("pwd2");
                String dtaniversario = request.getParameter("bday");
                String email1 = request.getParameter("email");
                String cpf1 = request.getParameter("cpf");
                Integer idPermissao = 2;

                UsuarioCliente usuariocliente = usuarioClienteDAO.findByName(username3);
                InfoCliente infoEmail = infoClienteDAO.findByEmail(email1);
                if (usuariocliente != null) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Usuário já existente!</p>");
                    returnPage = "updateProfile.jsp";

                } else if (infoEmail != null) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Email já cadastrado!</p>");
                    returnPage = "updateProfile.jsp";
                } else if (nomeCliente1.isEmpty() && username3.isEmpty() && password1.isEmpty() && password2.isEmpty() && dtaniversario.isEmpty() && email1.isEmpty()) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Preencha o formulário!</p>");
                    returnPage = "updateProfile.jsp";
                } else if (password1.equals(password2)) {

                    Permissao permissao = new Permissao();
                    permissao.setIdpermissao(idPermissao);

                    InfoCliente infocliente = new InfoCliente();
                    infocliente.setNomecliente(nomeCliente1);
                    infocliente.setEmail(email1);
                    infocliente.setDtaniversario(DateUtil.string2dateOnly(dtaniversario));
                    infocliente.setCpf(cpf1);

                    UsuarioCliente uc;
                    uc = usuarioClienteDAO.findByName(userteste);
                    uc.setUsername(username3);
                    uc.setSenha(password1);
                    uc.setIdpermissao(permissao);
                    uc.setInfoCliente(infocliente);
                    infocliente.setUsuarioCliente(uc);

                    try {

                        usuarioClienteDAO.update(uc);
                        returnPage = "updateProfile.jsp";
                        request.getSession().setAttribute("sucessmsg", "<p class='msgregister'>Dados alterado com sucesso!</p>");
                    } catch (DBException ex) {
                        request.getSession().setAttribute("errormsg", "<p class='msg'>Erro na conexão com o banco. Tente novamente!</p>");
                        returnPage = "updateProfile.jsp";
                    }
                } else {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Senhas não conferem!</p>");
                    returnPage = "updateProfile.jsp";
                }

                break;

            case "delete.profile":

                Long idusuariocliente = Long.parseLong(request.getParameter("id"));
                String userRemove = request.getParameter("username");
                String pwdRemove = request.getParameter("pwd1");

                UsuarioCliente usuarioCliente2;

                try {
                    usuarioCliente2 = usuarioClienteDAO.findByName(userRemove);
                    usuarioCliente2 = usuarioClienteDAO.findById(idusuariocliente);

                    if (usuarioCliente2.getUsername().equals(userRemove) && usuarioCliente2.getSenha().equals(pwdRemove) && usuarioCliente2.getIdusuariocliente().equals(idusuariocliente)) {
                        usuarioClienteDAO.removeByName(usuarioCliente2);
                        returnPage = "index.jsp";
                    } else {
                        request.getSession().setAttribute("errormsg", "<p class='msg'> Usuário ou Senha incorretos!</p>");
                        returnPage = "deleteProfile.jsp";
                    }

                } catch (Exception ex4) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Erro na conexão com o banco. Tente novamente!</p>");
                    returnPage = "deleteProfile.jsp";
                }
                break;
            case "read":

                request.getSession().setAttribute("userEvents", usuarioClienteDAO.find());
                break;
            case "home":
                returnPage = "home.jsp";
                break;
            case "message":
                returnPage = "message.jsp";
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
