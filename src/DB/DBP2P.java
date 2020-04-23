/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author NAUFAL
 */
public class DBP2P {
    
    private Connection connection = null;
    
    public Connection setConnection(){
        try {
            String url = "jdbc:mysql://localhost:3306/p2p";
            String user = "root";
            String pass = "";
            String db = "p2p";
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url,user,pass);
            
        } catch (Exception e) {
            System.out.println("ERROR"+e.getMessage());
        }
        return connection;
    }
}
