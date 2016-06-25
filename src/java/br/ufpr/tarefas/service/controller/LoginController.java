/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tarefas.service.controller;

import br.ufpr.tarefas.dao.JdbcUsuarioDao;
import br.ufpr.tarefas.modelo.Usuario;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Lenovo
 */
@Controller
public class LoginController {
    
    @RequestMapping("loginForm")
    public String form(){
        return "formulario-login";
    }
    
    
    @RequestMapping("efetuaLogin")
    public String efetuaLogin(Usuario usuario, HttpSession session){
        if(new JdbcUsuarioDao().existeUsuario(usuario)) {
            session.setAttribute("logado", usuario);
            return "redirect:listaTarefas";
        }
        return "redirect:loginForm";
        
        
    }
    
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:loginForm";
    }
    
}
