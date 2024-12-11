package controlador;

import modelo.Usuario;
import vista.Inicio;
import vista.Login;

public class Main {

	public static void main(String[] args) {
        System.out.println("Inicio del programa"); // Debug

        Inicio inicio = new Inicio();
        Usuario usuario = new Usuario();

        new Controlador(inicio, usuario);

        inicio.setVisible(true);

	}

}
