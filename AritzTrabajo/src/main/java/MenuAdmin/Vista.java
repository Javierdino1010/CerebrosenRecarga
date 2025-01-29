package MenuAdmin;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelo.Usuario;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class Vista extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnUsuarios;
    private JButton btnLibros;
    private JButton btnReporte;
    private JLabel lblNewLabel;
    private static JComboBox comboBox;
    private JButton btnNewButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Vista frame = new Vista();
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
    public Vista() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setBackground(new Color(240, 255, 255));
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);
        
        lblNewLabel = new JLabel("PANEL DE ADMINISTRADOR");
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 3;
        gbc_lblNewLabel.gridy = 1;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);
        
        btnUsuarios = new JButton("GESTIONAR USUARIOS");
        btnUsuarios.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
        GridBagConstraints gbc_btnUsuarios = new GridBagConstraints();
        gbc_btnUsuarios.insets = new Insets(0, 0, 5, 5);
        gbc_btnUsuarios.gridx = 1;
        gbc_btnUsuarios.gridy = 3;
        gbc_btnUsuarios.gridwidth = 4;  // Aumenta el tamaño en el eje X
        gbc_btnUsuarios.fill = GridBagConstraints.BOTH; // Hace que el botón ocupe todo el espacio disponible
        gbc_btnUsuarios.weightx = 1.0;  // Hace que el botón se expanda horizontalmente
        gbc_btnUsuarios.weighty = 0.0;  // No permite que se expanda verticalmente
        contentPane.add(btnUsuarios, gbc_btnUsuarios);
        
        btnLibros = new JButton("GESTIONAR LIBROS");
        btnLibros.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
        GridBagConstraints gbc_btnLibros = new GridBagConstraints();
        gbc_btnLibros.insets = new Insets(0, 0, 5, 5);
        gbc_btnLibros.gridx = 1;
        gbc_btnLibros.gridy = 5;
        gbc_btnLibros.gridwidth = 4;  // Aumenta el tamaño en el eje X
        gbc_btnLibros.fill = GridBagConstraints.BOTH; // Hace que el botón ocupe todo el espacio disponible
        gbc_btnLibros.weightx = 1.0;  // Hace que el botón se expanda horizontalmente
        gbc_btnLibros.weighty = 0.0;  // No permite que se expanda verticalmente
        contentPane.add(btnLibros, gbc_btnLibros);
        
        btnReporte = new JButton("GENERAR REPORTE");
        btnReporte.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
        btnLibros.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 20));
        GridBagConstraints gbc_generarReporte = new GridBagConstraints();
        gbc_generarReporte.fill = GridBagConstraints.BOTH;
        gbc_generarReporte.gridwidth = 4;
        gbc_generarReporte.insets = new Insets(0, 0, 5, 5);
        gbc_generarReporte.gridx = 1;
        gbc_generarReporte.gridy = 7;
        gbc_btnLibros.fill = GridBagConstraints.BOTH;
        gbc_btnLibros.weightx = 1.0;  // Hace que el botón se expanda horizontalmente
        gbc_btnLibros.weighty = 0.0;  // No permite que se expanda verticalmente
        contentPane.add(btnReporte, gbc_generarReporte);
        
      
        
        comboBox = new JComboBox<>();
        comboBox.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.gridwidth = 4;
        gbc_comboBox.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox.fill = GridBagConstraints.BOTH;
        gbc_comboBox.gridx = 1;
        gbc_comboBox.gridy = 9;
        contentPane.add(comboBox, gbc_comboBox);
        
        comboBox.addItem("Libros prestados");
        comboBox.addItem("Usuarios con mas libros");
        comboBox.addItem("Libros mas populares");
        comboBox.addItem("Tendencias por genero");
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "¿Seguro que quieres salir?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
                );

                if (confirm == JOptionPane.YES_OPTION) {
            		SessionFactory factory = new Configuration().configure().buildSessionFactory();
            		Session session = factory.openSession();
            		
            		session.beginTransaction();
            		
            		List<Usuario> usuario = session.createQuery("FROM Usuario WHERE estaLogeado = true", Usuario.class).list();
            		for (Usuario usu : usuario) {
						usu.setLogin(false);
						session.update(usu);
					}
               	    session.getTransaction().commit();
               	    session.close();

                    System.exit(0); 
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Evita el cierre
                }
            }
        });
        
       
    }
    
    //Agregar actionListener a los botones
    public void agregarListenerUsuarios(ActionListener listenForUsuarioButton) {
        btnUsuarios.addActionListener(listenForUsuarioButton);
    }

    public void agregarListenerLibros(ActionListener listenForLibroButton) {
        btnLibros.addActionListener(listenForLibroButton);
    }

    public void agregarListenerReporte(ActionListener listenForReporteButton) {
        btnReporte.addActionListener(listenForReporteButton);
    }
    
    public String getComboBox() {
    	String seleccionado = (String) comboBox.getSelectedItem();
		return seleccionado;
    	
    }
}
