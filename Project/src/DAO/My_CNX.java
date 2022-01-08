 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jules
 */

public class My_CNX {

    private static String servername = "localhost";
    private static String username = "root";
    private static String dbname  = "base_de_donne";
    private static Integer portnumber  = 3306;
    private static String password = "crack";
    
    public static Connection getConnection()
    {
        Connection cnx = null;
        
        /**MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);**/
        
        String url="jdbc:mysql://localhost:3306/base_de_donne?useSSL=false";
        String id="root";
        String password="crack";
        try {
            cnx = DriverManager.getConnection(url,id,password);
            if (cnx!=null){
            System.out.println("Connected to database ");
            }            
        }
        catch(SQLException ex ){
            System.out.println(ex);
            System.out.println("Not connected to database");
        }
        
        return cnx;
    }
    
}