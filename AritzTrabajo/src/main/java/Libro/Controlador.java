package Libro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import MenuAdmin.ControladorVista;
import MenuAdmin.Vista;

public class Controlador {
	
	private LibrosScreenUsuario librosScreenUsuario;
	private LibrosScreen librosScreen;

	public Controlador(LibrosScreenUsuario librosScreenUsuario, LibrosScreen librosScreen) {
		this.librosScreenUsuario = librosScreenUsuario;
		this.librosScreen = librosScreen;
		
		librosScreenUsuario.agregarListenerReservar(new aniadirListenerReserva());
		librosScreen.agregarListenerVolver(new aniadirListenerVolver());
	}
	
	class aniadirListenerReserva implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			int idLibro = librosScreenUsuario.obtenerIdFilaSeleccionada();
			
			if(idLibro == -1) {
				JOptionPane.showMessageDialog(null, "Elige un libro para reservar");
			}else {
				Libros libro = new Libros();
				libro.Reservar(idLibro);
				librosScreenUsuario.cargarLibros(null);
			}
			
			
		}
	}
	
	class aniadirListenerVolver implements ActionListener {
		public void actionPerformed(ActionEvent e) {
	        Vista menuPrincipal = new Vista();
	        new ControladorVista(menuPrincipal);
	        menuPrincipal.setVisible(true);
	        librosScreen.dispose();
			}
		}
	
	

}
