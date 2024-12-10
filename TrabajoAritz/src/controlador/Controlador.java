package controlador;

import modelo.Usuario;
import vista.Login;

public class Controlador {
	
	private Login login;
	private Usuario usuario;

	public Controlador(Login login, Usuario usuario) {
		this.login = login;
		this.usuario = usuario;
	}
}
