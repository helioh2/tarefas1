/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tarefas.service.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Lenovo
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        String uri = request.getRequestURI();
        
        if (uri.endsWith("loginForm") || uri.endsWith("efetuaLogin")
                || uri.contains("resources")){
            return true;
        }
        
        if (request.getSession().getAttribute("logado")!=null) {
            return true;
        }
        response.sendRedirect("loginForm");
        return false;
    }
    
    
    
}
