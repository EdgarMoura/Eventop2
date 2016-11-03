/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.command;

import com.br.promoter.exceptions.DBException;
import com.br.promoter.model.dao.InfoClienteDAO;
import com.br.promoter.model.dao.PermissaoDAO;
import com.br.promoter.model.dao.AnuncioDAO;
import com.br.promoter.model.dao.UsuarioClienteDAO;
import com.br.promoter.model.entities.InfoCliente;
import com.br.promoter.model.entities.Permissao;
import com.br.promoter.model.entities.UsuarioCliente;
import com.br.promoter.util.CriptografiaMd5;
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
public class UsuarioCommand implements Command {

    AnuncioDAO anuncioDAO = lookupAnuncioDAOBean();
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
        CriptografiaMd5 criptMd5 = new CriptografiaMd5();
        switch (action) {
            case "registrar":
                String nomeCliente = request.getParameter("nomecliente");
                String username = request.getParameter("username");
                String senha1 = request.getParameter("senha1");
                String senha2 = request.getParameter("senha2");
                String telefone = request.getParameter("telefone");
                String email = request.getParameter("email");
                String cpf = request.getParameter("cpf");
                Integer fkPermissao = 2;

                UsuarioCliente user = usuarioClienteDAO.findByName(username);
                InfoCliente infoemail = infoClienteDAO.findByEmail(email);

                if (user != null) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Usuário já existente!</p>");
                    returnPage = "cadastro.jsp";

                } else if (infoemail != null) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Email já cadastrado!</p>");
                    returnPage = "cadastro.jsp";
                } else if (senha1.equals(senha2)) {

                    Permissao permissao = new Permissao();
                    permissao.setIdpermissao(fkPermissao);

                    InfoCliente infocliente = new InfoCliente();
                    infocliente.setNomecliente(nomeCliente);
                    infocliente.setEmail(email);
                    infocliente.setTelefone(telefone);
                    infocliente.setCpf(cpf);

                    UsuarioCliente uc = new UsuarioCliente();
                    uc.setUsername(username);
                    uc.setSenha(criptMd5.md5(senha1));
                    uc.setFkPermissao(permissao);

                    uc.setInfoCliente(infocliente);
                    infocliente.setUsuarioCliente(uc);

                    try {

                        usuarioClienteDAO.persist(uc);
                        returnPage = "home.jsp";
                        UsuarioCliente userCadastro = usuarioClienteDAO.findByName(username);
                        request.getSession().setAttribute("username", userCadastro);
                    } catch (DBException ex) {
                        request.getSession().setAttribute("errormsg", "<p class='msg'>Erro na conexão com o banco. Tente novamente!</p>");
                        returnPage = "cadastro.jsp";
                    }
                } else {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Senhas não conferem!</p>");
                    returnPage = "cadastro.jsp";

                }
                break;

            case "registrar2":
                String nomePromoter = request.getParameter("nomePromoter");
                String username1 = request.getParameter("username");
                String senha3 = request.getParameter("senha1");
                String senha4 = request.getParameter("senha2");
                String email1 = request.getParameter("email");
                String telefone1 = request.getParameter("telefone");
                String cpf1 = request.getParameter("cpf");
                Integer fkPermissao1 = 3;

                UsuarioCliente user1 = usuarioClienteDAO.findByName(username1);
                InfoCliente infoemail1 = infoClienteDAO.findByEmail(email1);

                if (user1 != null) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Usuário já existente!</p>");
                    returnPage = "cadastro.jsp";

                } else if (infoemail1 != null) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Email já cadastrado!</p>");
                    returnPage = "cadastro.jsp";
                } else if (senha3.equals(senha4)) {

                    Permissao permissao = new Permissao();
                    permissao.setIdpermissao(fkPermissao1);

                    InfoCliente infocliente = new InfoCliente();
                    infocliente.setNomecliente(nomePromoter);
                    infocliente.setEmail(email1);
                    infocliente.setTelefone(telefone1);
                    infocliente.setCpf(cpf1);

                    UsuarioCliente uc = new UsuarioCliente();
                    uc.setUsername(username1);
                    uc.setSenha(criptMd5.md5(senha3));
                    uc.setFkPermissao(permissao);

                    uc.setInfoCliente(infocliente);
                    infocliente.setUsuarioCliente(uc);

                    try {

                        usuarioClienteDAO.persist(uc);
                        returnPage = "home.jsp";
                        UsuarioCliente userCadastro = usuarioClienteDAO.findByName(username1);
                        request.getSession().setAttribute("username", userCadastro);
                    } catch (DBException ex) {
                        request.getSession().setAttribute("errormsg", "<p class='msg'>Erro na conexão com o banco. Tente novamente!</p>");
                        returnPage = "cadastro.jsp";
                    }
                } else {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Senhas não conferem!</p>");
                    returnPage = "cadastro.jsp";

                }
                break;
                
            case "registrar3":
                String nomeFornecedor = request.getParameter("nomeFornecedor");
                String usernameF = request.getParameter("username");
                String senhaF = request.getParameter("senha1");
                String senhaF1 = request.getParameter("senha2");
                String emailF = request.getParameter("email");
                String telefoneF = request.getParameter("telefone");
                String cnpj = request.getParameter("cnpj");
                Integer fkPermissaoF = 4;

                UsuarioCliente userF = usuarioClienteDAO.findByName(usernameF);
                InfoCliente infoemailF = infoClienteDAO.findByEmail(emailF);

                if (userF != null) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Usuário já existente!</p>");
                    returnPage = "cadastro.jsp";

                } else if (infoemailF != null) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Email já cadastrado!</p>");
                    returnPage = "cadastro.jsp";
                } else if (senhaF.equals(senhaF1)) {

                    Permissao permissao = new Permissao();
                    permissao.setIdpermissao(fkPermissaoF);

                    InfoCliente infocliente = new InfoCliente();
                    infocliente.setNomecliente(nomeFornecedor);
                    infocliente.setEmail(emailF);
                    infocliente.setTelefone(telefoneF);
                    infocliente.setCpf(cnpj);

                    UsuarioCliente uc = new UsuarioCliente();
                    uc.setUsername(usernameF);
                    uc.setSenha(criptMd5.md5(senhaF));
                    uc.setFkPermissao(permissao);

                    uc.setInfoCliente(infocliente);
                    infocliente.setUsuarioCliente(uc);

                    try {

                        usuarioClienteDAO.persist(uc);
                        returnPage = "home.jsp";
                        UsuarioCliente userCadastro = usuarioClienteDAO.findByName(usernameF);
                        request.getSession().setAttribute("username", userCadastro);
                    } catch (DBException ex) {
                        request.getSession().setAttribute("errormsg", "<p class='msg'>Erro na conexão com o banco. Tente novamente!</p>");
                        returnPage = "cadastro.jsp";
                    }
                } else {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Senhas não conferem!</p>");
                    returnPage = "cadastro.jsp";

                }
                break;    

            case "login":
                String username2 = request.getParameter("username");
                String senha = request.getParameter("senha");

                String senhaMd5 = criptMd5.md5(senha);
                UsuarioCliente user2;

                //System.out.println("Senha:" + senha);

                try {

                    user2 = usuarioClienteDAO.findByName(username2);

                    if (user2.getUsername().equals(username2) && user2.getSenha().equals(senhaMd5)) {

                        String check = request.getParameter("lembrar");
                        if ("on".equals(check)) {
                            Cookie cookie = new Cookie("username", username2);
                            cookie.setMaxAge(60 * 60 * 24);
                            response.addCookie(cookie);

                            Cookie cookie2 = new Cookie("senha", senhaMd5);
                            cookie2.setMaxAge(60 * 60 * 24);
                            response.addCookie(cookie2);
                        }

                        returnPage = "home.jsp";
                        request.getSession().setAttribute("username", user2);

                    } else {
                        request.getSession().setAttribute("errormsg", "<p class='msg'> Usuário ou Senha incorretos!</p>");
                        returnPage = "login.jsp";
                    }
                } catch (Exception ex3) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Usuário não encontrado!</p>");
                    returnPage = "login.jsp";
                }
                break;

            case "logout":
                request.getSession().invalidate();
                request.getSession().setAttribute("infoClientes", infoClienteDAO.find());
                returnPage = "index.jsp";
                break;

            case "atualiza.perfil":
                String userteste = request.getParameter("user");
                Integer idinfoCliente = Integer.parseInt(request.getParameter("iduser"));
                String username3 = request.getParameter("username");
                String password1 = request.getParameter("pwd1");
                String password2 = request.getParameter("pwd2");
                String fullname = request.getParameter("fullname");
                String telefone2 = request.getParameter("telefone");
                String email2 = request.getParameter("email");
                Integer fkPermissao2 = Integer.parseInt(request.getParameter("idPermissao"));

                UsuarioCliente usuariocliente = usuarioClienteDAO.findByName(username3);

                if (usuariocliente != null) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Usuário já existente!</p>");
                    returnPage = "atualizaPerfil.jsp";

                } else if (password1.equals(password2)) {

                    Permissao permissao = new Permissao();
                    permissao.setIdpermissao(fkPermissao2);

                    InfoCliente infocliente;
                    infocliente = infoClienteDAO.findById(idinfoCliente);
                    infocliente.setNomecliente(fullname);
                    infocliente.setEmail(email2);
                    infocliente.setTelefone(telefone2);

                    UsuarioCliente uc;
                    uc = usuarioClienteDAO.findByName(userteste);
                    uc.setUsername(username3);
                    uc.setSenha(criptMd5.md5(password1));
                    uc.setFkPermissao(permissao);
                    uc.setInfoCliente(infocliente);
                    infocliente.setUsuarioCliente(uc);

                    try {

                        usuarioClienteDAO.update(uc);
                        request.getSession().setAttribute("sucessmsg", "<p class='msgregister'>Dados alterado com sucesso!</p>");
                        returnPage = "alteraPerfil.jsp";
                    } catch (DBException ex) {
                        request.getSession().setAttribute("errormsg", "<p class='msg'>Erro na conexão com o banco. Tente novamente!</p>");
                        returnPage = "atualizaPerfil.jsp";
                    }
                } else {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Senhas não conferem!</p>");
                    returnPage = "atualizaPerfil.jsp";
                }

                break;

            case "deleta.perfil":

                Integer idusuariocliente = Integer.parseInt(request.getParameter("id"));
                String userRemove = request.getParameter("username");
                String pwdRemove = request.getParameter("pwd1");
                String pwdMd5 = criptMd5.md5(pwdRemove);

                UsuarioCliente usuarioCliente2;
                UsuarioCliente usuarioId;

                try {

                    usuarioCliente2 = usuarioClienteDAO.findByName(userRemove);
                    usuarioId = usuarioClienteDAO.findById(idusuariocliente);
                    if (usuarioCliente2.getUsername().equals(userRemove) && usuarioCliente2.getSenha().equals(pwdMd5) && usuarioId.getIdusuariocliente().equals(idusuariocliente)) {
                        usuarioClienteDAO.remove(idusuariocliente);
                        returnPage = "index.jsp";
                    } else {
                        request.getSession().setAttribute("errormsg", "<p class='msg'> Usuário ou Senha incorretos!</p>");
                        returnPage = "deletaPerfil.jsp";
                    }

                } catch (Exception ex4) {
                    request.getSession().setAttribute("errormsg", "<p class='msg'>Erro na conexão com o banco. Tente novamente!</p>");
                    returnPage = "deletaPerfil.jsp";
                }
                break;
            case "visualiza":

                request.getSession().setAttribute("usuarioClientes", usuarioClienteDAO.find());

                break;
            case "home":

                returnPage = "home.jsp";
                break;
            case "orcamento":
                returnPage = "orcamento.jsp";
                break;
            case "entrar":
                returnPage = "login.jsp";
                break;
            case "cadastrar":
                returnPage = "cadastro.jsp";
                break;
            case "index":
                request.getSession().setAttribute("infoClientes", infoClienteDAO.find());
                returnPage = "index.jsp";

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

    private AnuncioDAO lookupAnuncioDAOBean() {
        try {
            Context c = new InitialContext();
            return (AnuncioDAO) c.lookup("java:global/Eventop2/Eventop2-ejb/AnuncioDAO!com.br.promoter.model.dao.AnuncioDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
