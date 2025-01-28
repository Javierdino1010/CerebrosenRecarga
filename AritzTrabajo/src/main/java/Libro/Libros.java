package Libro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import modelo.Usuario;

import java.util.Date;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name = "libros")
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private boolean disponibilidad;
    private Date fechaPublicacion;

    // Constructor con parámetros
    public Libros(int id, String titulo, String autor, String genero, boolean disponibilidad, Date fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.disponibilidad = disponibilidad;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Libros() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    // Método para reservar un libro
    public void Reservar(int idLibro) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        Libros libro = session.get(Libros.class, idLibro);
        if (libro.isDisponibilidad() == false) {
            JOptionPane.showMessageDialog(null, "No quedan libros disponibles");
        } else {
            libro.setDisponibilidad(false);
            session.update(libro);
            session.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Libro reservado con éxito.");
            
        }

        session.close();
        factory.close();
    }

    // Método para devolver un libro
    public void devolverLibro(int idLibro) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        Libros libro = session.get(Libros.class, idLibro);
        if (libro.isDisponibilidad() == true) {
            JOptionPane.showMessageDialog(null, "El libro ya está disponible.");
        } else {
            libro.setDisponibilidad(true);
            session.update(libro);
            session.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Libro devuelto con éxito.");
        }

        session.close();
        factory.close();
    }
}