package Libro;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelo.Usuario;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibrosScreenUsuario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBoxCategorias;
    private JTable table;
    private JButton btnReservar;


	public LibrosScreenUsuario() {
		setTitle("Gestión de Libros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);

        contentPane = new JPanel();

        contentPane.setBackground(new Color(240, 248, 255));


        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(new Color(240, 248, 255)); // Fondo azul claro
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(10, 10));

        // Panel superior para los botones y filtro
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(new Color(240, 248, 255));
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        contentPane.add(panelSuperior, BorderLayout.NORTH);
        
        btnReservar = crearBoton("Reservar", new Color(220, 20, 60));
        panelSuperior.add(btnReservar);

        comboBoxCategorias = new JComboBox<>();
        comboBoxCategorias.addItem("Todas las categorías");
        comboBoxCategorias.addActionListener(e -> filtrarPorCategoria());
        comboBoxCategorias.setFont(new Font("Arial", Font.PLAIN, 14));
        panelSuperior.add(comboBoxCategorias);

        // Etiqueta para el título
        JLabel lblTitulo = new JLabel("Gestión de Libros");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(70, 130, 180));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitulo, BorderLayout.CENTER);

        // Tabla para mostrar los libros
        table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"ID", "Título", "Categoría", "Disponibilidad", "Fecha publicación"}
        ));
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(new Color(245, 245, 245));
        contentPane.add(scrollPane, BorderLayout.SOUTH);

        cargarCategorias();
        cargarLibros(null);

		}
	

    
	public void agregarListenerReservar(ActionListener listenForReservarButton) {
		btnReservar.addActionListener(listenForReservarButton);
	}

	private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setFocusPainted(false);
        return boton;
    }
	
    
    private void cargarCategorias() {
//        String url = "jdbc:mysql://localhost:3306/biblioteca";
//        String usuario = "root";
//        String contrasena = "root";
//
//        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
//             Statement stmt = conn.createStatement()) {
//
//            String query = "SELECT DISTINCT genero FROM libros";
//            ResultSet rs = stmt.executeQuery(query);
//
//            while (rs.next()) {
//                comboBoxCategorias.addItem(rs.getString("genero"));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    	
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		List<Libros> libro = session.createQuery("FROM Libros", Libros.class).list();
		
		for (Libros libros : libro) {
			comboBoxCategorias.addItem(libros.getGenero());
		}
    }
    
    private void filtrarPorCategoria() {
        String categoriaSeleccionada = (String) comboBoxCategorias.getSelectedItem();
        cargarLibros(categoriaSeleccionada);
    }
    
    private void cargarLibros(String categoria) {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String contrasena = "root";

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
             Statement stmt = conn.createStatement()) {

            String query = "SELECT id, titulo, genero, disponibilidad, fecha_publicacion FROM libros";
            if (categoria != null && !categoria.equals("Todas las categorías")) {
                query += " WHERE genero = '" + categoria + "'";
            }

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("genero"),
                    rs.getString("disponibilidad"),
                    rs.getDate("fecha_publicacion")
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int obtenerIdFilaSeleccionada() {
        int filaSeleccionada = table.getSelectedRow();
        
        if (filaSeleccionada != -1) {
            int id = (int) table.getValueAt(filaSeleccionada, 0);
            return id;
        } else {
            return -1;
        }
    }
    

	}