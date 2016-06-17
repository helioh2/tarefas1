/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tarefas.dao;

import br.ufpr.tarefas.jdbc.MysqlConnectionFactory;
import br.ufpr.tarefas.modelo.Tarefa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author CCE
 */
public class JdbcTarefaDao {
    
    private Connection connection;

    public JdbcTarefaDao() {
        connection = (new MysqlConnectionFactory()).getConnection();
    }
    
    
    public void adiciona(Tarefa tarefa) {
		String sql = "insert into tarefas " + "(descricao, finalizado, dataFinalizacao) " + "values (?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

    
        public List<Tarefa> getLista() {
		String sql = "select * from tarefas";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<Tarefa> tarefas = new ArrayList<Tarefa>();
			while (rs.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
                                tarefa.setDescricao(rs.getString("descricao"));
                                tarefa.setFinalizado(rs.getBoolean("finalizado"));

				criarDataNascimento(rs, tarefa);
				
				tarefas.add(tarefa);
			}
			stmt.close();
			return tarefas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
        
        private void criarDataNascimento(ResultSet rs, Tarefa tarefa) throws SQLException {
		Date dataFinalizacaoDate = rs.getDate("dataFinalizacao");
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(dataFinalizacaoDate);
		tarefa.setDataFinalizacao(dataNascimento);
	}
	
    
        public void remove(Tarefa tarefa) {
		String sql = "delete from tarefas where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, tarefa.getId());
			
			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

    public List<Tarefa> lista() {
        String sql = "select * from tarefas";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<Tarefa> tarefas = new ArrayList<Tarefa>();
			while (rs.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
                                Calendar dataFinalizacao = Calendar.getInstance();
                                dataFinalizacao.setTimeInMillis(rs.getDate("dataFinalizacao").getTime());
				tarefa.setDataFinalizacao(dataFinalizacao);
				
				tarefas.add(tarefa);
			}
			stmt.close();
			return tarefas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
}
    }
        
}
