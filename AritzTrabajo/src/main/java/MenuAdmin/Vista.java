package MenuAdmin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnUsuarios;
	private JButton btnLibros;
	private JButton btnReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		btnUsuarios = new JButton("GESTIONAR USUARIOS");
		GridBagConstraints gbc_btnUsuarios = new GridBagConstraints();
		gbc_btnUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_btnUsuarios.gridx = 2;
		gbc_btnUsuarios.gridy = 2;
		contentPane.add(btnUsuarios, gbc_btnUsuarios);
		
		btnLibros = new JButton("GESTIONAR LIBROS");
		GridBagConstraints gbc_btnLibros = new GridBagConstraints();
		gbc_btnLibros.insets = new Insets(0, 0, 5, 5);
		gbc_btnLibros.gridx = 2;
		gbc_btnLibros.gridy = 3;
		contentPane.add(btnLibros, gbc_btnLibros);
		
		btnReporte = new JButton("GENERAR REPORTE");
		GridBagConstraints gbc_btnReporte = new GridBagConstraints();
		gbc_btnReporte.insets = new Insets(0, 0, 5, 5);
		gbc_btnReporte.gridx = 2;
		gbc_btnReporte.gridy = 4;
		contentPane.add(btnReporte, gbc_btnReporte);
	}
	
	 //Agregar actionListener a los botones
		public void agregarListenerUsuarios(ActionListener listenForUsuarioButton) {
			btnUsuarios.addActionListener(listenForUsuarioButton);
			
		}
		
		public void agregarListenerLibros(ActionListener listenForLibroButton) {
			
			btnLibros.addActionListener(listenForLibroButton);
		}
		
		public void agregarListenerReporte(ActionListener listenForReporteButton) {
			
			btnReporte.addActionListener(listenForReporteButton);
		}

}
