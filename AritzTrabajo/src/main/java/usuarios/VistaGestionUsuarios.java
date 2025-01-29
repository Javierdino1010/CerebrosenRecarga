package usuarios;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Libro.Libros;
import modelo.Usuario;
import java.awt.Font;

public class VistaGestionUsuarios extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JButton btnModUser ;
    private JButton btnVolver;
    private JButton btnDeleteUser ;

    private static SessionFactory sessionFactory;

    static {
    	 Configuration configuration = new Configuration().configure().addAnnotatedClass(Usuario.class);
        sessionFactory = new Configuration().configure().addAnnotatedClass(Usuario.class).buildSessionFactory();
    }

   /* public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VistaGestionUsuarios frame = new VistaGestionUsuarios();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }*/

    public VistaGestionUsuarios() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setBackground(new Color(240, 248, 255));
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0};
        contentPane.setLayout(gbl_contentPane);

        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
        GridBagConstraints gbc_btnVolver = new GridBagConstraints();
        gbc_btnVolver.insets = new Insets(0, 0, 5, 5);
        gbc_btnVolver.gridx = 1;
        gbc_btnVolver.gridy = 1;
        contentPane.add(btnVolver, gbc_btnVolver);
                
                        btnModUser  = new JButton("Modificar usuario");
                        btnModUser.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
                        GridBagConstraints gbc_btnModUser  = new GridBagConstraints();
                        gbc_btnModUser .insets = new Insets(0, 0, 5, 5);
                        gbc_btnModUser .gridx = 4;
                        gbc_btnModUser .gridy = 1;
                        contentPane.add(btnModUser , gbc_btnModUser );
        
                btnDeleteUser  = new JButton("Eliminar usuario");
                btnDeleteUser.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
                GridBagConstraints gbc_btnDeleteUser  = new GridBagConstraints();
                gbc_btnDeleteUser .insets = new Insets(0, 0, 5, 5);
                gbc_btnDeleteUser .gridx = 6;
                gbc_btnDeleteUser .gridy = 1;
                contentPane.add(btnDeleteUser , gbc_btnDeleteUser );
                
                        // Evento para eliminar usuario
                        btnDeleteUser .addActionListener(e -> eliminarUsuarioSeleccionado());

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"DNI", "Nombre", "Apellidos", "Email", "Teléfono", "Rol"}
        ));
        GridBagConstraints gbc_table = new GridBagConstraints();
        gbc_table.gridheight = 3;
        gbc_table.gridwidth = 8;
        gbc_table.fill = GridBagConstraints.BOTH;
        gbc_table.gridx = 0;
        gbc_table.gridy = 3;
        contentPane.add(new JScrollPane(table), gbc_table);

        cargarUsuarios(); // Carga los datos al iniciar
    }

    public void cargarUsuarios() {
        try {
            List<Usuario> usuarios = obtenerUsuarios();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Limpia la tabla antes de agregar datos nuevos

            for (Usuario u : usuarios) {
                model.addRow(new Object[]{u.getDNI(), u.getNombre(), u.getApellidos(), u.getEmail(), u.getTelefono(), u.getRol()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar usuarios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<Usuario> obtenerUsuarios() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Usuario", Usuario.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void eliminarUsuarioSeleccionado() {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario para eliminar", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String dni = (String) table.getValueAt(filaSeleccionada, 0); // Obtener el DNI del usuario seleccionado

        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (eliminarUsuario(dni)) {
                JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarUsuarios(); // Refrescar la tabla
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar usuario", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public boolean eliminarUsuario(String dni) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            // Buscar usuario con el DNI
            Query<Usuario> query = session.createQuery("FROM Usuario WHERE DNI = :dni", Usuario.class);
            query.setParameter("dni", dni);
            Usuario usuario = query.uniqueResult();

            if (usuario != null) {
                session.delete(usuario);
                transaction.commit();
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró un usuario con ese DNI.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Asegúrate de hacer rollback si hay un error
            }
            e.printStackTrace();
        }
        return false;
    }

    public void ModificarUsuarios(ActionListener listener) {
        btnModUser .addActionListener(listener);
    }

    public void EliminarUsuarios(ActionListener listener) {
        btnDeleteUser .addActionListener(listener);
    }

    public void Volver(ActionListener listener) {
        btnVolver.addActionListener(listener);
    }
}