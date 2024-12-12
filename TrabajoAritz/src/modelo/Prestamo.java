package modelo;

public class Prestamo {
    private int ID;
    private int libroId;
    private int usuarioId;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private boolean multaGenerada;

    // Constructor
    public Prestamo(int ID, int libroId, int usuarioId, String fechaPrestamo, String fechaDevolucion, boolean multaGenerada) {
        this.ID = ID;
        this.libroId = libroId;
        this.usuarioId = usuarioId;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.multaGenerada = multaGenerada;
    }

    // Getters y Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getLibroId() {
        return libroId;
    }

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean isMultaGenerada() {
        return multaGenerada;
    }

    public void setMultaGenerada(boolean multaGenerada) {
        this.multaGenerada = multaGenerada;
    }

    // Método toString para representar el objeto como una cadena
    @Override
    public String toString() {
        return "Prestamo{" +
                "ID=" + ID +
                ", libroId=" + libroId +
                ", usuarioId=" + usuarioId +
                ", fechaPrestamo='" + fechaPrestamo + '\'' +
                ", fechaDevolucion='" + fechaDevolucion + '\'' +
                ", multaGenerada=" + multaGenerada +
                '}';
    }
}
