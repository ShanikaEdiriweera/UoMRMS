/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shanika.uomrmsdesktop.DA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Shanika Ediriweera
 */
public class DBHandler {
    private Statement statement;
    private ResultSet resultSet;
    private final MysqlConnect db;
    
    public DBHandler() throws ClassNotFoundException, SQLException{
        db = MysqlConnect.getMysqlConnect();
    }
    
    public int setData(String sql) throws SQLException, ClassNotFoundException {
        statement = db.getDBConnection().createStatement();
        int result = statement.executeUpdate(sql);
        return result;
    }
    
    public ResultSet getData(String sql) throws SQLException, ClassNotFoundException{
        statement = db.getDBConnection().createStatement();
        resultSet = statement.executeQuery(sql);
        return resultSet;
    }
}
