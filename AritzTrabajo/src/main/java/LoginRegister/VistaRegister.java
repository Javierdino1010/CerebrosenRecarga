package LoginRegister;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import LoginRegister.VistaLogin.BordeRedondo;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

public class VistaRegister extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblTitulo;
    private JTextField textNombre;
    private JLabel lblNombre;
    private JTextField textApellidos;
    private JLabel lblApellidos;
    private JTextField textDni;
    private JLabel lblDni;
    private JTextField textEmail;
    private JLabel lblEmail;
    private JLabel lblTelefono;
    private JTextField textTelefono;
    private JButton btnRegistrarse;
    private JLabel lblPass;
    private JPasswordField textPass;
    private JButton btnLogin;

    BordeRedondo border = new BordeRedondo(20);

    public VistaRegister() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 673, 763);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(235, 245, 255)); // Color suave para el fondo
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        setLocationRelativeTo(null);

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 30, 30, 30, 30, 30, 30, 40, 40, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        lblTitulo = new JLabel("Registro de Usuario");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(60, 90, 180)); // Color para el título
        GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
        gbc_lblTitulo.gridwidth = 4;
        gbc_lblTitulo.insets = new Insets(0, 0, 20, 0);
        gbc_lblTitulo.anchor = GridBagConstraints.CENTER;
        gbc_lblTitulo.gridx = 0;
        gbc_lblTitulo.gridy = 0;
        contentPane.add(lblTitulo, gbc_lblTitulo);
        
                lblNombre = new JLabel("Nombre:");
                lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 20));
                GridBagConstraints gbc_lblNombre = new GridBagConstraints();
                gbc_lblNombre.anchor = GridBagConstraints.WEST;
                gbc_lblNombre.insets = new Insets(0, 0, 10, 5);
                gbc_lblNombre.gridx = 0;
                gbc_lblNombre.gridy = 1;
                contentPane.add(lblNombre, gbc_lblNombre);

        textNombre = new JTextField();
        textNombre.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        textNombre.setBackground(Color.WHITE);
        textNombre.setBorder(border);
        GridBagConstraints gbc_textNombre = new GridBagConstraints();
        gbc_textNombre.gridwidth = 3;
        gbc_textNombre.insets = new Insets(0, 0, 10, 0);
        gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_textNombre.gridx = 1;
        gbc_textNombre.gridy = 1;
        contentPane.add(textNombre, gbc_textNombre);
        textNombre.setColumns(10);
        
                lblApellidos = new JLabel("Apellidos:");
                lblApellidos.setFont(new Font("Segoe UI", Font.PLAIN, 20));
                GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
                gbc_lblApellidos.anchor = GridBagConstraints.WEST;
                gbc_lblApellidos.insets = new Insets(0, 0, 10, 5);
                gbc_lblApellidos.gridx = 0;
                gbc_lblApellidos.gridy = 2;
                contentPane.add(lblApellidos, gbc_lblApellidos);

        textApellidos = new JTextField();
        textApellidos.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        textApellidos.setBackground(Color.WHITE);
        textApellidos.setBorder(border);
        GridBagConstraints gbc_textApellidos = new GridBagConstraints();
        gbc_textApellidos.gridwidth = 3;
        gbc_textApellidos.insets = new Insets(0, 0, 10, 0);
        gbc_textApellidos.fill = GridBagConstraints.HORIZONTAL;
        gbc_textApellidos.gridx = 1;
        gbc_textApellidos.gridy = 2;
        contentPane.add(textApellidos, gbc_textApellidos);
        textApellidos.setColumns(10);
        
                lblDni = new JLabel("DNI:");
                lblDni.setFont(new Font("Segoe UI", Font.PLAIN, 20));
                GridBagConstraints gbc_lblDni = new GridBagConstraints();
                gbc_lblDni.anchor = GridBagConstraints.WEST;
                gbc_lblDni.insets = new Insets(0, 0, 10, 5);
                gbc_lblDni.gridx = 0;
                gbc_lblDni.gridy = 3;
                contentPane.add(lblDni, gbc_lblDni);

        textDni = new JTextField();
        textDni.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        textDni.setBackground(Color.WHITE);
        textDni.setBorder(border);
        GridBagConstraints gbc_textDni = new GridBagConstraints();
        gbc_textDni.gridwidth = 3;
        gbc_textDni.insets = new Insets(0, 0, 10, 0);
        gbc_textDni.fill = GridBagConstraints.HORIZONTAL;
        gbc_textDni.gridx = 1;
        gbc_textDni.gridy = 3;
        contentPane.add(textDni, gbc_textDni);
        textDni.setColumns(10);
        
                lblEmail = new JLabel("Email:");
                lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 20));
                GridBagConstraints gbc_lblEmail = new GridBagConstraints();
                gbc_lblEmail.anchor = GridBagConstraints.WEST;
                gbc_lblEmail.insets = new Insets(0, 0, 10, 5);
                gbc_lblEmail.gridx = 0;
                gbc_lblEmail.gridy = 4;
                contentPane.add(lblEmail, gbc_lblEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        textEmail.setBackground(Color.WHITE);
        textEmail.setBorder(border);
        GridBagConstraints gbc_textEmail = new GridBagConstraints();
        gbc_textEmail.gridwidth = 3;
        gbc_textEmail.insets = new Insets(0, 0, 10, 0);
        gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
        gbc_textEmail.gridx = 1;
        gbc_textEmail.gridy = 4;
        contentPane.add(textEmail, gbc_textEmail);
        textEmail.setColumns(10);
        
                lblTelefono = new JLabel("Teléfono:");
                lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 20));
                GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
                gbc_lblTelefono.anchor = GridBagConstraints.WEST;
                gbc_lblTelefono.insets = new Insets(0, 0, 10, 5);
                gbc_lblTelefono.gridx = 0;
                gbc_lblTelefono.gridy = 5;
                contentPane.add(lblTelefono, gbc_lblTelefono);

        textTelefono = new JTextField();
        textTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        textTelefono.setBackground(Color.WHITE);
        textTelefono.setBorder(border);
        GridBagConstraints gbc_textTelefono = new GridBagConstraints();
        gbc_textTelefono.gridwidth = 3;
        gbc_textTelefono.insets = new Insets(0, 0, 10, 0);
        gbc_textTelefono.fill = GridBagConstraints.HORIZONTAL;
        gbc_textTelefono.gridx = 1;
        gbc_textTelefono.gridy = 5;
        contentPane.add(textTelefono, gbc_textTelefono);
        textTelefono.setColumns(10);
        
                lblPass = new JLabel("Contraseña:");
                lblPass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
                GridBagConstraints gbc_lblPass = new GridBagConstraints();
                gbc_lblPass.anchor = GridBagConstraints.WEST;
                gbc_lblPass.insets = new Insets(0, 0, 10, 5);
                gbc_lblPass.gridx = 0;
                gbc_lblPass.gridy = 6;
                contentPane.add(lblPass, gbc_lblPass);

        textPass = new JPasswordField();
        textPass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        textPass.setBackground(Color.WHITE);
        textPass.setBorder(border);
        GridBagConstraints gbc_textPass = new GridBagConstraints();
        gbc_textPass.gridwidth = 3;
        gbc_textPass.insets = new Insets(0, 0, 10, 0);
        gbc_textPass.fill = GridBagConstraints.HORIZONTAL;
        gbc_textPass.gridx = 1;
        gbc_textPass.gridy = 6;
        contentPane.add(textPass, gbc_textPass);
        
                btnLogin = new JButton("Iniciar sesión");
                btnLogin.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                	}
                });
                btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 20));
                btnLogin.setBackground(new Color(60, 90, 180));
                btnLogin.setForeground(Color.WHITE);
                btnLogin.setBorder(border);
                GridBagConstraints gbc_btnLogin = new GridBagConstraints();
                gbc_btnLogin.insets = new Insets(0, 0, 10, 5);
                gbc_btnLogin.gridx = 0;
                gbc_btnLogin.gridy = 10;
                contentPane.add(btnLogin, gbc_btnLogin);
                
                        btnRegistrarse = new JButton("Registrarse");
                        btnRegistrarse.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        	}
                        });
                        btnRegistrarse.setFont(new Font("Segoe UI", Font.PLAIN, 20));
                        btnRegistrarse.setBackground(new Color(60, 90, 180));
                        btnRegistrarse.setForeground(Color.WHITE);
                        btnRegistrarse.setBorder(border);
                        GridBagConstraints gbc_btnRegistrarse = new GridBagConstraints();
                        gbc_btnRegistrarse.insets = new Insets(0, 0, 10, 5);
                        gbc_btnRegistrarse.gridx = 2;
                        gbc_btnRegistrarse.gridy = 10;
                        contentPane.add(btnRegistrarse, gbc_btnRegistrarse);
    }

    // Métodos para agregar listeners a los botones y obtener los datos
    public void agregarListenerRegister(ActionListener listenForRegisterButton) {
        btnRegistrarse.addActionListener(listenForRegisterButton);
    }

    public void agregarListenerIrInicio(ActionListener listenForIrInicioButton) {
        btnLogin.addActionListener(listenForIrInicioButton);
    }

    // Getters de los campos de texto
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

    // Borde redondeado para los campos de texto y botones
    public class BordeRedondo implements Border {
        private int radio;
        BordeRedondo(int radius) {
            this.radio = radius;
        }
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radio + 1, this.radio + 1, this.radio + 2, this.radio);
        }
        public boolean isBorderOpaque() {
            return true;
        }
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radio, radio);
        }
    }
}
