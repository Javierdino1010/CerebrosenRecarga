package Libro;

import SQL.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SubirLibros {

    public static void main(String[] args) {
        conexion db = new conexion();
        Connection conn = db.connectToDB();

        if (conn != null) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese los datos del libro:");

            System.out.print("Título: ");
            String titulo = scanner.nextLine();

            System.out.print("Autor: ");
            String autor = scanner.nextLine();

            System.out.print("Género: ");
            String genero = scanner.nextLine();

            System.out.print("Disponibilidad (true/false): ");
            boolean disponibilidad = scanner.nextBoolean();

            scanner.nextLine(); // Consumir el salto de línea

            System.out.print("Fecha de Publicación (YYYY-MM-DD): ");
            String fechaPublicacion = scanner.nextLine();

            // Llamar al método para subir el libro
            subirLibro(conn, titulo, autor, genero, disponibilidad, fechaPublicacion);

            // Cerrar la conexión
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }

            scanner.close();
        }
    }

    public static void subirLibro(Connection conn, String titulo, String autor, String genero, boolean disponibilidad, String fechaPublicacion) {
        String sql = "INSERT INTO libros (titulo, autor, genero, disponibilidad, fecha_publicacion) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, titulo);
            stmt.setString(2, autor);
            stmt.setString(3, genero);
            stmt.setBoolean(4, disponibilidad);
            stmt.setString(5, fechaPublicacion);

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Libro agregado exitosamente.");
            } else {
                System.out.println("No se pudo agregar el libro.");
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar el libro: " + e.getMessage());
        }
    }
}
