package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class FormNuevoLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textTitulo;
	private JTextField textAutor;
	private JTextField textGenero;
	private JTextField textField_4;
	private JTextField textFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormNuevoLibro frame = new FormNuevoLibro();
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
	public FormNuevoLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{85, 81, 35, 155, 0, 0};
		gbl_contentPane.rowHeights = new int[]{21, 35, 19, 35, 19, 35, 19, 35, 21, 35, 13, 35, 21, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnVolver = new JButton("Volver");
		GridBagConstraints gbc_btnVolver = new GridBagConstraints();
		gbc_btnVolver.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnVolver.insets = new Insets(0, 0, 5, 5);
		gbc_btnVolver.gridx = 0;
		gbc_btnVolver.gridy = 0;
		contentPane.add(btnVolver, gbc_btnVolver);
		
		JLabel lblTitulo = new JLabel("Titulo");
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridx = 1;
		gbc_lblTitulo.gridy = 2;
		contentPane.add(lblTitulo, gbc_lblTitulo);
		
		textTitulo = new JTextField();
		GridBagConstraints gbc_textTitulo = new GridBagConstraints();
		gbc_textTitulo.anchor = GridBagConstraints.NORTH;
		gbc_textTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_textTitulo.gridx = 3;
		gbc_textTitulo.gridy = 2;
		contentPane.add(textTitulo, gbc_textTitulo);
		textTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		GridBagConstraints gbc_lblAutor = new GridBagConstraints();
		gbc_lblAutor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAutor.gridx = 1;
		gbc_lblAutor.gridy = 4;
		contentPane.add(lblAutor, gbc_lblAutor);
		
		textAutor = new JTextField();
		GridBagConstraints gbc_textAutor = new GridBagConstraints();
		gbc_textAutor.anchor = GridBagConstraints.NORTH;
		gbc_textAutor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAutor.insets = new Insets(0, 0, 5, 5);
		gbc_textAutor.gridx = 3;
		gbc_textAutor.gridy = 4;
		contentPane.add(textAutor, gbc_textAutor);
		textAutor.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero");
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 1;
		gbc_lblGenero.gridy = 6;
		contentPane.add(lblGenero, gbc_lblGenero);
		
		textGenero = new JTextField();
		GridBagConstraints gbc_textGenero = new GridBagConstraints();
		gbc_textGenero.anchor = GridBagConstraints.NORTH;
		gbc_textGenero.fill = GridBagConstraints.HORIZONTAL;
		gbc_textGenero.insets = new Insets(0, 0, 5, 5);
		gbc_textGenero.gridx = 3;
		gbc_textGenero.gridy = 6;
		contentPane.add(textGenero, gbc_textGenero);
		textGenero.setColumns(10);
		
		JCheckBox chckbxDisponible = new JCheckBox("Disponible");
		GridBagConstraints gbc_chckbxDisponible = new GridBagConstraints();
		gbc_chckbxDisponible.anchor = GridBagConstraints.NORTH;
		gbc_chckbxDisponible.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxDisponible.gridx = 3;
		gbc_chckbxDisponible.gridy = 8;
		contentPane.add(chckbxDisponible, gbc_chckbxDisponible);
		
		JLabel lblFecha = new JLabel("Fecha publicacion");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 10;
		contentPane.add(lblFecha, gbc_lblFecha);
		
		textFecha = new JTextField();
		GridBagConstraints gbc_textFecha = new GridBagConstraints();
		gbc_textFecha.insets = new Insets(0, 0, 5, 5);
		gbc_textFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFecha.gridx = 3;
		gbc_textFecha.gridy = 10;
		contentPane.add(textFecha, gbc_textFecha);
		textFecha.setColumns(10);
		
		
		
		JButton btnAdd = new JButton("Añadir libro");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.anchor = GridBagConstraints.NORTH;
		gbc_btnAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAdd.gridwidth = 3;
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 12;
		contentPane.add(btnAdd, gbc_btnAdd);
		
	}

}
