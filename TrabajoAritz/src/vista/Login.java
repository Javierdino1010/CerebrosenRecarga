package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuario_textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Usuario", "Administrador"}));
		comboBox.setToolTipText("");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 0;
		contentPane.add(comboBox, gbc_comboBox);
		
		JLabel usuario_lblNewLabel = new JLabel("USUARIO:");
		GridBagConstraints gbc_usuario_lblNewLabel = new GridBagConstraints();
		gbc_usuario_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_usuario_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_usuario_lblNewLabel.gridx = 1;
		gbc_usuario_lblNewLabel.gridy = 1;
		contentPane.add(usuario_lblNewLabel, gbc_usuario_lblNewLabel);
		
		usuario_textField = new JTextField();
		GridBagConstraints gbc_usuario_textField = new GridBagConstraints();
		gbc_usuario_textField.insets = new Insets(0, 0, 5, 5);
		gbc_usuario_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usuario_textField.gridx = 2;
		gbc_usuario_textField.gridy = 1;
		contentPane.add(usuario_textField, gbc_usuario_textField);
		usuario_textField.setColumns(10);
		
		JLabel contraseña_lblNewLabel = new JLabel("CONTRASEÑA:");
		GridBagConstraints gbc_contraseña_lblNewLabel = new GridBagConstraints();
		gbc_contraseña_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_contraseña_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_contraseña_lblNewLabel.gridx = 1;
		gbc_contraseña_lblNewLabel.gridy = 2;
		contentPane.add(contraseña_lblNewLabel, gbc_contraseña_lblNewLabel);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 2;
		contentPane.add(passwordField, gbc_passwordField);
		
		JButton resgistrarse_btnNewButton = new JButton("RESGISTRARSE");
		GridBagConstraints gbc_resgistrarse_btnNewButton = new GridBagConstraints();
		gbc_resgistrarse_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_resgistrarse_btnNewButton.gridx = 1;
		gbc_resgistrarse_btnNewButton.gridy = 3;
		contentPane.add(resgistrarse_btnNewButton, gbc_resgistrarse_btnNewButton);
		
		JButton login_btnNewButton = new JButton("LOGIN");
		GridBagConstraints gbc_login_btnNewButton = new GridBagConstraints();
		gbc_login_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_login_btnNewButton.gridx = 2;
		gbc_login_btnNewButton.gridy = 3;
		contentPane.add(login_btnNewButton, gbc_login_btnNewButton);
	}

}
