package usuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ControladorUsuarios {

	private VistaGestionUsuarios gestionUsuarios;
	private VistaModificarUsuario modificarUsuario;
	private VistaPerfil perfil;
	
	public ControladorUsuarios(VistaGestionUsuarios gestionUsuarios, VistaModificarUsuario modificarUsuario, VistaPerfil perfil) {
		this.gestionUsuarios = gestionUsuarios;
		this.modificarUsuario = modificarUsuario;
		this.perfil = perfil;
		
		this.gestionUsuarios.ModificarUsuarios(new ModificarUsuariosListener());
		this.gestionUsuarios.EliminarUsuarios(new EliminarUsuariosListener());
		this.gestionUsuarios.Volver(new VolverListener());
	}
	
	class ModificarUsuariosListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
        }
    }
	
	class EliminarUsuariosListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
        }
    }
	
	class VolverListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
