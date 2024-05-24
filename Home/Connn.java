package src.bank.management.system;

import java.sql.*;

/**
 * This class establishes a connection to the MySQL database for the bank management system.
 */
public class Connn {
     Connection connection;
     Statement statement;
    
    /**
     * Constructor to initialize the database connection.
    **/
    public Connn(){
        
        try{
            // Establishing connection to the MySQL database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem","root","");
            statement = connection.createStatement();   
           }catch (Exception e){
            
            // Printing stack trace if connection fails
            e.printStackTrace();
        }
      }
    }
