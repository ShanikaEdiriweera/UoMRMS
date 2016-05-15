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
        List moduleArray = new ArrayList();
 
        try {
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT DISTINCT code FROM module");
            ResultSet resultSet = getData(preparedStatement);
            
            while (resultSet.next()) {
                moduleArray.add(resultSet.getString(1));
            }   
            // convert to a string array
            return (String[]) moduleArray.toArray(new String[moduleArray.size()]);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    //method to get Semesters
    public String[] getSemesters(){
        List semesterArray = new ArrayList();
 
        try {
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT name FROM semester");
            ResultSet resultSet = getData(preparedStatement);
            
            while (resultSet.next()) {
                semesterArray.add(resultSet.getString(1));
            }   
            // convert to a string array
            return (String[]) semesterArray.toArray(new String[semesterArray.size()]);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    //method to get faculties
    public String[] getFaculties(){
        List facultyArray = new ArrayList();
 
        try {
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT name FROM faculty");
            ResultSet resultSet = getData(preparedStatement);
            
            while (resultSet.next()) {
                facultyArray.add(resultSet.getString(1));
            }   
            // convert to a string array
            return (String[]) facultyArray.toArray(new String[facultyArray.size()]);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    //method to get departments
    public String[] getDepartments(){
        List departmentArray = new ArrayList();
 
        try {
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT name FROM department");
            ResultSet resultSet = getData(preparedStatement);
            
            while (resultSet.next()) {
                departmentArray.add(resultSet.getString(1));
            }   
            // convert to a string array
            return (String[]) departmentArray.toArray(new String[departmentArray.size()]);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    //method to get batches
    public String[] getBatches(){
        List batchArray = new ArrayList();
 
        try {
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT year FROM batch");
            ResultSet resultSet = getData(preparedStatement);
            
            while (resultSet.next()) {
                batchArray.add(resultSet.getString(1));
            }   
            // convert to a string array
            return (String[]) batchArray.toArray(new String[batchArray.size()]);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
