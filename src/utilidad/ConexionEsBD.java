/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidad;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author kevingodoy
 */
public class ConexionEsBD {
    public static Connection getConnection() {
        try {
        	
        	Class.forName("org.hsqldb.jdbcDriver");  
        	Connection con = DriverManager.getConnection(  
                    "jdbc:hsqldb:file:BD/BDMillonario", "kevin98", "tbmsfoyu9230");  
            
        	//Class.forName("com.mysql.jdbc.Driver");
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname",
            //        "root", "dbpass");
            return con;
        } catch (Exception ex) {
        		ex.printStackTrace();
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }
 
    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
    
}
