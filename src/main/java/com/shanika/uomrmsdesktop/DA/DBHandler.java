/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shanika.uomrmsdesktop.DA;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shanika Ediriweera
 */
public class DBHandler {
    private Statement statement;
    private ResultSet resultSet;
    private final MysqlConnect db;
    
    public DBHandler()  {
        db = MysqlConnect.getMysqlConnect();
    }
    
    public int setData(String sql)  {
        try {
            statement = db.getDBConnection().createStatement();
            int result = statement.executeUpdate(sql);
            return result;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public ResultSet getData(String sql) {
        try {
            statement = db.getDBConnection().createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }
    
    public int setData(PreparedStatement preparedStatement)  {
        try {
            int result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public ResultSet getData(PreparedStatement preparedStatement) {
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }
    
    //method to get modules
    public String[] getModules(){
        List modulesArray = new ArrayList();
 
        try {
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT DISTINCT code FROM module");
            ResultSet resultSet = getData(preparedStatement);
            
            while (resultSet.next()) {
                modulesArray.add(resultSet.getString(1));
            }   
            // convert to a string array
            return (String[]) modulesArray.toArray(new String[modulesArray.size()]);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
