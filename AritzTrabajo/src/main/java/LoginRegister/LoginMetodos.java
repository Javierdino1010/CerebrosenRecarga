package LoginRegister;

import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Libro.Controlador;
import Libro.LibrosScreen;
import Libro.LibrosScreenUsuario;
import MenuAdmin.ControladorVista;
import MenuAdmin.Vista;
import SQL.conexion;
import modelo.Usuario;

public class LoginMetodos {
	

	public static void validar(String nombre, String pass, Window login) {
		

		//Comprobar si los campos estan vacios
		if(nombre.equals("") || pass.equals("")) {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos");
			
		}else {
			nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
			comprobarUsuario(nombre, pass, login);				
			
		}
		
	}
	
	public static void comprobarUsuario(String nombre, String pass, Window login) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		List<Usuario> usuario = session.createQuery("FROM Usuario", Usuario.class).list();
		
		for (Usuario usu : usuario) {
			if(usu.getNombre().equals(nombre) && usu.getPass().equals(pass)) {
				String rol = usu.getRol();
				int id = usu.getID();
				System.out.println("este es el id: " + id);
				if(rol.equals("Administrador")) {
            		/*Libro.LibrosScreen catalogoVista = new LibrosScreen();
            		catalogoVista.setVisible(true);*/
					
	           	    usu.setLogin(true);
	           	    session.update(usu);
	           	    
	           	    session.getTransaction().commit();
	           	    session.close();
					
					Vista vista = new Vista();
					new ControladorVista(vista);
					vista.setVisible(true);
            		login.dispose();
            		
            	}else if(rol.equals("Usuario")) {
            		
          		LibrosScreenUsuario librosScreenUsuario = new LibrosScreenUsuario();
          		LibrosScreen librosScreen = new LibrosScreen();
           	    new Controlador(librosScreenUsuario, librosScreen);
           	    
           	    usu.setLogin(true);
           	    session.update(usu);
           	    
           	    session.getTransaction().commit();
           	    session.close();

            	
           		librosScreenUsuario.setVisible(true);
            		login.dispose();
            	}else {
            		JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            	}
			}
			
		}
		
//        conexion db = new conexion();
//        Connection conn = db.connectToDB();
//		
//		String query = "SELECT * FROM usuarios WHERE nombre = ? AND pass = ?";
//
//        try (PreparedStatement stmt = conn.prepareStatement(query)) {
//            
//            // Establecer los valores para los parámetros de la consulta (usamos ?)
//            stmt.setString(1, nombre);
//            stmt.setString(2, pass);
//
//            // Ejecutar la consulta
//            try (ResultSet rs = stmt.executeQuery()) {
//                // Si el resultado tiene al menos una fila, significa que el usuario está registrado
//                if (rs.next()) {
//                	String rol = rs.getString("rol");
//                	//Mostrar un ventana dependiendo de que rol tiene el usuario
//                	if(rol.equals("Administrador")) {
//                		Libro.LibrosScreen catalogoVista = new LibrosScreen();
//                		catalogoVista.setVisible(true);
//                		login.dispose();
//                	}else if(rol.equals("Usuario estándar")) {
//                		System.out.println("hola");
//                		Libro.LibrosScreenUsuario catalogoVistaUsuario = new LibrosScreenUsuario();
//                		catalogoVistaUsuario.setVisible(true);
//                		login.dispose();
//                	}else {
//                		JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
//                	}
//                	
//
//                }
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        
    }
	
}
