package vista;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Inicio extends JPanel {

	private static final long serialVersionUID = 1L;

	private Image backgroundImage;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Inicio() {
		try {
            // Carga la imagen desde el directorio de recursos
            backgroundImage = ImageIO.read(getClass().getResource("/libro.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // Dibuja la imagen ajustada al tamaño del panel
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

}
