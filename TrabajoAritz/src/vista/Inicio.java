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

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

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

		JButton btn_Administrador = new JButton("ADMINISTRADOR");

		JLabel lblNewLabel = new JLabel("SELECCIONA EL TIPO DE USUARIO");

		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();

		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);

		gbc_lblNewLabel.gridx = 1;

		gbc_lblNewLabel.gridy = 0;

		p.add(lblNewLabel, gbc_lblNewLabel);

		GridBagConstraints gbc_btn_Administrador = new GridBagConstraints();

		gbc_btn_Administrador.anchor = GridBagConstraints.EAST;

		gbc_btn_Administrador.insets = new Insets(0, 0, 5, 5);

		gbc_btn_Administrador.gridx = 0;

		gbc_btn_Administrador.gridy = 1;

		p.add(btn_Administrador, gbc_btn_Administrador);

		JButton btn_Usuario = new JButton("USUARIO");

		GridBagConstraints gbc_btn_Usuario = new GridBagConstraints();

		gbc_btn_Usuario.anchor = GridBagConstraints.WEST;

		gbc_btn_Usuario.insets = new Insets(0, 0, 5, 0);

		gbc_btn_Usuario.gridx = 2;

		gbc_btn_Usuario.gridy = 1;

		p.add(btn_Usuario, gbc_btn_Usuario);

	}

}