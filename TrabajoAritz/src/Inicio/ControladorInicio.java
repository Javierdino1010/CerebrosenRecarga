package Inicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import LoginRegister.VistaLogin;

public class ControladorInicio {

	private Inicio inicio;

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
