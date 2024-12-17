package vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImagen extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelImagen() {
		this.setSize(400, 280);
	}

	public void paintComponent(Graphics g) {
		Dimension tamaño = getSize();
		ImageIcon imageFondo = new ImageIcon(getClass().getResource("/Imagenes/recepcion.jpg"));
		g.drawImage(imageFondo.getImage(), 0, 0, tamaño.width, tamaño.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}

}