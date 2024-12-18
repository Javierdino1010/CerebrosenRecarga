package LoginRegister;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorLogin {
	

	private VistaLogin login;
	private VistaRegister register;

	public ControladorLogin(VistaLogin login, VistaRegister register) {
		this.login = login;
		this.register = register;
		
		login.agregarListenerLogin(new aniadirLoginListener());
		register.agregarListenerRegister(new aniadirRegistarListener());
		
	}
	class aniadirLoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String usuario = login.getUsuarioIngresada();
			String pass = login.getPassIngresada();
			
			LoginMetodos.validar(usuario, pass, login);

			}
		}
	
	class aniadirRegistarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			String nombre = register.getNombre();
			String apellidos = register.getApellidos();
			String dni = register.getDni();
			String email = register.getEmail();
			String telefono = register.getTelefono();
			String pass = register.getPass();
			
			RegisterMetodos.validar(nombre, apellidos, dni, email, telefono, pass);
			
			}
		}
	
	
}
