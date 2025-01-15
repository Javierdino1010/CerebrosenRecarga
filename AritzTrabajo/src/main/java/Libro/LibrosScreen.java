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

public class LibrosScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JList<String> list;

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
                // Acción para el botón "Volver"
            }
        });
        GridBagConstraints gbc_btnVolver = new GridBagConstraints();
        gbc_btnVolver.fill = GridBagConstraints.BOTH;
        gbc_btnVolver.insets = new Insets(0, 0, 5, 5);
        gbc_btnVolver.gridx = 1;
        gbc_btnVolver.gridy = 0;
        contentPane.add(btnVolver, gbc_btnVolver);

        JButton btnAnadir = new JButton("Nuevo Libro");
        btnAnadir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Acción para añadir un nuevo libro
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
                // Acción para modificar un libro
            }
        });
        GridBagConstraints gbc_btnModificar = new GridBagConstraints();
        gbc_btnModificar.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
        gbc_btnModificar.gridx = 6;
        gbc_btnModificar.gridy = 1;
        contentPane.add(btnModificar, gbc_btnModificar);

        JButton btnReservar = new JButton("Reservar");
        btnReservar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Acción para reservar un libro
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
                // Acción para eliminar un libro
            }
        });
        GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
        gbc_btnBorrar.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
        gbc_btnBorrar.gridx = 6;
        gbc_btnBorrar.gridy = 2;
        contentPane.add(btnBorrar, gbc_btnBorrar);

        JLabel lblNewLabel = new JLabel("Libro reservado || Fecha reserva  || fecha devolucion");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
        gbc_lblNewLabel.gridwidth = 6;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 3;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);

        list = new JList<>(new DefaultListModel<>());
        GridBagConstraints gbc_list = new GridBagConstraints();
        gbc_list.gridwidth = 6;
        gbc_list.insets = new Insets(0, 0, 0, 5);
        gbc_list.fill = GridBagConstraints.BOTH;
        gbc_list.gridx = 1;
        gbc_list.gridy = 4;
        contentPane.add(list, gbc_list);

        cargarLibros();
    }

    private void cargarLibros() {
        String url = "jdbc:mysql://localhost:3306/biblioteca"; // Cambiar por tu URL de conexión
        String usuario = "root"; // Cambiar por tu usuario de la base de datos
        String contrasena = "root"; // Cambiar por tu contraseña

        DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
             Statement stmt = conn.createStatement()) {

            String query = "SELECT ID, titulo, autor, genero, disponibilidad, fecha_publicacion FROM libros";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String libro = String.format("%s | %s | %s | %s | %s | %s",
                        rs.getString("ID"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("genero"),
                        rs.getString("disponibilidad"),
                        rs.getDate("fecha_publicacion"));
                model.addElement(libro);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JList<String> getList() {
        return list;
    }
}
