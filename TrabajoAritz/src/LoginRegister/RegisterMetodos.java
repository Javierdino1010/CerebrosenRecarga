package LoginRegister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import SQL.conexion;

public class RegisterMetodos {

	
	public static void validar(String nombre, String apellidos, String dni, String email, String telefono, String pass) {
		
		if(nombre.equals("") || apellidos.equals("") || dni.equals("") || email.equals("") || telefono.equals("") || pass.equals("")) {
			System.out.println("Los campos no estan correctos");
			
		}else {
			try {
				insertarUsuario(nombre, apellidos, dni, email, telefono, pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void insertarUsuario(String nombre, String apellidos, String dni, String email, String telefono, String pass) throws SQLException {
		
        conexion db = new conexion();
        Connection conn = db.connectToDB();
        
        String sql = "INSERT INTO usuarios (DNI, nombre, apellidos, email, pass, telefono, rol) VALUES (?,?,?,?,?,?,?)";
        
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, dni);
        preparedStatement.setString(2, nombre);
        preparedStatement.setString(3, apellidos);
        preparedStatement.setString(4, email);
        preparedStatement.setString(5, pass);
        preparedStatement.setString(6, telefono);
        preparedStatement.setString(7, "Usuario estándar");
        
        preparedStatement.executeUpdate();
	}
}