package usuarios;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

public class VistaGestionUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnModUser;
	private JButton btnVolver;
	private JButton btnDeleteUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaGestionUsuarios frame = new VistaGestionUsuarios();
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
	public VistaGestionUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setBackground(new Color(240, 248, 255));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		btnVolver = new JButton("Volver");
		GridBagConstraints gbc_btnVolver = new GridBagConstraints();
		gbc_btnVolver.insets = new Insets(0, 0, 5, 5);
		gbc_btnVolver.gridx = 1;
		gbc_btnVolver.gridy = 1;
		contentPane.add(btnVolver, gbc_btnVolver);
		
		btnModUser = new JButton("Modificar usuario");
		GridBagConstraints gbc_btnModUser = new GridBagConstraints();
		gbc_btnModUser.insets = new Insets(0, 0, 5, 5);
		gbc_btnModUser.gridx = 5;
		gbc_btnModUser.gridy = 1;
		contentPane.add(btnModUser, gbc_btnModUser);
		
		btnDeleteUser = new JButton("Eliminar usuario");
		GridBagConstraints gbc_btnDeleteUser = new GridBagConstraints();
		gbc_btnDeleteUser.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteUser.gridx = 5;
		gbc_btnDeleteUser.gridy = 2;
		contentPane.add(btnDeleteUser, gbc_btnDeleteUser);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "Nombre", "Apellido", "Email", "Telefono", "Rol"
			}
		));
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 3;
		gbc_table.gridwidth = 7;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 3;
		contentPane.add(table, gbc_table);
	}

	
	//Agregar actionListener a los botones
			public void ModificarUsuarios(ActionListener listenForModUsuario) {
				btnModUser.addActionListener(listenForModUsuario);
				
			}
			
			public void EliminarUsuarios(ActionListener listenForDelUsuario) {
				btnModUser.addActionListener(listenForDelUsuario);
				
			}
			
			public void Volver(ActionListener listenForVolver) {
				btnModUser.addActionListener(listenForVolver);
				
			}
}
