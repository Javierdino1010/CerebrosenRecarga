package LoginRegister;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.border.Border;

public class VistaLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usuario_textField;
    private JPasswordField passwordField;
    private JButton login_btnNewButton;
    private JButton registrarse_btnNewButton;

    BordeRedondo border = new BordeRedondo(20);

    public VistaLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 869, 564);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(250, 250, 255)); // Color más suave
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
        usuario_lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22)); // Fuente más moderna
        GridBagConstraints gbc_usuario_lblNewLabel = new GridBagConstraints();
        gbc_usuario_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_usuario_lblNewLabel.gridx = 1;
        gbc_usuario_lblNewLabel.gridy = 1;
        contentPane.add(usuario_lblNewLabel, gbc_usuario_lblNewLabel);

        usuario_textField = new JTextField();
        usuario_textField.setFont(new Font("Segoe UI", Font.PLAIN, 20)); // Fuente más moderna
        usuario_textField.setToolTipText("Inserte el usuario");
        GridBagConstraints gbc_usuario_textField = new GridBagConstraints();
        gbc_usuario_textField.insets = new Insets(0, 0, 5, 5);
        gbc_usuario_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_usuario_textField.gridx = 2;
        gbc_usuario_textField.gridy = 1;
        contentPane.add(usuario_textField, gbc_usuario_textField);
        usuario_textField.setColumns(10);

        JLabel contraseña_lblNewLabel = new JLabel("CONTRASEÑA:");
        contraseña_lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22)); // Fuente más moderna
        GridBagConstraints gbc_contraseña_lblNewLabel = new GridBagConstraints();
        gbc_contraseña_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_contraseña_lblNewLabel.gridx = 1;
        gbc_contraseña_lblNewLabel.gridy = 2;
        contentPane.add(contraseña_lblNewLabel, gbc_contraseña_lblNewLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 20)); // Fuente más moderna
        passwordField.setToolTipText("Inserte la contraseña");
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.insets = new Insets(0, 0, 5, 5);
        gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField.gridx = 2;
        gbc_passwordField.gridy = 2;
        contentPane.add(passwordField, gbc_passwordField);

        // Botón de registrarse
        registrarse_btnNewButton = new JButton("REGISTRARSE");
        registrarse_btnNewButton.setPreferredSize(new Dimension(200, 50)); // Botón más grande
        registrarse_btnNewButton.setBackground(new Color(0, 122, 204)); // Color llamativo
        registrarse_btnNewButton.setForeground(Color.WHITE);
        registrarse_btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 18)); // Fuente moderna
        registrarse_btnNewButton.setBorder(border);
        GridBagConstraints gbc_resgistrarse_btnNewButton = new GridBagConstraints();
        gbc_resgistrarse_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_resgistrarse_btnNewButton.gridx = 1;
        gbc_resgistrarse_btnNewButton.gridy = 3;
        contentPane.add(registrarse_btnNewButton, gbc_resgistrarse_btnNewButton);

        // Botón de login
        login_btnNewButton = new JButton("LOGIN");
        login_btnNewButton.setPreferredSize(new Dimension(200, 50)); // Botón más grande
        login_btnNewButton.setBackground(new Color(0, 122, 204)); // Color llamativo
        login_btnNewButton.setForeground(Color.WHITE);
        login_btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 18)); // Fuente moderna
        login_btnNewButton.setBorder(border);
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

    // Clase para borde redondeado
    class BordeRedondo implements Border {

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
