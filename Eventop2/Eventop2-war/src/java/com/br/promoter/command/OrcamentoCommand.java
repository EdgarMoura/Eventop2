package com.br.promoter.command;

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
          case "home":
              returnPage = "index.jsp";
              
              break;
          
      }
    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }

}
