package Libro;

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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LibrosScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;


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
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		GridBagConstraints gbc_btnVolver = new GridBagConstraints();
		gbc_btnVolver.fill = GridBagConstraints.BOTH;
		gbc_btnVolver.insets = new Insets(0, 0, 5, 5);
		gbc_btnVolver.gridx = 1;
		gbc_btnVolver.gridy = 0;
		contentPane.add(btnVolver, gbc_btnVolver);
		
		
		//Solo visible si el usuario es Admin
		JButton btnAnadir = new JButton("Nuevo Libro");
		btnAnadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		GridBagConstraints gbc_btnAnadir = new GridBagConstraints();
		gbc_btnAnadir.fill = GridBagConstraints.BOTH;
		gbc_btnAnadir.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnadir.gridx = 6;
		gbc_btnAnadir.gridy = 0;
		contentPane.add(btnAnadir, gbc_btnAnadir);
		
		JButton btnModificar = new JButton("Modificar libro");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 6;
		gbc_btnModificar.gridy = 1;
		contentPane.add(btnModificar, gbc_btnModificar);
		
		//Solo puede ser pulsado si hay algo seleccionado en el jList
		JButton btnReservar = new JButton("Reservar");
		btnReservar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		GridBagConstraints gbc_btnReservar = new GridBagConstraints();
		gbc_btnReservar.fill = GridBagConstraints.BOTH;
		gbc_btnReservar.insets = new Insets(0, 0, 5, 5);
		gbc_btnReservar.gridx = 1;
		gbc_btnReservar.gridy = 2;
		contentPane.add(btnReservar, gbc_btnReservar);
		
		JButton btnBorrar = new JButton("Eliminar libro");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorrar.gridx = 6;
		gbc_btnBorrar.gridy = 2;
		contentPane.add(btnBorrar, gbc_btnBorrar);
		
		
		//El label será sustituido por Libro reservado || Fecha reserva  || fecha devolucion cuando haya selecionado algo del jList xd
		JLabel lblNewLabel = new JLabel("Libro reservado || Fecha reserva  || fecha devolucion");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.gridwidth = 6;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Código", "Titulo", "Autor", "Categoría", "Disponibilidad", "Fecha de publicación"
			}
		));
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 6;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 4;
		contentPane.add(table, gbc_table);
	}

}
