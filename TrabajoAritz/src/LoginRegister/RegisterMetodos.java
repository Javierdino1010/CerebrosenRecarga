package LoginRegister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import SQL.conexion;

public class RegisterMetodos {
	
	

	
	public static void validar(String nombre, String apellidos, String dni, String email, String telefono, String pass) {
		
		nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
		
		if(nombre.equals("") || apellidos.equals("") || dni.equals("") || email.equals("") || telefono.equals("") || pass.equals("")) {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos");
			
		}else if(!validarNombre(nombre)){
			JOptionPane.showMessageDialog(null, "Nombre invalido");
		}else if(!validarApellido(apellidos)){
			JOptionPane.showMessageDialog(null, "Apellido invalido");
		}else if(!validarDni(dni)){
			JOptionPane.showMessageDialog(null, "DNI invalido");
		}else if(!validarEmail(email)){
			JOptionPane.showMessageDialog(null, "Correo invalido");
		}else if(!validarTelefono(telefono)){
			JOptionPane.showMessageDialog(null, "Telefono invalido");
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
	
	private static boolean validarNombre(String nombre) {
		String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
		
        
        // Comprobar si el nombre cumple con la expresión regular
        return nombre != null && nombre.matches(regex);
		
	}
	
	private static boolean validarApellido(String apellido) {
		String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
		
        
        // Comprobar si el nombre cumple con la expresión regular
        return apellido != null && apellido.matches(regex);
		
	}
	
	final static Map<Integer, Character> letrasDNI = new HashMap<>();

	static {
    
    char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    for (int i = 0; i < 23; i++) {
        letrasDNI.put(i, letras[i]);
    }
}
	
	private static boolean validarDni(String dni) {
		// Comprobar que el DNI tiene 9 caracteres
        if (dni.length() != 9) {
            return false;
        }

        // Comprobar que los primeros 8 caracteres son números
        String numero = dni.substring(0, 8);
        if (!numero.matches("\\d{8}")) {
            return false;
        }

        // Comprobar que el noveno carácter es una letra
        char letra = dni.charAt(8);
        if (!Character.isLetter(letra)) {
            return false;
        }

        // Calcular el índice de la letra a partir de los primeros 8 dígitos
        int numeroDNI = Integer.parseInt(numero);
        int indice = numeroDNI % 23;

        // Comparar la letra calculada con la letra del DNI
        char letraCorrecta = letrasDNI.get(indice);
        return Character.toUpperCase(letra) == letraCorrecta;
    }
	
	private static boolean validarEmail(String email) {
        // Expresión regular para validar el formato del correo
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
		
	}
	
	private static boolean validarTelefono(String telefono) {
        // Expresión regular para el formato de teléfono internacional
        String regex = "^\\+?[1-9]\\d{1,14}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telefono);
        return matcher.matches();
        		
	}
}