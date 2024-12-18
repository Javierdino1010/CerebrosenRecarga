package LoginRegister;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class VistaRegister extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textNombre;
	private JLabel lblNewLabel_1;
	private JTextField textApellidos;
	private JLabel lblNewLabel_2;
	private JTextField textDni;
	private JLabel lblNewLabel_3;
	private JTextField textEmail;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textTelefono;
	private JButton btnRegistrarse;
	private JLabel lblNewLabel_6;
	private JPasswordField textPass;
	private JButton btnLogin;

	public VistaRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 564);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 293, 0, 0};
		gbl_contentPane.rowHeights = new int[]{55, 0, 41, 0, 45, 0, 47, 0, 44, 0, 48, 0, 115, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNewLabel_6 = new JLabel("Registro");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 0;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		lblNewLabel = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 3;
		gbc_textNombre.gridy = 1;
		contentPane.add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textApellidos = new JTextField();
		GridBagConstraints gbc_textApellidos = new GridBagConstraints();
		gbc_textApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_textApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellidos.gridx = 3;
		gbc_textApellidos.gridy = 3;
		contentPane.add(textApellidos, gbc_textApellidos);
		textApellidos.setColumns(10);
		
		lblNewLabel_2 = new JLabel("DNI:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 5;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textDni = new JTextField();
		GridBagConstraints gbc_textDni = new GridBagConstraints();
		gbc_textDni.insets = new Insets(0, 0, 5, 5);
		gbc_textDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDni.gridx = 3;
		gbc_textDni.gridy = 5;
		contentPane.add(textDni, gbc_textDni);
		textDni.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 7;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textEmail = new JTextField();
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 3;
		gbc_textEmail.gridy = 7;
		contentPane.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Teléfono");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 9;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textTelefono = new JTextField();
		GridBagConstraints gbc_textTelefono = new GridBagConstraints();
		gbc_textTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_textTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelefono.gridx = 3;
		gbc_textTelefono.gridy = 9;
		contentPane.add(textTelefono, gbc_textTelefono);
		textTelefono.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Contraseña:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 11;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textPass = new JPasswordField();
		GridBagConstraints gbc_textPass = new GridBagConstraints();
		gbc_textPass.insets = new Insets(0, 0, 5, 5);
		gbc_textPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPass.gridx = 3;
		gbc_textPass.gridy = 11;
		contentPane.add(textPass, gbc_textPass);
		
		btnLogin = new JButton("Iniciar sesión");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogin.gridx = 2;
		gbc_btnLogin.gridy = 12;
		contentPane.add(btnLogin, gbc_btnLogin);
		
		btnRegistrarse = new JButton("Registrarse");
		GridBagConstraints gbc_btnRegistrarse = new GridBagConstraints();
		gbc_btnRegistrarse.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistrarse.gridx = 3;
		gbc_btnRegistrarse.gridy = 12;
		contentPane.add(btnRegistrarse, gbc_btnRegistrarse);
	}
	
	public void agregarListenerRegister(ActionListener listenForRegisterButton) {
		btnRegistrarse.addActionListener(listenForRegisterButton);
	}
	
	public void agregarListenerIrInicio(ActionListener listenForIrInicioButton) {
		btnLogin.addActionListener(listenForIrInicioButton);
	}
	
	public String getNombre() {
		return textNombre.getText();
	}
	
	public String getApellidos() {
		return textApellidos.getText();
	}
	
	public String getDni() {
		return textDni.getText();
	}
	
	public String getEmail() {
		return textEmail.getText();
	}

	public String getTelefono() {
		return textTelefono.getText();
	}
	
	public String getPass() {
		return new String(textPass.getPassword());
	}
}
