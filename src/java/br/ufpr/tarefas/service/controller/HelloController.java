/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tarefas.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author CCE
 */
@Controller
public class HelloController {
    
    @RequestMapping("/olaMundo")
    public String execute() {
        System.out.println("Executando a lógica com Spring MVC");
        return "ok";
    }
}
