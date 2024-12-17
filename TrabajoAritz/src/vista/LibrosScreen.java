package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JList;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JLabel;

public class LibrosScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrosScreen frame = new LibrosScreen();
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
	public LibrosScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnVolver = new JButton("Volver");
		GridBagConstraints gbc_btnVolver = new GridBagConstraints();
		gbc_btnVolver.fill = GridBagConstraints.BOTH;
		gbc_btnVolver.insets = new Insets(0, 0, 5, 5);
		gbc_btnVolver.gridx = 1;
		gbc_btnVolver.gridy = 0;
		contentPane.add(btnVolver, gbc_btnVolver);
		
		
		//Solo visible si el usuario es Admin
		JButton btnAnadir = new JButton("Nuevo Libro");
		GridBagConstraints gbc_btnAnadir = new GridBagConstraints();
		gbc_btnAnadir.fill = GridBagConstraints.BOTH;
		gbc_btnAnadir.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnadir.gridx = 6;
		gbc_btnAnadir.gridy = 0;
		contentPane.add(btnAnadir, gbc_btnAnadir);
		
		//Solo puede ser pulsado si hay algo seleccionado en el jList
		JButton btnReservar = new JButton("Reservar");
		GridBagConstraints gbc_btnReservar = new GridBagConstraints();
		gbc_btnReservar.fill = GridBagConstraints.BOTH;
		gbc_btnReservar.insets = new Insets(0, 0, 5, 5);
		gbc_btnReservar.gridx = 1;
		gbc_btnReservar.gridy = 2;
		contentPane.add(btnReservar, gbc_btnReservar);
		
		
		//El label será sustituido por Libro reservado || Fecha reserva  || fecha devolucion cuando haya selecionado algo del jList xd
		JLabel lblNewLabel = new JLabel("Libro reservado || Fecha reserva  || fecha devolucion");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.gridwidth = 6;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JList listaLibros = new JList();
		GridBagConstraints gbc_listaLibros = new GridBagConstraints();
		gbc_listaLibros.insets = new Insets(0, 0, 0, 5);
		gbc_listaLibros.gridwidth = 6;
		gbc_listaLibros.fill = GridBagConstraints.BOTH;
		gbc_listaLibros.gridx = 1;
		gbc_listaLibros.gridy = 4;
		contentPane.add(listaLibros, gbc_listaLibros);
	}

}
