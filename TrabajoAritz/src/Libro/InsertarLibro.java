package Libro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;

public class InsertarLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField genero;
	private JTextField autor;
	private JTextField libro;
	private JTextField anio;
	private JTextField mes;
	private JTextField dia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertarLibro frame = new InsertarLibro();
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
	public InsertarLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{32, 0, 0, 0, 0, 0, 134, 8, 0, 0};
		gbl_contentPane.rowHeights = new int[]{28, 0, 50, 22, 50, 21, 46, 19, 47, 28, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton volver = new JButton("<--");
		GridBagConstraints gbc_volver = new GridBagConstraints();
		gbc_volver.insets = new Insets(0, 0, 5, 5);
		gbc_volver.gridx = 0;
		gbc_volver.gridy = 1;
		contentPane.add(volver, gbc_volver);
		
		JLabel lblLibro = new JLabel("Libro  :");
		GridBagConstraints gbc_lblLibro = new GridBagConstraints();
		gbc_lblLibro.gridwidth = 3;
		gbc_lblLibro.insets = new Insets(0, 0, 5, 5);
		gbc_lblLibro.gridx = 1;
		gbc_lblLibro.gridy = 2;
		contentPane.add(lblLibro, gbc_lblLibro);
		
		libro = new JTextField();
		libro.setColumns(10);
		GridBagConstraints gbc_libro = new GridBagConstraints();
		gbc_libro.gridwidth = 5;
		gbc_libro.insets = new Insets(0, 0, 5, 0);
		gbc_libro.fill = GridBagConstraints.HORIZONTAL;
		gbc_libro.gridx = 4;
		gbc_libro.gridy = 2;
		contentPane.add(libro, gbc_libro);
		
		JLabel lblAutor = new JLabel("Autor  :");
		GridBagConstraints gbc_lblAutor = new GridBagConstraints();
		gbc_lblAutor.gridwidth = 3;
		gbc_lblAutor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAutor.gridx = 1;
		gbc_lblAutor.gridy = 4;
		contentPane.add(lblAutor, gbc_lblAutor);
		
		autor = new JTextField();
		autor.setColumns(10);
		GridBagConstraints gbc_autor = new GridBagConstraints();
		gbc_autor.gridwidth = 5;
		gbc_autor.insets = new Insets(0, 0, 5, 0);
		gbc_autor.fill = GridBagConstraints.HORIZONTAL;
		gbc_autor.gridx = 4;
		gbc_autor.gridy = 4;
		contentPane.add(autor, gbc_autor);
		
		JLabel lblNewLabel = new JLabel("Genero  :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 6;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		genero = new JTextField();
		genero.setColumns(10);
		GridBagConstraints gbc_genero = new GridBagConstraints();
		gbc_genero.gridwidth = 5;
		gbc_genero.insets = new Insets(0, 0, 5, 0);
		gbc_genero.fill = GridBagConstraints.HORIZONTAL;
		gbc_genero.gridx = 4;
		gbc_genero.gridy = 6;
		contentPane.add(genero, gbc_genero);
		
		JLabel lblFechaPublicacon = new JLabel("Fecha publicacon: ");
		GridBagConstraints gbc_lblFechaPublicacon = new GridBagConstraints();
		gbc_lblFechaPublicacon.gridwidth = 3;
		gbc_lblFechaPublicacon.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaPublicacon.gridx = 1;
		gbc_lblFechaPublicacon.gridy = 8;
		contentPane.add(lblFechaPublicacon, gbc_lblFechaPublicacon);
		
		anio = new JTextField();
		GridBagConstraints gbc_anio = new GridBagConstraints();
		gbc_anio.insets = new Insets(0, 0, 5, 5);
		gbc_anio.fill = GridBagConstraints.HORIZONTAL;
		gbc_anio.gridx = 4;
		gbc_anio.gridy = 8;
		contentPane.add(anio, gbc_anio);
		anio.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 5;
		gbc_lblNewLabel_1.gridy = 8;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		mes = new JTextField();
		GridBagConstraints gbc_mes = new GridBagConstraints();
		gbc_mes.insets = new Insets(0, 0, 5, 5);
		gbc_mes.fill = GridBagConstraints.HORIZONTAL;
		gbc_mes.gridx = 6;
		gbc_mes.gridy = 8;
		contentPane.add(mes, gbc_mes);
		mes.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("/");
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.gridx = 7;
		gbc_lblNewLabel_1_1.gridy = 8;
		contentPane.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		dia = new JTextField();
		GridBagConstraints gbc_dia = new GridBagConstraints();
		gbc_dia.insets = new Insets(0, 0, 5, 0);
		gbc_dia.fill = GridBagConstraints.HORIZONTAL;
		gbc_dia.gridx = 8;
		gbc_dia.gridy = 8;
		contentPane.add(dia, gbc_dia);
		dia.setColumns(10);
		
		JButton EnviarLibro = new JButton("Subir Libro");
		GridBagConstraints gbc_EnviarLibro = new GridBagConstraints();
		gbc_EnviarLibro.gridwidth = 9;
		gbc_EnviarLibro.gridx = 0;
		gbc_EnviarLibro.gridy = 9;
		contentPane.add(EnviarLibro, gbc_EnviarLibro);
	}

}