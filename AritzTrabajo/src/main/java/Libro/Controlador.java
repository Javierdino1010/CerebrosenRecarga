package Libro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Controlador {
	
	private LibrosScreenUsuario librosScreenUsuario;

	public Controlador(LibrosScreenUsuario librosScreenUsuario) {
		this.librosScreenUsuario = librosScreenUsuario;
		
		librosScreenUsuario.agregarListenerReservar(new aniadirListenerReserva());
	}
	
	class aniadirListenerReserva implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			int idLibro = librosScreenUsuario.obtenerIdFilaSeleccionada();
			
			Libros libro = new Libros();
			libro.Reservar(idLibro);
		}
	}
	
	

}
