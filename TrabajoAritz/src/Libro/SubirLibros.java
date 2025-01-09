package Libro;

import SQL.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubirLibros {
    public static void subirLibro(String titulo, String autor, String genero, boolean disponibilidad, String fechaPublicacion) {
        conexion db = new conexion();
        Connection conn = db.connectToDB();

        if (conn != null) {
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
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }
}
