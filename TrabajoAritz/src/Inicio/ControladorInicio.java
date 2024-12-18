package Inicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import LoginRegister.VistaLogin;

public class ControladorInicio {

	private Inicio inicio;
	private ModeloInicio modeloInicio;

	public ControladorInicio(Inicio inicio, ModeloInicio modeloInicio) {

		this.inicio = inicio;
		this.modeloInicio = modeloInicio;

		inicio.agregarListenerInicio(new aniadirListener());
	}

	class aniadirListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			ModeloInicio modeloInicio = new ModeloInicio();
			modeloInicio.recibirClase(inicio);

		}

	}
}
