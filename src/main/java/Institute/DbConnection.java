/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Institute;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author johnh
 */
class DbConnection {

    

  public static Connection dbconnect() {

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String connectionUrl = "jdbc:mysql://localhost:3306/hniti";
            String connectionUser = "root";
            String connectionPassword = "root";
            con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            System.out.println("Connected");

        } catch (Exception e) {
            System.out.println("Error from dbconnection");
        }
        return con;
    
}

}
