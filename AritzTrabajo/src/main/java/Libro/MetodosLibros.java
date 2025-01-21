package Libro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MetodosLibros {

	public static ArrayList<Libros> recuperarLibrosBD() {
		
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	Session session = factory.openSession();
	
	session.beginTransaction();
	
	List<Libros> listaLibro = session.createQuery("FROM Libros", Libros.class).list();
	
	ArrayList <Libros> librosArray = new ArrayList<>(listaLibro);
	
	return librosArray;
	}
}
