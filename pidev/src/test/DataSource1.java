/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class DataSource1 {
    
    private static DataSource1 data ;
    private Connection cnx ;
    public String user= "root" ;
    public String password = "";
    public String url ="jdbc:mysql://localhost:3306/pidev";
    
    private DataSource1()
    {
        try 
        {
            cnx = DriverManager.getConnection(url, user, password);
            System.out.println("connexion etablie ");
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DataSource1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DataSource1 getInstance ()
    {
        if (data==null)
           data = new DataSource1();
        return data ;
    }

    public static DataSource1 getData() {
        return data;
    }

    public static void setData(DataSource1 data) {
        DataSource1.data = data;
    }

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
   
    
}
