package LoginRegister;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
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
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuario_textField;
	private JPasswordField passwordField;
	private JButton login_btnNewButton;
	private JButton registrarse_btnNewButton;

	BordeRedondo border = new BordeRedondo(10);
	
	public VistaLogin() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 564);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel usuario_lblNewLabel = new JLabel("USUARIO:");
		usuario_lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_usuario_lblNewLabel = new GridBagConstraints();
		gbc_usuario_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_usuario_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_usuario_lblNewLabel.gridx = 1;
		gbc_usuario_lblNewLabel.gridy = 1;
		contentPane.add(usuario_lblNewLabel, gbc_usuario_lblNewLabel);
		
		usuario_textField = new JTextField();
		usuario_textField.setToolTipText("Inserte el usuario");
		GridBagConstraints gbc_usuario_textField = new GridBagConstraints();
		gbc_usuario_textField.insets = new Insets(0, 0, 5, 5);
		gbc_usuario_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usuario_textField.gridx = 2;
		gbc_usuario_textField.gridy = 1;
		contentPane.add(usuario_textField, gbc_usuario_textField);
		usuario_textField.setColumns(10);
		
		JLabel contraseña_lblNewLabel = new JLabel("CONTRASEÑA:");
		contraseña_lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_contraseña_lblNewLabel = new GridBagConstraints();
		gbc_contraseña_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_contraseña_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_contraseña_lblNewLabel.gridx = 1;
		gbc_contraseña_lblNewLabel.gridy = 2;
		contentPane.add(contraseña_lblNewLabel, gbc_contraseña_lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Inserte la contraseña\r\n");
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 2;
		contentPane.add(passwordField, gbc_passwordField);
		
		registrarse_btnNewButton = new JButton("RESGISTRARSE");
		registrarse_btnNewButton.setPreferredSize(new Dimension(150, 30));
		registrarse_btnNewButton.setBackground(Color.lightGray);
		registrarse_btnNewButton.setBorder(border);
		registrarse_btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 10));
		GridBagConstraints gbc_resgistrarse_btnNewButton = new GridBagConstraints();
		gbc_resgistrarse_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_resgistrarse_btnNewButton.gridx = 1;
		gbc_resgistrarse_btnNewButton.gridy = 3;
		contentPane.add(registrarse_btnNewButton, gbc_resgistrarse_btnNewButton);
		
		login_btnNewButton = new JButton("LOGIN");
		login_btnNewButton.setPreferredSize(new Dimension(150, 30));
		login_btnNewButton.setBackground(Color.lightGray);
		login_btnNewButton.setBorder(border);
		login_btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 10));
		GridBagConstraints gbc_login_btnNewButton = new GridBagConstraints();
		gbc_login_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_login_btnNewButton.gridx = 2;
		gbc_login_btnNewButton.gridy = 3;
		contentPane.add(login_btnNewButton, gbc_login_btnNewButton);
	}
	
	//Agregar actionListener a los botones
	
	public void agregarListenerLogin(ActionListener listenForLoginButton) {
		login_btnNewButton.addActionListener(listenForLoginButton);
	}
	
	public void agregarListenerIrRegistro(ActionListener listenForIrRegistroButton) {
		registrarse_btnNewButton.addActionListener(listenForIrRegistroButton);
	}
	
	//Getters de los campos de texto
	
	public String getUsuarioIngresada() {
		return usuario_textField.getText();
	}
	
	public String getPassIngresada() {
		return new String(passwordField.getPassword());
	}
	
	class BordeRedondo implements Border {

	    private int radio;  

	    BordeRedondo(int radius) {
	        this.radio = radius;
	    }  

	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radio+1, this.radio+1, this.radio+2, this.radio);
	    }  

	    public boolean isBorderOpaque() {
	        return true;
	    }  

	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        g.drawRoundRect(x, y, width-1, height-1, radio, radio);
	    }

	  }

}