package Libro;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SubirLibros {
    public static void subirLibro(String titulo, String autor, String genero, boolean disponibilidad, Date fechaPublicacion) {
        // Cargar la configuración de Hibernate y crear una SessionFactory
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Libros.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Crear una nueva sesión y comenzar una transacción
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Crear una nueva instancia de Libro y establecer sus propiedades
            Libros libro = new Libros();
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setGenero(genero);
            libro.setDisponibilidad(disponibilidad);
            libro.setFechaPublicacion(fechaPublicacion);

            // Guardar el libro en la base de datos
            session.save(libro);

            // Confirmar la transacción
            transaction.commit();

            System.out.println("Libro agregado exitosamente.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al insertar el libro: " + e.getMessage());
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}