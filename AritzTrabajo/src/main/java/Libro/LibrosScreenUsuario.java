package Libro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LibrosScreenUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnListarLibros;
	private DefaultTableModel model;


	public LibrosScreenUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		//El label será sustituido por Libro reservado || Fecha reserva  || fecha devolucion cuando haya selecionado algo del jList xd
		JLabel lblNewLabel = new JLabel("Libro reservado || Fecha reserva  || fecha devolucion");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.gridwidth = 6;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		btnListarLibros = new JButton("Prueba");
		GridBagConstraints gbc_btnListarLibros = new GridBagConstraints();
		gbc_btnListarLibros.insets = new Insets(0, 0, 0, 5);
		gbc_btnListarLibros.gridx = 0;
		gbc_btnListarLibros.gridy = 1;
		contentPane.add(btnListarLibros, gbc_btnListarLibros);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			    new Object[][] {},
			    new String[] {
			        "Código", "Titulo", "Autor", "Categoría", "Disponibilidad", "Fecha de publicación"
			    }) {
			    Class[] columnTypes = new Class[] {
			        String.class, String.class, String.class, String.class, Boolean.class, String.class
			    };
			    public Class getColumnClass(int columnIndex) {
			        return columnTypes[columnIndex];
			    }
			    boolean[] columnEditables = new boolean[] {
			        false, false, false, false, false, false
			    };
			    public boolean isCellEditable(int row, int column) {
			        return columnEditables[column];
			    }
			});
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 6;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		contentPane.add(table, gbc_table);
	}
	
	public void agregarListenerPrueba(ActionListener listenForPrubaButton) {
		btnListarLibros.addActionListener(listenForPrubaButton);

	}
	
	public void agregarEnLista(ArrayList<Libros> librosLista) {

		
		int ultimaPosicion = librosLista.size() -1;
		model = (DefaultTableModel)table.getModel();
		model.addRow(new Object[] {librosLista.get(ultimaPosicion).getId(), librosLista.get(ultimaPosicion).getTitulo(), librosLista.get(ultimaPosicion).getAutor(), librosLista.get(ultimaPosicion).getGenero(), librosLista.get(ultimaPosicion).isDisponibilidad(), librosLista.get(ultimaPosicion).getFechaPublicacion()});
		
		
	}

}
