/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tarefas.dao;

import br.ufpr.tarefas.modelo.Tarefa;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CCE
 */
public class JdbcTarefaDaoTest {
    
    public JdbcTarefaDaoTest() {
    }
    
    @Test
    public void test(){
        
        JdbcTarefaDao dao = new JdbcTarefaDao();
        Tarefa tarefa = new Tarefa("blablabla",true,Calendar.getInstance());
        dao.adiciona(tarefa);
        
        System.out.println(dao.getLista());
        
        
    }
    
}
