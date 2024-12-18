package controlador;

import Inicio.ControladorInicio;
import Inicio.Inicio;
import Inicio.ModeloInicio;
import LoginRegister.ControladorLogin;
import LoginRegister.VistaLogin;
import LoginRegister.VistaRegister;
import modelo.Usuario;

public class Main {

	public static void main(String[] args) {
        System.out.println("Inicio del programa"); // Debug

        Inicio inicio = new Inicio();
        ModeloInicio modeloInicio = new ModeloInicio();
//		VistaLogin vistaLogin = new VistaLogin();
//		VistaRegister register = new VistaRegister();
//
//      new ControladorLogin(vistaLogin, register);

        
        new ControladorInicio(inicio, modeloInicio);
        
        inicio.setVisible(true);
        
	}

}
