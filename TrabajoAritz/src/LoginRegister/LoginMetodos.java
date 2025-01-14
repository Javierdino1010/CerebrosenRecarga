package LoginRegister;

import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Libro.LibrosScreen;
import Libro.LibrosScreenUsuario;
import SQL.conexion;

public class LoginMetodos {
	

	public static void validar(String nombre, String pass, Window login) {
		

		//Comprobar si los campos estan vacios
		if(nombre.equals("") || pass.equals("")) {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos");
			
		}else {
			comprobarUsuario(nombre, pass, login);				
			
		}
		
	}
	
	public static void comprobarUsuario(String nombre, String pass, Window login) {
		
        conexion db = new conexion();
        Connection conn = db.connectToDB();
		
		String query = "SELECT * FROM usuarios WHERE nombre = ? AND pass = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            
            // Establecer los valores para los parámetros de la consulta (usamos ?)
            stmt.setString(1, nombre);
            stmt.setString(2, pass);
 
            // Ejecutar la consulta
            try (ResultSet rs = stmt.executeQuery()) {
                // Si el resultado tiene al menos una fila, significa que el usuario está registrado
                if (rs.next()) {
                	String rol = rs.getString("rol");
                	//Mostrar un ventana dependiendo de que rol tiene el usuario
                	if(rol.equals("Administrador")) {
                		Libro.LibrosScreen catalogoVista = new LibrosScreen();
                		catalogoVista.setVisible(true);
                		login.dispose();
                	}else if(rol.equals("Usuario estándar")) {
                		System.out.println("hola");
                		Libro.LibrosScreenUsuario catalogoVistaUsuario = new LibrosScreenUsuario();
                		catalogoVistaUsuario.setVisible(true);
                		login.dispose();
                	}else {
                		JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                	}
                	

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
	
}
