package Libro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
			
			if(idLibro == -1) {
				JOptionPane.showMessageDialog(null, "Elige un libro para reservar");
			}else {
				Libros libro = new Libros();
				libro.Reservar(idLibro);
			}
			
			
		}
	}
	
	

}
