package catalogo;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CatalogoVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public CatalogoVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 564);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
