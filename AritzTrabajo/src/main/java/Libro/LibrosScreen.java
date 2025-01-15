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
import javax.swing.DefaultListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;

public class LibrosScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JList<String> list;
    private JComboBox<String> comboBoxCategorias;

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

    public LibrosScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 653, 419);
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
                // Acción para el botón "Volver"
            }
        });
        GridBagConstraints gbc_btnVolver = new GridBagConstraints();
        gbc_btnVolver.fill = GridBagConstraints.BOTH;
        gbc_btnVolver.insets = new Insets(0, 0, 5, 5);
        gbc_btnVolver.gridx = 1;
        gbc_btnVolver.gridy = 0;
        contentPane.add(btnVolver, gbc_btnVolver);

        comboBoxCategorias = new JComboBox<>();
        comboBoxCategorias.addItem("Todas las categorías");
        comboBoxCategorias.addActionListener(e -> filtrarPorCategoria());
        GridBagConstraints gbc_comboBoxCategorias = new GridBagConstraints();
        gbc_comboBoxCategorias.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxCategorias.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxCategorias.gridx = 6;
        gbc_comboBoxCategorias.gridy = 0;
        contentPane.add(comboBoxCategorias, gbc_comboBoxCategorias);

        JLabel lblNewLabel = new JLabel("Título | Categoría | Disponibilidad | Fecha publicación");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
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
        String url = "jdbc:mysql://localhost:3306/biblioteca"; // Cambiar por tu URL de conexión
        String usuario = "root"; // Cambiar por tu usuario de la base de datos
        String contrasena = "root"; // Cambiar por tu contraseña

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
        String url = "jdbc:mysql://localhost:3306/biblioteca"; // Cambiar por tu URL de conexión
        String usuario = "root"; // Cambiar por tu usuario de la base de datos
        String contrasena = "root"; // Cambiar por tu contraseña

        DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
        model.clear();

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
             Statement stmt = conn.createStatement()) {

            String query = "SELECT titulo, genero, disponibilidad, fecha_publicacion FROM libros";
            if (categoria != null && !categoria.equals("Todas las categorías")) {
                query += " WHERE genero 	 = '" + categoria + "'";
            }

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String libro = String.format("%s | %s | %s | %s",
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

    private void filtrarPorCategoria() {
        String categoriaSeleccionada = (String) comboBoxCategorias.getSelectedItem();
        cargarLibros(categoriaSeleccionada);
    }

    public JList<String> getList() {
        return list;
    }
}
