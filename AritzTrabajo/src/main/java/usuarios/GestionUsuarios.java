package usuarios;

public class GestionUsuarios {
	
	public static void abrirGestionUsuarios() {
		
        VistaGestionUsuarios vistaGestionUsuarios = new VistaGestionUsuarios();
        new ControladorUsuarios(vistaGestionUsuarios, new VistaModificarUsuario(), new VistaPerfil());
        vistaGestionUsuarios.setVisible(true);
    }
}
