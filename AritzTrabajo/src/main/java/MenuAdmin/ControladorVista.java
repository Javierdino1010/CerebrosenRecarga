package MenuAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Libro.Controlador;
import Libro.LibrosScreen;
import Libro.LibrosScreenUsuario;
import usuarios.ControladorUsuarios;
import usuarios.VistaGestionUsuarios;
import usuarios.VistaModificarUsuario;
import usuarios.VistaPerfil;

public class ControladorVista {
    
    private Vista vista;

    public ControladorVista(Vista vista) {
    	
        this.vista = vista;
        
        vista.agregarListenerUsuarios(new UsuariosListener());
        vista.agregarListenerLibros(new LibrosListener());
        vista.agregarListenerReporte(new ReporteListener());
    }

    class UsuariosListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	  vista.dispose(); // Cierra el menú principal
              VistaGestionUsuarios gestionUsuarios = new VistaGestionUsuarios();
              new ControladorUsuarios(gestionUsuarios, new VistaModificarUsuario(), new VistaPerfil());
              gestionUsuarios.setVisible(true);
        }
    }

    class LibrosListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            vista.dispose(); // Cierra la ventana actual
            LibrosScreen librosScreen = new LibrosScreen();
            LibrosScreenUsuario librosScreenUsuario = new LibrosScreenUsuario();
            new Controlador(librosScreenUsuario, librosScreen);
            librosScreen.setVisible(true); // Abre la pantalla de libros
        }
    }

    class ReporteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String informeSeleccionado = vista.getComboBox();
            GenerarInformes generarInformes = new GenerarInformes();
            generarInformes.exportarLibro(informeSeleccionado);
        }
    }

    
}

