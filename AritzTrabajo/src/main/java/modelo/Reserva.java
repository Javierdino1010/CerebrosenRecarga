package modelo;

public class Reserva {
    private int ID;
    private int libroId;
    private int usuarioId;
    private String fechaReserva;
    private String estado;

    // Constructor
    public Reserva(int ID, int libroId, int usuarioId, String fechaReserva, String estado) {
        this.ID = ID;
        this.libroId = libroId;
        this.usuarioId = usuarioId;
        this.fechaReserva = fechaReserva;
        this.estado = estado;
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

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método toString para representar el objeto como una cadena
    @Override
    public String toString() {
        return "Reserva{" +
                "ID=" + ID +
                ", libroId=" + libroId +
                ", usuarioId=" + usuarioId +
                ", fechaReserva='" + fechaReserva + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}

