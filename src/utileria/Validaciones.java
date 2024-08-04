/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utileria;

import java.util.regex.*;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author kp728
 */
public class Validaciones {
    static Matcher match;
    static Pattern patron;
    
    public static boolean validarCorreo(String correo){
        String validos = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@(gmail.com|yahoo.com|outlook.com|hotmail.com)$";
        patron = Pattern.compile(validos);
        match = patron.matcher(correo);
        
        return match.matches();
    }
    
    public static boolean validarCorreoEmpleado(String correo){
        String validos = "^[a-zA-Z0-9]+(aemex)+@(hotmail.com)$";
        patron = Pattern.compile(validos);
        match = patron.matcher(correo);
        
        return match.matches();
    }
    
    public boolean validarLetras(String r){
        String validos = "^[a-zA-ZáéíóúÁÉÍÓÚ]$";
        patron = Pattern.compile(validos);
        match = patron.matcher(r);
        
        return match.matches();
    }
            
    public boolean validarNumero(int num){
        return Integer.toString(num).length() >= 10;
    }
    
    public static boolean validarContraseña(String con){
        String validos = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=]).{8}$";
        patron = Pattern.compile(validos);
        match = patron.matcher(con);
        
        return match.matches();
    }
    
    public static String encriptarContra(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean comprobarContra(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
