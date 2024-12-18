package controlador;

import Inicio.ControladorInicio;
import Inicio.Inicio;
import Login.VistaLogin;
import modelo.Usuario;

public class Main {

	public static void main(String[] args) {
        System.out.println("Inicio del programa"); // Debug

        Inicio inicio = new Inicio();

        
        new ControladorInicio(inicio);
        
        inicio.setVisible(true);
        
	}

}
