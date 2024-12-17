package vista;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;



import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.GridBagLayout;

import java.awt.GridBagConstraints;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import java.awt.Insets;

import javax.swing.JLabel;
import java.awt.Font;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton btnInicio;

	public Inicio() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 816, 588);

		PanelImagen p = new PanelImagen();

		p.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(p);

		GridBagLayout gbl_p = new GridBagLayout();

		gbl_p.columnWidths = new int[] { 0, 0, 0, 0 };

		gbl_p.rowHeights = new int[] { 0, 0, 0, 0 };

		gbl_p.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };

		gbl_p.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };

		p.setLayout(gbl_p);

		JLabel lblNewLabel = new JLabel("BIENVENIDO");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 30));

		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();

		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);

		gbc_lblNewLabel.gridx = 1;

		gbc_lblNewLabel.gridy = 0;

		p.add(lblNewLabel, gbc_lblNewLabel);
		
				 btnInicio = new JButton("COMENZAR");
				
				
				btnInicio.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 20));
				
						GridBagConstraints gbc_btnInicio = new GridBagConstraints();
								
										gbc_btnInicio.insets = new Insets(0, 0, 5, 5);
										
												gbc_btnInicio.gridx = 1;
												
														gbc_btnInicio.gridy = 1;
														
																p.add(btnInicio, gbc_btnInicio);
																
																

	}

	

	public void agregarListenerInicio(ActionListener listenForInicioButton) {
		btnInicio.addActionListener(listenForInicioButton);
		
	}

}