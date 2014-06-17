/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.db;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashMap;

import java.util.Map.Entry;
import java.util.Properties;


/**
 *
 * @author forsell
 */
public class DBConnection {

    Connection connection=null;
    HashMap<Integer,Param> parameters;
     

    public DBConnection() throws ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        parameters=new HashMap<Integer, Param>();
    }
    public void open() throws IOException, SQLException
    {
        Properties properties=new Properties();
        properties.load(new FileInputStream(new File("database.properties")));
        String url=properties.getProperty("URL");
        String user=properties.getProperty("USER_NAME");
        String password=properties.getProperty("PASSWORD");
        connection=DriverManager.getConnection(url,user,password);
    }

    public int execute(String sql) throws SQLException
    {

        PreparedStatement statement=connection.prepareStatement(sql);
        getParameters(parameters,statement);

       return statement.executeUpdate();
    }

    public void addParameters(int index,Param value)
    {
        parameters.put(index, value);
    }

    public void getParameters(HashMap<Integer,Param> parameters,PreparedStatement statement) throws SQLException
    {
        if(parameters.size()>0){
            for (Entry<Integer, Param> p : parameters.entrySet()) {
                Param param=p.getValue();
                if(param.getType()==Type.Integer)
                {
                    statement.setInt(p.getKey(),(Integer)param.getValue());
                }
                else if(param.getType() == Type.String)
                {
                    statement.setString(p.getKey(),(String)param.getValue());
                }
                else if(param.getType()==Type.TimeStamp)
                {
                    statement.setTimestamp(p.getKey(),(Timestamp)param.getValue());
                }
            }
        }
    }

   public ResultSet fetch(String sql) throws SQLException
   {
       PreparedStatement statement=connection.prepareStatement(sql);
       return statement.executeQuery();
       
   }

   public void close() throws SQLException
    {
       if(connection!=null)
       {
           connection.close();
           connection=null;
       }
   }
    
}
