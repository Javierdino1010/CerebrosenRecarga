package controlador;

import modelo.Libros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SubirLibros {

    // Datos de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/Biblioteca";
    private static final String USER = "root"; // Cambia según tu configuración
    private static final String PASSWORD = "root"; // Cambia si tienes una contraseña

    // Método principal para ejecutar el menú
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menú de Gestión de Libros ---");
            System.out.println("1. Subir un nuevo libro");
            System.out.println("2. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    subirLibro(scanner);
                    break;
                case 2:
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }

        scanner.close();
    }

    // Método para subir un libro a la base de datos
    private static void subirLibro(Scanner scanner) {
        System.out.print("Introduce el título del libro: ");
        String titulo = scanner.nextLine();

        System.out.print("Introduce el autor del libro: ");
        String autor = scanner.nextLine();

        System.out.print("Introduce el género del libro: ");
        String genero = scanner.nextLine();

        System.out.print("¿Está disponible? (true/false): ");
        boolean disponibilidad = scanner.nextBoolean();
        scanner.nextLine(); // Consumir la nueva línea

        System.out.print("Introduce la fecha de publicación (YYYY-MM-DD): ");
        String fechaPublicacion = scanner.nextLine();

        // Crear un objeto Libros
        Libros libro = new Libros(0, titulo, autor, genero, disponibilidad, fechaPublicacion);

        // Sentencia SQL para insertar un nuevo libro
        String sql = "INSERT INTO libros (titulo, autor, genero, disponibilidad, fecha_publicacion) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, libro.getTitulo());
            pstmt.setString(2, libro.getAutor());
            pstmt.setString(3, libro.getGenero());
            pstmt.setBoolean(4, libro.isDisponibilidad());
            pstmt.setString(5, libro.getFechaPublicacion());

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Libro subido correctamente.");
            } else {
                System.out.println("No se pudo subir el libro.");
            }

        } catch (SQLException e) {
            System.err.println("Error al conectar o insertar en la base de datos: " + e.getMessage());
        }
    }
}
