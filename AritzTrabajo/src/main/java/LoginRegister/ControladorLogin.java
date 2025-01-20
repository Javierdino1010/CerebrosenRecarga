package LoginRegister;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Libro.Controlador;
import Libro.LibrosScreenUsuario;


public class ControladorLogin {
	

	private VistaLogin login;
	private VistaRegister register;
	private LoginMetodos loginMetodos;
	private RegisterMetodos registerMetodos;

	public ControladorLogin(VistaLogin login, VistaRegister register, LoginMetodos loginMetodos, RegisterMetodos registerMetodos) {
		this.login = login;
		this.register = register;
		this.loginMetodos = loginMetodos;
		this.registerMetodos = registerMetodos;
		
		login.agregarListenerLogin(new aniadirLoginListener());
		login.agregarListenerIrRegistro(new aniadirIrRegistroListener());
		register.agregarListenerRegister(new aniadirRegistarListener());
		register.agregarListenerIrInicio(new aniadirIrInicioListener());
		
	}
	
	class aniadirLoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// Recupera el nombre de usuario y la contraseña ingresados en la interfaz de usuario
			String usuario = login.getUsuarioIngresada();
			String pass = login.getPassIngresada();
			
			// Llamada al método
			LoginMetodos.validar(usuario, pass, login);
			}
		}
	
	//Hace visible la vetana register y cierra el login
	class aniadirIrRegistroListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				register.setVisible(true);
				login.dispose();
			}
		}
	//Hace visible el login y cierra el register
	class aniadirIrInicioListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
				register.dispose();
			}
		}
	
	class aniadirRegistarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// Recupera los valores de los campos del formulario de registro
			String nombre = register.getNombre();
			String apellidos = register.getApellidos();
			String dni = register.getDni();
			String email = register.getEmail();
			String telefono = register.getTelefono();
			String pass = register.getPass();
			
			// Llamada al método
			RegisterMetodos.validar(nombre, apellidos, dni, email, telefono, pass);
						
			}
		}
	
	
}
