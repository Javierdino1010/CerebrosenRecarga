package modelo;

import java.awt.Button;

import vista.Inicio;
import vista.Login;

public class ModeloInicio {
	
	private Button boton;
	
	public ModeloInicio() {
		
	}
	
	public Button getboton() {
		return boton;
	}
	
	public void recibirClase(Inicio inicio) {
		Login login = new Login();
		login.setVisible(true);
		inicio.dispose();
	}
}
