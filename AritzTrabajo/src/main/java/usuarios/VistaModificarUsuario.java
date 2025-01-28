package usuarios;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Libro.LibrosScreen;
import LoginRegister.VistaRegister.BordeRedondo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaModificarUsuario extends JFrame {
	
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
	private JButton btnConfirmar;
	private JLabel lblNewLabel_6;
	private JPasswordField textPass;
	private JButton btnVolver;

	BordeRedondo border = new BordeRedondo(10);

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VistaModificarUsuario frame = new VistaModificarUsuario();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VistaModificarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 564);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 293, 0, 0};
		gbl_contentPane.rowHeights = new int[]{55, 0, 41, 0, 45, 0, 47, 0, 44, 0, 48, 0, 115, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNewLabel_6 = new JLabel("Gestion de usuarios");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.gridwidth = 3;
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
		
		btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        dispose(); // Cierra la ventana actual
		        // Llama al controlador o inicializa la vista de gestión de usuarios
		        VistaGestionUsuarios vistaGestionUsuarios = new VistaGestionUsuarios();
		        new ControladorUsuarios(vistaGestionUsuarios, new VistaModificarUsuario(), new VistaPerfil());
		        vistaGestionUsuarios.setVisible(true);
		    }
		});

		btnVolver.setPreferredSize(new Dimension(150, 30));
		btnVolver.setBackground(Color.lightGray);
		btnVolver.setBorder(border);
		GridBagConstraints gbc_btnVolver = new GridBagConstraints();
		gbc_btnVolver.insets = new Insets(0, 0, 0, 5);
		gbc_btnVolver.gridx = 2;
		gbc_btnVolver.gridy = 12;
		contentPane.add(btnVolver, gbc_btnVolver);
		
		btnConfirmar = new JButton("Confirmar cambios");
		btnConfirmar.setPreferredSize(new Dimension(150, 30));
		btnConfirmar.setBackground(Color.lightGray);
		btnConfirmar.setBorder(border);
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirmar.gridx = 3;
		gbc_btnConfirmar.gridy = 12;
		contentPane.add(btnConfirmar, gbc_btnConfirmar);
	}
	
	//Agregar actionListener a los botones
	
	public void agregarListenerRegister(ActionListener listenForRegisterButton) {
		btnConfirmar.addActionListener(listenForRegisterButton);
	}
	
	public void agregarListenerIrInicio(ActionListener listenForIrInicioButton) {
		btnVolver.addActionListener(listenForIrInicioButton);
	}
	
	//Getters de los campos de texto
	
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

