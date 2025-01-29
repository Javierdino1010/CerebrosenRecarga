package usuarios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelo.Usuario;

import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;

public class VistaPerfil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPerfil frame = new VistaPerfil();
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
	public VistaPerfil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		contentPane.setBackground(new Color(240, 248, 255));
		
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		JLabel lblNewLabel_2 = new JLabel("Multa acumulada");
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblMulta = new JLabel("Multa");
		lblMulta.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblMulta.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_lblMulta = new GridBagConstraints();
		gbc_lblMulta.fill = GridBagConstraints.VERTICAL;
		gbc_lblMulta.insets = new Insets(0, 0, 5, 5);
		gbc_lblMulta.gridx = 2;
		gbc_lblMulta.gridy = 2;
		contentPane.add(lblMulta, gbc_lblMulta);
		
		JLabel lblNewLabel = new JLabel("Libros prestados");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 5;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnDevolver = new JButton("Devolver Libro");
		btnDevolver.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		GridBagConstraints gbc_btnDevolver = new GridBagConstraints();
		gbc_btnDevolver.insets = new Insets(0, 0, 5, 5);
		gbc_btnDevolver.gridx = 8;
		gbc_btnDevolver.gridy = 3;
		contentPane.add(btnDevolver, gbc_btnDevolver);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 4;
		gbc_list.gridwidth = 10;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 4;
		contentPane.add(list, gbc_list);
		
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

}
