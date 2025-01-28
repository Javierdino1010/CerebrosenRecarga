package Libro;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LibrosScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBoxCategorias;
    private JTable table;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public LibrosScreen() {
        setTitle("Gestión de Libros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(new Color(240, 248, 255));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(10, 10));

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelSuperior.setBackground(new Color(240, 248, 255));
        contentPane.add(panelSuperior, BorderLayout.NORTH);

        JButton btnAñadirLibro = crearBoton("Añadir Libro", new Color(60, 179, 113), e -> {
            new InsertarLibro().setVisible(true);
            dispose();
        });
        panelSuperior.add(btnAñadirLibro);

        JButton btnEliminar = crearBoton("Eliminar", new Color(220, 20, 60), e -> eliminarLibro());
        panelSuperior.add(btnEliminar);

        JButton btnModificar = crearBoton("Modificar", new Color(255, 140, 0), e -> modificarLibro());
        panelSuperior.add(btnModificar);
        
        JButton btnGenerarInforme = crearBoton("Exportar", new Color(255, 140, 0), e -> exportarLibro());
        panelSuperior.add(btnGenerarInforme);

        comboBoxCategorias = new JComboBox<>();
        comboBoxCategorias.addItem("Todas las categorías");
        comboBoxCategorias.addActionListener(e -> cargarLibros((String) comboBoxCategorias.getSelectedItem()));
        panelSuperior.add(comboBoxCategorias);

        // Modelo de la tabla sin la columna de autor
        table = new JTable(new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Título", "Género", "Disponibilidad", "Fecha publicación"}
        ));
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(new Color(240, 248, 255));
        contentPane.add(scrollPane, BorderLayout.CENTER);

        cargarCategorias();
        cargarLibros(null);
    }

    private JButton crearBoton(String texto, Color color, ActionListener actionListener) {
        JButton boton = new JButton(texto);
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setFocusPainted(false);
        boton.addActionListener(actionListener);
        return boton;
    }

    private void cargarCategorias() {
        List<String> categorias = MostrarLibros.obtenerCategorias();
        for (String categoria : categorias) {
            comboBoxCategorias.addItem(categoria);
        }
    }

    private void cargarLibros(String categoria) {
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

    private void eliminarLibro() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) table.getValueAt(selectedRow, 0);
            if (MostrarLibros.eliminarLibro(id)) {
                ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Libro eliminado correctamente.");
            } else {
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
            String tituloActual = (String) table.getValueAt(selectedRow, 1);
            String generoActual = (String) table.getValueAt(selectedRow, 2);
            String disponibilidadActual = table.getValueAt(selectedRow, 3).toString();
            String fechaActual = (String) table.getValueAt(selectedRow, 4);

            // Crear panel con campos de entrada
            JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
            panel.add(new JLabel("Título:"));
            JTextField txtTitulo = new JTextField(tituloActual);
            panel.add(txtTitulo);

            panel.add(new JLabel("Género:"));
            JTextField txtGenero = new JTextField(generoActual);
            panel.add(txtGenero);

            panel.add(new JLabel("Disponibilidad (true o false):"));
            JTextField txtDisponibilidad = new JTextField(disponibilidadActual);
            panel.add(txtDisponibilidad);

            panel.add(new JLabel("Fecha de publicación (YYYY-MM-DD):"));
            JTextField txtFecha = new JTextField(fechaActual);
            panel.add(txtFecha);

            // Mostrar panel en un JOptionPane
            int result = JOptionPane.showConfirmDialog(
                    this,
                    panel,
                    "Modificar libro",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );

            if (result == JOptionPane.OK_OPTION) {
                // Obtener valores ingresados
                String titulo = txtTitulo.getText().trim();
                String genero = txtGenero.getText().trim();
                String disponibilidad = txtDisponibilidad.getText().trim();
                String fechaStr = txtFecha.getText().trim();

                // Validar disponibilidad
                if (!"true".equals(disponibilidad) && !"false".equals(disponibilidad)) {
                    JOptionPane.showMessageDialog(
                            this,
                            "El valor de disponibilidad debe ser 'true' (disponible) o 'false' (no disponible).",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                // Validar fecha de publicación (formato simple)
                if (!fechaStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    JOptionPane.showMessageDialog(
                            this,
                            "La fecha debe tener el formato YYYY-MM-DD.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                // Convertir la fecha a Date
                Date fechaPublicacion = null;
                try {
                    fechaPublicacion = dateFormat.parse(fechaStr);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "La fecha ingresada no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Llamar al método actualizarLibro de MostrarLibros
                boolean actualizado = MostrarLibros.actualizarLibro(id, titulo, genero, disponibilidad, fechaPublicacion);

                if (actualizado) {
                    // Actualizar la tabla visualmente
                    table.setValueAt(titulo, selectedRow, 1);
                    table.setValueAt(genero, selectedRow, 2);
                    table.setValueAt(disponibilidad, selectedRow, 3);
                    table.setValueAt(fechaStr, selectedRow, 4); // Asegurarse de que se muestra como String
                    JOptionPane.showMessageDialog(this, "Libro actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar el libro.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un libro para modificar.");
        }
    }
    
    public void exportarLibro() {
    	
    	IReportEngine engine = null;
    	 
    	 try {
    		 // Configuración del motor BIRT
    		 EngineConfig config = new EngineConfig();
    		 Platform.startup(config);
    		 IReportEngineFactory factory = (IReportEngineFactory)Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
    	
    		 engine = factory.createReportEngine(config);

    		 String reportPath = "C:\\Users\\ikasle\\git\\CerebrosenRecargaMaven\\AritzTrabajo\\src\\main\\java\\reportes\\ListaLibros.rptdesign";
    		 
    		// Abre el informe
    		 IReportRunnable report = engine.openReportDesign(reportPath);
    		 // Crear tarea para ejecutar y renderizar
    		 IRunAndRenderTask task = engine.createRunAndRenderTask(report);
    		 
    		 String userHome = System.getProperty("user.home");
    		 String outputFilePath = userHome + "\\Desktop\\ListaLibros.pdf";

    		 HTMLRenderOption options = new HTMLRenderOption();
    		 options.setOutputFileName(outputFilePath);
    		 options.setOutputFormat("pdf");

    		 task.setRenderOption(options);
    		 // Ejecutar para crear el archivo HTML
    		 task.run();
    		 // Ahora finalizamos la tarea
    		 task.close();
    		 
    		 File htmlFile = new File(outputFilePath);
    		 } catch (Exception e) {
    		 e.printStackTrace();
    		 }finally {
    			  if (engine != null) {
    				  engine.destroy();
    			  }
    			  	  Platform.shutdown();
    			  }
    			  
    	 


    }

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
}