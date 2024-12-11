package controlador;

import modelo.Usuario;
import vista.Login;

public class Main {

	public static void main(String[] args) {
        System.out.println("Inicio del programa"); // Debug

        Login login = new Login();
        Usuario usuario = new Usuario();

        new Controlador(login, usuario);

        login.setVisible(true);

	}

}
