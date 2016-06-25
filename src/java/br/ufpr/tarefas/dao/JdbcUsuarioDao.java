/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tarefas.dao;

import br.ufpr.tarefas.jdbc.MysqlConnectionFactory;
import br.ufpr.tarefas.modelo.Tarefa;
import br.ufpr.tarefas.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class JdbcUsuarioDao {

    private Connection connection;

    public JdbcUsuarioDao() {
        connection = (new MysqlConnectionFactory()).getConnection();
    }
    
    public boolean existeUsuario(Usuario usuario) {
        String sql = "select 1 from usuarios where login=? and senha=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            ResultSet rs = stmt.executeQuery();
            boolean result = false;
            if (rs.next()){
                result = rs.getInt(1) == 1;
            }
            stmt.close();
            return result ;
            
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        
        
    }
    
    
    
}
