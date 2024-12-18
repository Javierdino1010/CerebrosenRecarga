package Inicio;

import java.awt.Button;

import LoginRegister.ControladorLogin;
import LoginRegister.LoginMetodos;
import LoginRegister.RegisterMetodos;
import LoginRegister.VistaLogin;
import LoginRegister.VistaRegister;

public class ModeloInicio {

	private Button boton;

	public ModeloInicio() {

	}

	public Button getboton() {
		return boton;
	}

	public void recibirClase(Inicio inicio) {
		VistaLogin login = new VistaLogin();
		VistaRegister register = new VistaRegister();
		LoginMetodos loginMetodos = new LoginMetodos();
		RegisterMetodos registerMetodos = new RegisterMetodos();
		new ControladorLogin(login, register, loginMetodos, registerMetodos);
		login.setVisible(true);
		inicio.dispose();
	}
}
