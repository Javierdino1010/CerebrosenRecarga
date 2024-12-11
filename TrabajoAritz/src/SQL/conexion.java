package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

	public void connectToDB() {
		
		  String url = "jdbc:mysql://localhost:3306/Biblioteca"; // Cambia "Biblioteca" por el nombre de tu base de datos
	        String usuario = "root"; // Cambia "root" por tu usuario
	        String contraseña = "root"; // Cambia por tu contraseña

	        try {
	            // Cargar el driver de MySQL
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Establecer la conexión
	            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

	            System.out.println("Conexión exitosa a la base de datos!");

	            // Cierra la conexión
	            conexion.close();

	        } catch (ClassNotFoundException e) {
	            System.out.println("Error al cargar el driver de MySQL: " + e.getMessage());
	        } catch (SQLException e) {
	            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
	        }
		
	}

}
