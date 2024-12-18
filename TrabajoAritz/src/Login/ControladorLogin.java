package Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Inicio.Inicio;
import modelo.Usuario;

public class ControladorLogin {
	
	private Inicio inicio;
	private Usuario usuario;
	private VistaLogin login;

	public ControladorLogin(Inicio inicio, Usuario usuario, VistaLogin login) {
		this.inicio = inicio;
		this.usuario = usuario;
		this.login = login;
		
		login.agregarListenerLogin(new aniadirListener());
		
		
	}
	class aniadirListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String usuario = login.getUsuarioIngresada();
			String pass = login.getPassIngresada();
			
			LoginMetodos.validar(usuario, pass);
			}
		}
	
	
	
	
}
