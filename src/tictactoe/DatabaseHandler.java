/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is the program's access to the MySQL Database
 * 
 * @author John Rey Juele
 */
public class DatabaseHandler {
    
    private final String DB = "tictactoe";
    private final String CLASSNAME = "com.mysql.jdbc.Driver";
    
    private Connection connect;
    private PreparedStatement prepStatement;
    private ResultSet resultSet;
    
    /**
     * Connection between program and the MySQL Database. It also handles
     * requests from the program to the database.
     * 
     * @param user username credential 
     * @param password password corresponding to the username
     * @throws SQLException when provided credentials are incorrect
     */
    public DatabaseHandler(String user, String password) {
        try {
            Class.forName(CLASSNAME);
            
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/" + DB + "?" +
                            "user=" + user + "&password=" + password);
            
            System.out.println("Connection to " + DB + " is SUCCESSFUL");
        } catch(SQLException e) {
            System.out.println("Connection to " + DB + " FAILED");
            System.exit(-1);
        } catch(ClassNotFoundException ex) {
            System.out.println("Class not found!");
            System.exit(-1);
        }
    }
    
    /**
     * Closes connection with the database
     */
    public void close() {
        try {
            
            if(resultSet != null) {
                resultSet.close();
            } 
            
            if(prepStatement != null) {
                prepStatement.close();
            }
            
            if(connect != null) {
                connect.close();
            }
            
            System.out.println("Closing connection");
            
        } catch(SQLException e) {
            System.out.println("Closing connection failed!");
        }
    }
}
