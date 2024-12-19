package LoginRegister;

import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Libro.LibrosScreen;
import SQL.conexion;

public class LoginMetodos {

	public static void validar(String nombre, String pass, Window login) {
		

		
		if(nombre.equals("") || pass.equals("")) {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos");
			
		}else {
			boolean esValido = comprobarUsuario(nombre, pass);
			if(esValido) {
				Libro.LibrosScreen librosScreen = new LibrosScreen();
				librosScreen.setVisible(true);
				login.dispose();
				
				
			}
		}
		
	}
	
	public static boolean comprobarUsuario(String nombre, String pass) {
		
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
                    return true;  // El usuario y la contraseña son correctos
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;  // Usuario o contraseña incorrectos
    }
	
}
