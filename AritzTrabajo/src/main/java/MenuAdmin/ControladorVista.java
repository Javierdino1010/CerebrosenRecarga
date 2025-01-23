package MenuAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Libro.LibrosScreen;

public class ControladorVista {
    
    private Vista vista;

    public ControladorVista(Vista vista) {
        this.vista = vista;
        this.vista.agregarListenerUsuarios(new UsuariosListener());
        this.vista.agregarListenerLibros(new LibrosListener());
        this.vista.agregarListenerReporte(new ReporteListener());
    }

    class UsuariosListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Acción para gestionar usuarios (Pendiente implementación)
            System.out.println("Ir a Gestión de Usuarios");
        }
    }

    class LibrosListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            vista.dispose(); // Cierra la ventana actual
            new LibrosScreen().setVisible(true); // Abre la pantalla de libros
        }
    }

    class ReporteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Acción para generar reporte (Pendiente implementación)
            System.out.println("Generar Reporte");
        }
    }

    
}

