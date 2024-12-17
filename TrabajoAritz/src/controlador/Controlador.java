package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.LoginMetodos;
import modelo.Usuario;
import vista.Inicio;
import vista.Login;

public class Controlador {
	
	private Inicio inicio;
	private Usuario usuario;
	private Login login;

	public Controlador(Inicio inicio, Usuario usuario, Login login) {
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
