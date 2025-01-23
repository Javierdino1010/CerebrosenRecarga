package MenuAdmin;

import usuarios.ControladorUsuarios;
import usuarios.VistaGestionUsuarios;
import usuarios.VistaModificarUsuario;
import usuarios.VistaPerfil;

public class GestionAdmin {
	
	
	public static void cambiarVentana() {
		
		VistaGestionUsuarios vistaGestionUsuarios = new VistaGestionUsuarios();
        new ControladorUsuarios(vistaGestionUsuarios, new VistaModificarUsuario(), new VistaPerfil());
        
        VistaModificarUsuario vistaModificarUsuario = new VistaModificarUsuario();
        VistaPerfil vistaPerfil = new VistaPerfil();

        new ControladorUsuarios(vistaGestionUsuarios, vistaModificarUsuario, vistaPerfil);

        
        vistaGestionUsuarios.setVisible(true);
	}
}
