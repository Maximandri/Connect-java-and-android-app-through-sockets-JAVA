package com.apiplayer.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 *
 * @author 1BestCsharp
 */
public class ConexionDB {

    private static String servername = "localhost";
    private static String username = "root";
    private static String dbname  = "users_db";
    private static Integer portnumber  = 3306;
    private static String password = "root";
    
    public static Connection getConnection()
    {
        Connection connection = null;
        
        MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
        
        try {
            connection = datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(" Get Connection -> " + ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
    
}