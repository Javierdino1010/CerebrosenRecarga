package controlador;

import modelo.Usuario;
import vista.Inicio;
import vista.Login;

public class Controlador {
	
	private Inicio inicio;
	private Usuario usuario;

	public Controlador(Inicio inicio, Usuario usuario) {
		this.inicio = inicio;
		this.usuario = usuario;
	}
}
