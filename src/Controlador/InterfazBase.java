/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;

import Conexion.BDconexion;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.*;
import utileria.*;
/**
 *
 * @author kp728
 */
public class InterfazBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static DefaultTableModel extraerViajes(){
        DefaultTableModel modelo = new DefaultTableModel();
        try (Connection c = BDconexion.Conexion();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM reservas.vuelo")){
            
            int columnas = rs.getMetaData().getColumnCount();
            for(int x = 1; x <= columnas ; x++){
                modelo.addColumn(rs.getMetaData().getColumnName(x));
            }
            
            
            while (rs.next()){
                Object[] datos = new Object[columnas];
                for(int y = 1 ; y <= columnas; y++){
                    datos[y - 1] = rs.getObject(y);
                }
                modelo.addRow(datos);
            }
            return modelo;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static DefaultTableModel extraerReservas(int idCliente) {
        DefaultTableModel modelo = new DefaultTableModel();
        String query = "SELECT * FROM Reservacion WHERE id_cliente = ?";
        
        try (Connection c = BDconexion.Conexion();
             PreparedStatement stmt = c.prepareStatement(query)) {
            
            // Establece el parámetro de la consulta
            stmt.setInt(1, idCliente);
            
            ResultSet rs = stmt.executeQuery();
            
            // Obtiene la metadata de la consulta
            ResultSetMetaData metaData = rs.getMetaData();
            int columnas = metaData.getColumnCount();
            
            // Añade las columnas al modelo
            for (int i = 1; i <= columnas; i++) {
                modelo.addColumn(metaData.getColumnName(i));
            }
            
            // Añade las filas al modelo
            while (rs.next()) {
                Object[] datos = new Object[columnas];
                for (int i = 1; i <= columnas; i++) {
                    datos[i - 1] = rs.getObject(i);
                }
                modelo.addRow(datos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modelo;
    }
    
    
    public static DefaultTableModel extraerAviones() {
    DefaultTableModel modelo = new DefaultTableModel();
    try (Connection c = BDconexion.Conexion();
         Statement stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM reservas.avion WHERE disponible = 1")) {

        int columnas = rs.getMetaData().getColumnCount();

        for (int x = 1; x <= columnas; x++) {
            modelo.addColumn(rs.getMetaData().getColumnName(x));
        }

        while (rs.next()) {
            Object[] datos = new Object[columnas];
            for (int y = 1; y <= columnas; y++) {
                datos[y - 1] = rs.getObject(y);
            }
            modelo.addRow(datos);
        }

        return modelo;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
    }
    
    public static DefaultTableModel extraerAvionesCompleto() {
    DefaultTableModel modelo = new DefaultTableModel();
    try (Connection c = BDconexion.Conexion();
         Statement stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM reservas.avion")) {

        int columnas = rs.getMetaData().getColumnCount();

        for (int x = 1; x <= columnas; x++) {
            modelo.addColumn(rs.getMetaData().getColumnName(x));
        }

        while (rs.next()) {
            Object[] datos = new Object[columnas];
            for (int y = 1; y <= columnas; y++) {
                datos[y - 1] = rs.getObject(y);
            }
            modelo.addRow(datos);
        }

        return modelo;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
    }
    
    public static DefaultTableModel extraerUsuarios(){
        DefaultTableModel modelo = new DefaultTableModel();
        try (Connection c = BDconexion.Conexion();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM reservas.usuario")){
            
            int columnas = rs.getMetaData().getColumnCount();
            for(int x = 1; x <= columnas ; x++){
                modelo.addColumn(rs.getMetaData().getColumnName(x));
            }
            
            
            while (rs.next()){
                Object[] datos = new Object[columnas];
                for(int y = 1 ; y <= columnas; y++){
                    datos[y - 1] = rs.getObject(y);
                }
                modelo.addRow(datos);
            }
            return modelo;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private static boolean verificarCredenciales(String correo, String contraseña, String rolE) {
    String query = "SELECT u.contraseña, r.tipo_rol FROM Usuario u JOIN Rol r ON u.id_rol = r.id_rol WHERE u.correo = ?";
    
    try (Connection c = BDconexion.Conexion();
         PreparedStatement stmt = c.prepareStatement(query)) {
        stmt.setString(1, correo);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            String hashedPassword = rs.getString("contraseña");
            String rol = rs.getString("tipo_rol");
            
            if (Validaciones.comprobarContra(contraseña, hashedPassword) && rol.equals(rolE)) {
                return true;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

    
    public static int verificarAcceso(String correo, String contra) {
        if (verificarCredenciales(correo, contra, "Administrador")) {
            return 1;
        } else if (verificarCredenciales(correo, contra, "Cliente")) {
            return 2;
        }
        return -1;
    }
    
    public static void validarUsuarioContra(String c, JLabel cc){
        if(!Validaciones.validarContraseña(c)){
            cc.setText("Formato Invalido");
            cc.setForeground(Color.red);
        } else{
            cc.setText("Formato Valido");
            cc.setForeground(Color.green);
        }
    }
    
    public static void validarUsuarioCorreo(String c, JLabel cc){
        if(!Validaciones.validarCorreo(c)){
            cc.setText("Formato Invalido");
            cc.setForeground(Color.red);
        } else{
            cc.setText("Formato Valido");
            cc.setForeground(Color.green);
        }
    }
    
    public static void validarCorreoEmpleado(String c, JLabel cc){
        if(!Validaciones.validarCorreoEmpleado(c)){
            cc.setText("Formato Invalido");
            cc.setForeground(Color.red);
        } else{
            cc.setText("Formato Valido");
            cc.setForeground(Color.green);
        }
    }
    
    private static int registrarCliente(String nombre, String numero, String correo) {
        String query = "INSERT INTO Cliente (nombre, numero, correo) VALUES (?, ?, ?)";
        try (Connection c = BDconexion.Conexion();
            PreparedStatement stmt = c.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nombre);
            stmt.setString(2, numero);
            stmt.setString(3, correo);  
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    
    
    private static boolean registrarUsuarioCliente(String correo, String contraseña, int id_cliente) {
        String query = "INSERT INTO Usuario (correo, contraseña, id_rol, id_cliente) VALUES (?, ?, ?, ?)";
        try (Connection c = BDconexion.Conexion();
            PreparedStatement stmt = c.prepareStatement(query)) {
            stmt.setString(1, correo); 
            stmt.setString(2, contraseña);  
            stmt.setInt(3, 2);  
            stmt.setInt(4, id_cliente);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    
    public static boolean registroCU(String nombre, String numero, String correo, String contraseña) {
        boolean resultado = false;
        if (Validaciones.validarContraseña(contraseña) && Validaciones.validarCorreo(correo)) {

            String hashedPassword = Validaciones.encriptarContra(contraseña);

            int clienteId = registrarCliente(nombre, numero, correo); 

            if (clienteId != -1) {
                resultado = registrarUsuarioCliente(correo, hashedPassword, clienteId);  
            } else {
                System.out.println("Error al registrar el cliente.");
            }

        } else {
            System.out.println("Correo o contraseña no válidos.");
        }
        return resultado;
    }
    
    public static boolean registroAU(String nombre,String apellido, String numero, String correo, String contraseña) {
        boolean resultado = false;
        if (Validaciones.validarContraseña(contraseña) && Validaciones.validarCorreo(correo)) {

            String hashedPassword = Validaciones.encriptarContra(contraseña);

            int adminId = registrarAdmin(nombre, apellido, numero); 

            if (adminId != -1) {
                resultado = registrarUsuarioAdmin(correo, hashedPassword,adminId);  
            } else {
                System.out.println("Error al registrar el cliente.");
            }

        } else {
            System.out.println("Correo o contraseña no válidos.");
        }
        return resultado;
    }
    
    private static int registrarAdmin(String nombre, String apellido, String numero) {
        String query = "INSERT INTO Personal (nombre, apellido, numero) VALUES (?, ?, ?)";
        try (Connection c = BDconexion.Conexion();
            PreparedStatement stmt = c.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, numero);  
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    private static boolean registrarUsuarioAdmin(String correo, String contraseña, int adminId) {
        String query = "INSERT INTO Usuario (correo, contraseña, id_rol, id_personal) VALUES (?, ?, ?, ?)";
        try (Connection c = BDconexion.Conexion();
            PreparedStatement stmt = c.prepareStatement(query)) {
            stmt.setString(1, correo); 
            stmt.setString(2, contraseña);  
            stmt.setInt(3, 1);
            stmt.setInt(4, adminId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void rellenarComboBox(JComboBox<String> comboBox, String []elementos) {
        for (String elemento : elementos) {
            comboBox.addItem(elemento);
        }
    }
    
    public static void eliminarAvion(int fila, DefaultTableModel modelo) {
        if (fila != -1) {
            int idAvion = (int) modelo.getValueAt(fila, 0);
            boolean eliminado = eliminarAvion2(idAvion);
            if (eliminado) {
                modelo.removeRow(fila);
                JOptionPane.showMessageDialog(null, "Avión eliminado correctamente.");
                eliminarAsientos(idAvion);
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el avión.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un avión para eliminar.");
        }
    }
    
    private static boolean eliminarAvion2(int idAvion) {
        String query = "DELETE FROM Avion WHERE id_avion = ?";
        try (Connection c = BDconexion.Conexion();
             PreparedStatement stmt = c.prepareStatement(query)) {
            stmt.setInt(1, idAvion);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void eliminarUsuario(int fila, DefaultTableModel modelo) {
        if (fila != -1) {
            int idUsuario = (int) modelo.getValueAt(fila, 0);
            boolean eliminado = eliminarUsuario2(idUsuario);
            if (eliminado) {
                modelo.removeRow(fila);
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el usuario.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un usuario para eliminar.");
        }
    }
    
    private static boolean eliminarUsuario2(int idUsuario) {
        String query = "DELETE FROM Usuario WHERE id_usuario = ?";
        try (Connection c = BDconexion.Conexion();
            PreparedStatement stmt = c.prepareStatement(query)) {
            stmt.setInt(1, idUsuario);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private static boolean eliminarAsientos(int idAvion) {
    String query = "DELETE FROM Asiento WHERE id_avion = ?";
    try (Connection c = BDconexion.Conexion();
         PreparedStatement stmt = c.prepareStatement(query)) {
        stmt.setInt(1, idAvion);
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
    public static boolean registrarAvion(String modelo, String compania) {
        String queryAvion = "INSERT INTO Avion (modelo, compania) VALUES (?, ?)";
        String queryAsiento = "INSERT INTO Asiento (estado, ID_Avion, num_Asiento) VALUES (?, ?, ?)";

        try (Connection c = BDconexion.Conexion()) {
            c.setAutoCommit(false);

            try (PreparedStatement stmtAvion = c.prepareStatement(queryAvion, Statement.RETURN_GENERATED_KEYS)) {
                stmtAvion.setString(1, modelo);
                stmtAvion.setString(2, compania);
                stmtAvion.executeUpdate();

                ResultSet rs = stmtAvion.getGeneratedKeys();
                if (rs.next()) {
                    int idAvion = rs.getInt(1);

                    
                    try (PreparedStatement stmtAsiento = c.prepareStatement(queryAsiento)) {
                        for (int i = 0; i < 10; i++) {
                            stmtAsiento.setBoolean(1, false);
                            stmtAsiento.setInt(2, idAvion);
                            stmtAsiento.setInt(3,i + 1);
                            stmtAsiento.addBatch();
                        }
                        stmtAsiento.executeBatch();
                    }
                } else {
                    c.rollback();
                    return false;
                }
            }

            c.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean registarVuelo(java.util.Date F_Salida, LocalTime H_Salida, java.util.Date F_Llegada, LocalTime H_Llegada, String origen, String destino, int id_avion) {
    String query = "INSERT INTO Vuelo (fecha_salida, hora_salida, fecha_llegada, hora_llegada, lugar_origen, lugar_destino, id_avion) VALUES (?, ?, ?, ?, ?, ?, ?)";

    // Convert LocalTime to java.sql.Time
    Time h_salida = Time.valueOf(H_Salida);
    Time h_llegada = Time.valueOf(H_Llegada);

    LocalDate salida = F_Salida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate llegada = F_Llegada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    java.sql.Date sqlFechaSalida = java.sql.Date.valueOf(salida);
    java.sql.Date sqlFechaLlegada = java.sql.Date.valueOf(llegada);

    try (Connection c = BDconexion.Conexion();
         PreparedStatement stmt = c.prepareStatement(query)) {
        stmt.setDate(1, sqlFechaSalida);
        stmt.setTime(2, h_salida);
        stmt.setDate(3, sqlFechaLlegada);
        stmt.setTime(4, h_llegada);
        stmt.setString(5, origen);
        stmt.setString(6, destino);
        stmt.setInt(7, id_avion);
        stmt.executeUpdate();
        return true;
    } catch (NullPointerException e) {
        JOptionPane.showMessageDialog(null, "Campos vacíos o no seleccionados");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
    
    public static int obtenerIdAvion(JTable tblAviones) {
        int filaSeleccionada = tblAviones.getSelectedRow();
        if (filaSeleccionada != -1) {
            return (int) tblAviones.getValueAt(filaSeleccionada, 7); 
        } 
        return 0;
    }
    
    public static int obtenerIdAvion2(JTable tblAviones) {
        int filaSeleccionada = tblAviones.getSelectedRow();
        if (filaSeleccionada != -1) {
            return (int) tblAviones.getValueAt(filaSeleccionada, 0); 
        } 
        return 0;
    }
    
    public static int obtenerIdVuelo(JTable tblVuelos) {
        int filaSeleccionada = tblVuelos.getSelectedRow();
        if (filaSeleccionada != -1) {
            return (int) tblVuelos.getValueAt(filaSeleccionada, 0); 
        } 
        return 0;
    }
    
    public static void eliminarVuelo(int fila, DefaultTableModel modelo) {
        if (fila != -1) {
            int idVuelo = (int) modelo.getValueAt(fila, 0);
            boolean eliminado = eliminarVuelo2(idVuelo);
            if (eliminado) {
                modelo.removeRow(fila);
                JOptionPane.showMessageDialog(null, "Vuelo eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el vuelo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un vuelo para eliminar.");
        }
    }
    
    private static boolean eliminarVuelo2(int idVuelo) {
        String query = "DELETE FROM Vuelo WHERE id_vuelo = ?";
        try (Connection c = BDconexion.Conexion();
            PreparedStatement stmt = c.prepareStatement(query)) {
            stmt.setInt(1, idVuelo);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean[] estadoAsientos(int id_avion) {
        List<Boolean> estadosList = new ArrayList<>();
        String query = "SELECT estado FROM Asiento WHERE id_avion = ?";
        
        try (Connection c = BDconexion.Conexion();
             PreparedStatement stmt = c.prepareStatement(query)) {
            
            stmt.setInt(1, id_avion);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    estadosList.add(rs.getBoolean("estado"));
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean[] estados = new boolean[estadosList.size()];
        for (int i = 0; i < estadosList.size(); i++) {
            estados[i] = estadosList.get(i);
        }
        
        return estados;
    }

    private static boolean verifAsientos(boolean ba) {
        return ba;
    }
    
    public static void asientoAvion(int id_avion, boolean[] asientos) {
        boolean[] estados = estadoAsientos(id_avion);

        if (estados.length == 0) {
            System.out.println("No se encontraron estados de asientos para el avión con ID " + id_avion);
        }
        for (int x = 0; x < estados.length && x < asientos.length; x++) {
            asientos[x] = verifAsientos(estados[x]);
        }
    }
    
   public static void bloquearAsiento(boolean[] a, JLabel[] asientos) {
        for (int i = 0; i < asientos.length; i++) {
            if (a[i]) {
                asientos[i].setBackground(Color.DARK_GRAY);
            }
        }
    }

    public static boolean actualizarAsiento(int id_avion, int asiento, boolean estado) {
        String query = "UPDATE Asiento SET estado = ? WHERE id_avion = ? AND num_Asiento = ?";
        try (Connection c = BDconexion.Conexion();
             PreparedStatement stmt = c.prepareStatement(query)) {
            stmt.setBoolean(1, estado); 
            stmt.setInt(2, id_avion);  
            stmt.setInt(3, asiento);  
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean actualizarAvion(int id_avion, boolean estado) {
        String query = "UPDATE Avion SET disponible = ? WHERE id_avion = ?";
        try (Connection c = BDconexion.Conexion();
             PreparedStatement stmt = c.prepareStatement(query)) {
            stmt.setBoolean(1, estado); 
            stmt.setInt(2, id_avion);   
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean registrarReserva(int cliente, int vuelo) {
        String query = "INSERT INTO Reservacion (id_cliente, id_vuelo,fecha_reservacion) VALUES (?, ?, ?)";
        LocalDate fechaActual = LocalDate.now();
        Date fechaDate = Date.valueOf(fechaActual);
        try (Connection c = BDconexion.Conexion();
            PreparedStatement stmt = c.prepareStatement(query)) {
            stmt.setInt(1, cliente); 
            stmt.setInt(2, vuelo);  
            stmt.setDate(3, fechaDate);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static int obtenerIdCliente(String correo) {
        String query = "SELECT id_cliente FROM Usuario WHERE correo = ?";
        try (Connection c = BDconexion.Conexion();
             PreparedStatement stmt = c.prepareStatement(query)) {
            stmt.setString(1, correo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_cliente");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; 
    }
     
    public static void eliminarReserva(int fila, DefaultTableModel modelo) {
        if (fila != -1) {
            int idReserva = (int) modelo.getValueAt(fila, 0);
            boolean eliminado = eliminarReserva2(idReserva);
            if (eliminado) {
                modelo.removeRow(fila);
                JOptionPane.showMessageDialog(null, "Reserva eliminado correctamente.");
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar la reserva.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una reserva para eliminar.");
        }
    }
    
    private static boolean eliminarReserva2(int idReserva) {
        String query = "DELETE FROM Reservacion WHERE id_reservacion = ?";
        try (Connection c = BDconexion.Conexion();
             PreparedStatement stmt = c.prepareStatement(query)) {
            stmt.setInt(1, idReserva);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static String[] datosVuelo(int idVuelo){
        String datos[] = new String[6];
        try (Connection c = BDconexion.Conexion()){
            String query = "SELECT fecha_salida, hora_salida, fecha_llegada, hora_llegada, lugar_origen, lugar_destino FROM vuelo WHERE id_vuelo = ?";
            try (PreparedStatement stmt = c.prepareStatement(query)) {
                stmt.setInt(1, idVuelo);
                
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        datos[0] = rs.getDate("fecha_salida").toString();
                        datos[1] = rs.getTime("hora_salida").toString();
                        datos[2] = rs.getDate("fecha_llegada").toString();
                        datos[3] = rs.getTime("hora_llegada").toString();
                        datos[4] = rs.getString("lugar_origen");
                        datos[5] = rs.getString("lugar_destino");
                    }
                } 
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return datos;
    }
    
    public static String obtenerCorreoCliente(int IDcliente) {
        String query = "SELECT correo FROM Usuario WHERE id_cliente = ?";
        try (Connection c = BDconexion.Conexion();
             PreparedStatement stmt = c.prepareStatement(query)) {
            stmt.setInt(1, IDcliente);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("correo");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }
}


