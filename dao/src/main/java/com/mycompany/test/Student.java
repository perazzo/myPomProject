/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

/**
 *
 * @author W205951620
 */
public class Student {
    private static String dbURL = "jdbc:derby://localhost:1527/JavaClass;create=true;user=perazzo;password=sa";
    private static String tableName = "Students";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
    
    public static void main(String[] args)
    {
        createConnection();
        insertStudent("First Name", "Last Name", 30);
        selectStudents();
        shutdown();
    }
    
    private static void createConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
    
    private static void insertStudent(String fName, String lName, int age)
    {
        try
        {
            
            stmt = (Statement) conn.createStatement();
            stmt.execute("insert into " + tableName + "(FirstName, LastName, Age) values (" + "'" +
                    fName + "','" + lName + "'," + age +")");
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    
    private static void selectStudents()
    {
        try
        {
            stmt = (Statement) conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
            }

            System.out.println("\n-------------------------------------------------");

            while(results.next())
            {
                int id = results.getInt(1);
                String fName = results.getString(2);
                String LName = results.getString(3);
                int age = results.getInt(4);
                System.out.println(id + "\t\t" + fName + "\t\t" + LName + "\t\t" + age);
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    
    private static void shutdown()
    {
        try
        {
            if (stmt != null)
            {
                stmt.close();
            }
            if (conn != null)
            {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            
        }

    }

    Student(String studentFName, String studentLName, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
