/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

/**
 *
 * @author kp728
 */

import java.sql.*;
public class BDconexion {
    private static final String URL = "jdbc:mysql://localhost:2234/reservas";
    private static final String USER = "root";
    private static final String PASSWORD = "31kp720";
    
    public static Connection Conexion() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al registrar el driver de MySQL: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return connection;
    }

    public static void main(String[] args) {
        // Probar la conexión
        Connection conn = BDconexion.Conexion();
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
