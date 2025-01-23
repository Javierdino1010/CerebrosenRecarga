package Libro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.*;

public class InsertarLibro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField genero;
    private JTextField autor;
    private JTextField libro;
    private JTextField anio;
    private JTextField mes;
    private JTextField dia;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    

    public InsertarLibro() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 500);
        setTitle("Insertar Libro");
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(new Color(240, 248, 255));
        setContentPane(contentPane);
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton volver = new JButton("<-- Volver");
        volver.setBackground(new Color(173, 216, 230));
        volver.setForeground(Color.BLACK);
        volver.setFocusPainted(false);
        volver.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        contentPane.add(volver, gbc);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LibrosScreen.main(null);
            }
        });

        JLabel lblLibro = new JLabel("Título del libro:");
        lblLibro.setFont(new Font("Arial", Font.BOLD, 16));
        lblLibro.setForeground(new Color(70, 130, 180));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        contentPane.add(lblLibro, gbc);

        libro = new JTextField();
        libro.setFont(new Font("Arial", Font.PLAIN, 16));
        libro.setColumns(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        contentPane.add(libro, gbc);

        JLabel lblAutor = new JLabel("Autor:");
        lblAutor.setFont(new Font("Arial", Font.BOLD, 16));
        lblAutor.setForeground(new Color(70, 130, 180));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        contentPane.add(lblAutor, gbc);

        autor = new JTextField();
        autor.setFont(new Font("Arial", Font.PLAIN, 16));
        autor.setColumns(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        contentPane.add(autor, gbc);

        JLabel lblGenero = new JLabel("Género:");
        lblGenero.setFont(new Font("Arial", Font.BOLD, 16));
        lblGenero.setForeground(new Color(70, 130, 180));
        gbc.gridx = 0;
        gbc.gridy = 3;
        contentPane.add(lblGenero, gbc);

        genero = new JTextField();
        genero.setFont(new Font("Arial", Font.PLAIN, 16));
        genero.setColumns(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        contentPane.add(genero, gbc);

        JLabel lblFechaPublicacion = new JLabel("Fecha de publicación:");
        lblFechaPublicacion.setFont(new Font("Arial", Font.BOLD, 16));
        lblFechaPublicacion.setForeground(new Color(70, 130, 180));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        contentPane.add(lblFechaPublicacion, gbc);

        JPanel fechaPanel = new JPanel(new GridLayout(2, 3, 10, 5));
        fechaPanel.setBackground(contentPane.getBackground());

        JLabel lblAnio = new JLabel("Año:");
        lblAnio.setFont(new Font("Arial", Font.BOLD, 14));
        lblAnio.setHorizontalAlignment(SwingConstants.CENTER);
        fechaPanel.add(lblAnio);

        JLabel lblMes = new JLabel("Mes:");
        lblMes.setFont(new Font("Arial", Font.BOLD, 14));
        lblMes.setHorizontalAlignment(SwingConstants.CENTER);
        fechaPanel.add(lblMes);

        JLabel lblDia = new JLabel("Día:");
        lblDia.setFont(new Font("Arial", Font.BOLD, 14));
        lblDia.setHorizontalAlignment(SwingConstants.CENTER);
        fechaPanel.add(lblDia);

        anio = new JTextField();
        anio.setFont(new Font("Arial", Font.PLAIN, 16));
        anio.setColumns(4);
        fechaPanel.add(anio);

        mes = new JTextField();
        mes.setFont(new Font("Arial", Font.PLAIN, 16));
        mes.setColumns(2);
        fechaPanel.add(mes);

        dia = new JTextField();
        dia.setFont(new Font("Arial", Font.PLAIN, 16));
        dia.setColumns(2);
        fechaPanel.add(dia);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 4;
        contentPane.add(fechaPanel, gbc);

        JButton enviarLibro = new JButton("Subir Libro");
        enviarLibro.setBackground(new Color(60, 179, 113));
        enviarLibro.setForeground(Color.WHITE);
        enviarLibro.setFocusPainted(false);
        enviarLibro.setFont(new Font("Arial", Font.BOLD, 16));
        enviarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = libro.getText();
                String autorText = autor.getText();
                String generoText = genero.getText();
                String fechaStr = anio.getText() + "-" + mes.getText() + "-" + dia.getText();

                if (validarFecha(fechaStr)) {
                    // Convertir la fecha a Date
                    Date fechaPublicacion = null;
                    try {
                        fechaPublicacion = dateFormat.parse(fechaStr);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(contentPane, "La fecha ingresada no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    SubirLibros.subirLibro(titulo, autorText, generoText, true, fechaPublicacion);
                    JOptionPane.showMessageDialog(contentPane, "Libro subido correctamente.");
                } else {
                    JOptionPane.showMessageDialog(contentPane, "La fecha ingresada no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 4;
        contentPane.add(enviarLibro, gbc);
    }

    private boolean validarFecha(String fecha) {
        try {
            LocalDate.parse(fecha);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}