/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tarefas.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CCE
 */
public class MysqlConnectionFactoryTest {
    
    public MysqlConnectionFactoryTest() {
    }
    
    
    @Test
    public void testGetConnection() throws SQLException{
        MysqlConnectionFactory factory = new MysqlConnectionFactory();
        Connection conn = factory.getConnection();
        assertNotNull(conn);
        conn.close();
    }
    
}
