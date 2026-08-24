package com.websolution; 
 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
 
public class Conexion { 
 
    private static final String URL = 
            "jdbc:mysql://localhost:3307/websolution?useSSL=false&serverTimezone=UTC"; 
 
    private static final String USER = "root"; 
 
    private static final String PASSWORD = "DYLAN334"; 
 
    public static void main(String[] args) { 
 
        try { 
            Connection conexion = DriverManager.getConnection( 
                    URL, 
                    USER, 
                    PASSWORD 
            ); 
 
            System.out.println("================================="); 
            System.out.println("CONEXION EXITOSA A MYSQL"); 
            System.out.println("Base de datos: websolution"); 
            System.out.println("Puerto: 3307"); 
            System.out.println("================================="); 
 
            conexion.close(); 
 
        } catch (SQLException e) { 
 
            System.out.println("ERROR AL CONECTAR CON MYSQL"); 
            e.printStackTrace(); 
        } 
    } 
}
