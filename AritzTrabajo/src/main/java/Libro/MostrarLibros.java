package Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MostrarLibros {

    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root";

    public static List<String> obtenerCategorias() {
        List<String> categorias = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             Statement stmt = conn.createStatement()) {

            String query = "SELECT DISTINCT genero FROM libros";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                categorias.add(rs.getString("genero"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorias;
    }

    public static List<Object[]> obtenerLibros(String categoria) {
        List<Object[]> libros = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             Statement stmt = conn.createStatement()) {

            String query = "SELECT id, titulo, genero, disponibilidad, fecha_publicacion FROM libros";
            if (categoria != null && !categoria.equals("Todas las categorías")) {
                query += " WHERE genero = '" + categoria + "'";
            }

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                libros.add(new Object[]{
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("genero"),
                        rs.getString("disponibilidad"),
                        rs.getDate("fecha_publicacion")
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }

    public static boolean eliminarLibro(int id) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM libros WHERE id = ?")) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean actualizarLibro(int id, String titulo, String genero, String disponibilidad, String fechaPublicacion) {
        // Validar que disponibilidad sea 1 o 0
        if (!disponibilidad.equals("1") && !disponibilidad.equals("0")) {
            System.out.println("El valor de disponibilidad debe ser '1' (disponible) o '0' (no disponible).");
            return false;
        }

        // Validar formato de fecha (YYYY-MM-DD)
        if (!fechaPublicacion.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("La fecha de publicación debe tener el formato 'YYYY-MM-DD'.");
            return false;
        }

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement pstmt = conn.prepareStatement(
                     "UPDATE libros SET titulo = ?, genero = ?, disponibilidad = ?, fecha_publicacion = ? WHERE id = ?")) {

            pstmt.setString(1, titulo);
            pstmt.setString(2, genero);
            pstmt.setString(3, disponibilidad);
            pstmt.setString(4, fechaPublicacion); // Incluir la fecha en el parámetro
            pstmt.setInt(5, id);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    

    
}
