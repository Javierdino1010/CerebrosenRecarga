package LoginRegister;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
			
			String usuario = login.getUsuarioIngresada();
			String pass = login.getPassIngresada();
			
			LoginMetodos.validar(usuario, pass, login);

			}
		}
	
	class aniadirIrRegistroListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				register.setVisible(true);
				login.dispose();
			}
		}
	
	class aniadirIrInicioListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
				register.dispose();
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
