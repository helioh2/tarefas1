/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tarefas.service.controller;

import br.ufpr.tarefas.dao.JdbcTarefaDao;
import br.ufpr.tarefas.modelo.Tarefa;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author CCE
 */
@Controller
public class TarefasController {

    @RequestMapping("novaTarefa")
    public String form() {
        return "tarefa/formulario";
    }

    @RequestMapping("adicionaTarefa")
    public String adiciona(@Valid Tarefa tarefa, BindingResult result) {

        if (result.hasFieldErrors("descricao")) {
            return "tarefa/formulario";
        }

        JdbcTarefaDao dao = new JdbcTarefaDao();
        dao.adiciona(tarefa);
        return "tarefa/adicionada";
    }

    @RequestMapping("listaTarefas")
    public String lista(Model model) {
        JdbcTarefaDao dao = new JdbcTarefaDao();
        List<Tarefa> tarefas = dao.lista();
        model.addAttribute("tarefas", tarefas);
        return "tarefa/lista";
    }

    @RequestMapping("removerTarefa")
    public String remove(Tarefa tarefa) {
        JdbcTarefaDao dao = new JdbcTarefaDao();
        dao.remover(tarefa);
        return "redirect:listaTarefas";
    }

    @RequestMapping("mostraTarefa")
    public String mostra(Long id, Model model) {
        JdbcTarefaDao dao = new JdbcTarefaDao();
        model.addAttribute("tarefa", dao.buscaPorId(id));
        return "tarefa/mostra";
    }

    @RequestMapping("alteraTarefa")
    public String altera(Tarefa tarefa) {
        JdbcTarefaDao dao = new JdbcTarefaDao();
        dao.altera(tarefa);
        return "redirect:listaTarefas";
    }
    
//    @RequestMapping("finalizarTarefa")
//    public void finaliza(Long id, HttpServletResponse response) throws IOException {
//        JdbcTarefaDao dao = new JdbcTarefaDao();
//        Tarefa tarefa = dao.buscaPorId(id);
//        tarefa.setFinalizado(true);
//        tarefa.setDataFinalizacao(Calendar.getInstance());
//        dao.altera(tarefa);
//        String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(
//                tarefa.getDataFinalizacao().getTime());
//        response.getWriter().write(dataFormatada);
//        response.setStatus(200);
//    }
    
    
    @RequestMapping("finalizarTarefa")
    public String finaliza(Long id, Model model){
        JdbcTarefaDao dao = new JdbcTarefaDao();
        Tarefa tarefa = dao.buscaPorId(id);
        tarefa.setFinalizado(true);
        tarefa.setDataFinalizacao(Calendar.getInstance());
        dao.altera(tarefa);

        model.addAttribute("tarefa",tarefa);
        
        return "tarefa/finalizada";
        
    }
}
