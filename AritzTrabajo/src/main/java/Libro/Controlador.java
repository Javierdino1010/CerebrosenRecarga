package Libro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controlador {
	
	private LibrosScreenUsuario librosScreenUsuario;
	ArrayList <Libros> librosArray = new ArrayList<>();

	public Controlador(LibrosScreenUsuario librosScreenUsuario) {
		this.librosScreenUsuario = librosScreenUsuario;
		this.librosScreenUsuario.agregarListenerPrueba(new aniadirListenerPrueba());
	}
	
	class aniadirListenerPrueba implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			librosArray = MetodosLibros.recuperarLibrosBD();
			librosScreenUsuario.agregarEnLista(librosArray);
		}
	}
	
	

}
