package Libro;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class LibrosScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBoxCategorias;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LibrosScreen frame = new LibrosScreen();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LibrosScreen() {
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

        JButton btnAñadirLibro = crearBoton("Añadir Libro", new Color(60, 179, 113), e -> {
            dispose();
            InsertarLibro.main(null);
        });
        panelSuperior.add(btnAñadirLibro);

        JButton btnEliminar = crearBoton("Eliminar", new Color(220, 20, 60), e -> eliminarLibro());
        panelSuperior.add(btnEliminar);

        JButton btnModificar = crearBoton("Modificar", new Color(255, 140, 0), e -> modificarLibro());
        panelSuperior.add(btnModificar);

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

    private JButton crearBoton(String texto, Color color, ActionListener actionListener) {
        JButton boton = new JButton(texto);
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.addActionListener(actionListener);
        return boton;
    }

    private void cargarCategorias() {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String contrasena = "root";

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
             Statement stmt = conn.createStatement()) {

            String query = "SELECT DISTINCT genero FROM libros";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                comboBoxCategorias.addItem(rs.getString("genero"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private void eliminarLibro() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) table.getValueAt(selectedRow, 0);

            String url = "jdbc:mysql://localhost:3306/biblioteca";
            String usuario = "root";
            String contrasena = "root";

            try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
                 PreparedStatement pstmt = conn.prepareStatement("DELETE FROM libros WHERE id = ?")) {

                pstmt.setInt(1, id);
                pstmt.executeUpdate();

                ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Libro eliminado correctamente.");

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar el libro.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un libro para eliminar.");
        }
    }

    private void modificarLibro() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) table.getValueAt(selectedRow, 0);
            String titulo = (String) table.getValueAt(selectedRow, 1);
            String genero = (String) table.getValueAt(selectedRow, 2);
            String disponibilidad = (String) table.getValueAt(selectedRow, 3);

            // Crear ventana emergente para modificar libro
            JDialog dialog = new JDialog(this, "Modificar Libro", true);
            dialog.setSize(400, 300);
            dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));

            JTextField txtTitulo = new JTextField(titulo, 20);
            JTextField txtGenero = new JTextField(genero, 20);
            JTextField txtDisponibilidad = new JTextField(disponibilidad, 20);

            JButton btnGuardar = crearBoton("Guardar", new Color(60, 179, 113), e -> {
                String nuevoTitulo = txtTitulo.getText().trim();
                String nuevoGenero = txtGenero.getText().trim();
                String nuevaDisponibilidad = txtDisponibilidad.getText().trim();

                actualizarLibro(id, nuevoTitulo, nuevoGenero, nuevaDisponibilidad);
                dialog.dispose();
                cargarLibros(null);
            });

            dialog.add(new JLabel("Título:"));
            dialog.add(txtTitulo);
            dialog.add(new JLabel("Género:"));
            dialog.add(txtGenero);
            dialog.add(new JLabel("Disponibilidad:"));
            dialog.add(txtDisponibilidad);
            dialog.add(btnGuardar);

            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un libro para modificar.");
        }
    }

    private void actualizarLibro(int id, String titulo, String genero, String disponibilidad) {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String contrasena = "root";

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
             PreparedStatement pstmt = conn.prepareStatement(
                     "UPDATE libros SET titulo = ?, genero = ?, disponibilidad = ? WHERE id = ?")) {

            pstmt.setString(1, titulo);
            pstmt.setString(2, genero);
            pstmt.setString(3, disponibilidad);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void filtrarPorCategoria() {
        String categoriaSeleccionada = (String) comboBoxCategorias.getSelectedItem();
        cargarLibros(categoriaSeleccionada);
    }
}