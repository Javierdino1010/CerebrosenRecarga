package Inicio;

import java.awt.Button;

import LoginRegister.VistaLogin;

public class ModeloInicio {

	private Button boton;

	public ModeloInicio() {

	}

	public Button getboton() {
		return boton;
	}

	public void recibirClase(Inicio inicio) {
		VistaLogin login = new VistaLogin();
		login.setVisible(true);
		inicio.dispose();
	}
}
