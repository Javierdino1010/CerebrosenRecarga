package Libro;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibrosScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JList<String> list;
    private JComboBox<String> comboBoxCategorias;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        // Botón "Eliminar"
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(e -> eliminarLibro());
        GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
        gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
        gbc_btnEliminar.gridx = 2;
        gbc_btnEliminar.gridy = 0;
        contentPane.add(btnEliminar, gbc_btnEliminar);

        // Botón "Modificar"
        JButton btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(e -> modificarLibro());
        GridBagConstraints gbc_btnModificar = new GridBagConstraints();
        gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
        gbc_btnModificar.gridx = 3;
        gbc_btnModificar.gridy = 0;
        contentPane.add(btnModificar, gbc_btnModificar);

        comboBoxCategorias = new JComboBox<>();
        comboBoxCategorias.addItem("Todas las categorías");
        comboBoxCategorias.addActionListener(e -> filtrarPorCategoria());
        GridBagConstraints gbc_comboBoxCategorias = new GridBagConstraints();
        gbc_comboBoxCategorias.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxCategorias.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxCategorias.gridx = 6;
        gbc_comboBoxCategorias.gridy = 0;
        contentPane.add(comboBoxCategorias, gbc_comboBoxCategorias);

        JLabel lblNewLabel = new JLabel("ID | Título | Categoría | Disponibilidad | Fecha publicación");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.gridwidth = 6;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 1;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);

        list = new JList<>(new DefaultListModel<>());
        GridBagConstraints gbc_list = new GridBagConstraints();
        gbc_list.gridwidth = 6;
        gbc_list.insets = new Insets(0, 0, 0, 5);
        gbc_list.fill = GridBagConstraints.BOTH;
        gbc_list.gridx = 1;
        gbc_list.gridy = 2;
        contentPane.add(list, gbc_list);

        cargarCategorias();
        cargarLibros(null);
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

        DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
        model.clear();

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
             Statement stmt = conn.createStatement()) {

            String query = "SELECT id, titulo, genero, disponibilidad, fecha_publicacion FROM libros";
            if (categoria != null && !categoria.equals("Todas las categorías")) {
                query += " WHERE genero = '" + categoria + "'";
            }

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String libro = String.format("%d | %s | %s | %s | %s",
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("genero"),
                        rs.getString("disponibilidad"),
                        rs.getDate("fecha_publicacion"));
                model.addElement(libro);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminarLibro() {
        int selectedIndex = list.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedValue = list.getSelectedValue();
            String[] parts = selectedValue.split("\\|");
            int id = Integer.parseInt(parts[0].trim());

            String url = "jdbc:mysql://localhost:3306/biblioteca";
            String usuario = "root";
            String contrasena = "root";

            try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
                 PreparedStatement pstmt = conn.prepareStatement("DELETE FROM libros WHERE id = ?")) {

                pstmt.setInt(1, id);
                pstmt.executeUpdate();

                ((DefaultListModel<String>) list.getModel()).remove(selectedIndex);
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
        int selectedIndex = list.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedValue = list.getSelectedValue();
            String[] parts = selectedValue.split("\\|");
            int id = Integer.parseInt(parts[0].trim());
            String titulo = parts[1].trim();
            String genero = parts[2].trim();
            String disponibilidad = parts[3].trim();

            // Crear ventana emergente para modificar libro
            JDialog dialog = new JDialog(this, "Modificar Libro", true);
            dialog.setSize(400, 300);
            dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));

            JTextField txtTitulo = new JTextField(titulo, 20);
            JTextField txtGenero = new JTextField(genero, 20);
            JTextField txtDisponibilidad = new JTextField(disponibilidad, 20);

            JButton btnGuardar = new JButton("Guardar");
            btnGuardar.addActionListener(e -> {
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
