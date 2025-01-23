package Libro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MostrarLibros {

    private static SessionFactory sessionFactory;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    static {
        // Inicializar la SessionFactory
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Libros.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static List<String> obtenerCategorias() {
        List<String> categorias = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT DISTINCT l.genero FROM Libros l";
            Query<String> query = session.createQuery(hql, String.class);
            categorias = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categorias;
    }

    public static List<Object[]> obtenerLibros(String categoria) {
        List<Object[]> libros = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT l.id, l.titulo, l.genero, l.disponibilidad, l.fechaPublicacion FROM Libros l";
            if (categoria != null && !categoria.equals("Todas las categorías")) {
                hql += " WHERE l.genero = :categoria";
            }
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            if (categoria != null && !categoria.equals("Todas las categorías")) {
                query.setParameter("categoria", categoria);
            }
            List<Object[]> results = query.getResultList();
            for (Object[] result : results) {
                // Convertir fechaPublicacion a String
                if (result[4] != null) {
                    result[4] = dateFormat.format((Date) result[4]);
                }
                libros.add(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libros;
    }

    public static boolean eliminarLibro(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Libros libro = session.get(Libros.class, id);
            if (libro != null) {
                session.delete(libro);
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    public static boolean actualizarLibro(int id, String titulo, String genero, String disponibilidad, Date fechaPublicacion) {
        // Validar que disponibilidad sea "true" o "false"
        if (!disponibilidad.equals("true") && !disponibilidad.equals("false")) {
            System.out.println("El valor de disponibilidad debe ser 'true' (disponible) o 'false' (no disponible).");
            return false;
        }

        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Libros libro = session.get(Libros.class, id);
            if (libro != null) {
                libro.setTitulo(titulo);
                libro.setGenero(genero);
                libro.setDisponibilidad(Boolean.parseBoolean(disponibilidad));
                libro.setFechaPublicacion(fechaPublicacion);
                session.update(libro);
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    public static boolean subirLibro(String titulo, String autor, String genero, boolean disponibilidad, Date fechaPublicacion) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Libros libro = new Libros();
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setGenero(genero);
            libro.setDisponibilidad(disponibilidad);
            libro.setFechaPublicacion(fechaPublicacion);
            session.save(libro);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
}