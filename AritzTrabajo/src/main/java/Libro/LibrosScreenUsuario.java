package Libro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class LibrosScreenUsuario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBoxCategorias;
    private JTable table;
    private JButton btnReservar;
    private JButton btnDevolver;

    public LibrosScreenUsuario() {
        setTitle("Gestión de Libros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 248, 255));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(10, 10));

        // Panel superior para los botones y filtro
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(new Color(240, 248, 255));
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        contentPane.add(panelSuperior, BorderLayout.NORTH);

        btnReservar = crearBoton("Reservar", new Color(220, 20, 60));
        panelSuperior.add(btnReservar);

        btnDevolver = crearBoton("Devolver", new Color(34, 139, 34)); // Color verde
        panelSuperior.add(btnDevolver);

        comboBoxCategorias = new JComboBox<>();
        comboBoxCategorias.addItem("Todas las categorías");
        comboBoxCategorias.addActionListener(e -> filtrarPorCategoria());
        comboBoxCategorias.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
        panelSuperior.add(comboBoxCategorias);

        // Etiqueta para el título
        JLabel lblTitulo = new JLabel("Gestión de Libros");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 27));
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

        btnReservar.addActionListener(e -> {
            int idLibro = obtenerIdFilaSeleccionada();
            if (idLibro != -1) {
                Libros libro = new Libros();
                libro.Reservar(idLibro);
                cargarLibros((String) comboBoxCategorias.getSelectedItem()); // Recargar la tabla
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un libro para reservar.");
            }
        });

        btnDevolver.addActionListener(e -> {
            int idLibro = obtenerIdFilaSeleccionada();
            if (idLibro != -1) {
                Libros libro = new Libros();
                libro.devolverLibro(idLibro);
                cargarLibros((String) comboBoxCategorias.getSelectedItem()); // Recargar la tabla
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un libro para devolver.");
            }
        });
    }

    public void agregarListenerReservar(ActionListener listenForReservarButton) {
        btnReservar.addActionListener(listenForReservarButton);
    }

    public void agregarListenerDevolver(ActionListener listenForDevolverButton) {
        btnDevolver.addActionListener(listenForDevolverButton);
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
        List<String> categorias = MostrarLibros.obtenerCategorias();
        for (String categoria : categorias) {
            comboBoxCategorias.addItem(categoria);
        }
    }

    private void filtrarPorCategoria() {
        String categoriaSeleccionada = (String) comboBoxCategorias.getSelectedItem();
        cargarLibros(categoriaSeleccionada);
    }

    public void cargarLibros(String categoria) {
        List<Object[]> libros = MostrarLibros.obtenerLibros(categoria);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Object[] libro : libros) {
            Object[] fila = {
                libro[0],                    // ID
                libro[1],                    // Título
                libro[2],                    // Género
                libro[3],                    // Disponibilidad
                libro[4] != null ? libro[4].toString() : "" // Fecha publicación (aseguramos que sea String)
            };
            model.addRow(fila);
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