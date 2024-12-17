package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.Controlador.aniadirListener;
import modelo.ModeloInicio;
import vista.Inicio;
import vista.Login;

public class ControladorInicio {
	
	private Inicio inicio;
	private Login login;

	public ControladorInicio(Inicio inicio) {
		
		this.inicio = inicio;
		
		inicio.agregarListenerInicio(new aniadirListener());
	}
	
	class aniadirListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			ModeloInicio modeloInicio = new ModeloInicio();
			modeloInicio.recibirClase(inicio);
			
		}
	
	}
}

