import java.time.LocalDate;

public class Ticket implements Comparable<Ticket> {

    private static int cantidad = 0;

    private int id;
    private String descripcion;
    private String nombreCompleto;
    private LocalDate fechaCreacion;
    private LocalDate fechaResolucion;

    public Ticket(String descripcion, String nombreCompleto) {
        cantidad++;
        this.id = cantidad;
        this.descripcion = descripcion;
        this.nombreCompleto = nombreCompleto;
        this.fechaCreacion = LocalDate.now();
        this.fechaResolucion = null;
    }

    public int getId() {
        return id;
    }

    public LocalDate getFechaResolucion() {
        return fechaResolucion;
    }

    public void resolver() {
        this.fechaResolucion = LocalDate.now();
    }

    @Override
    public int compareTo(Ticket otro) {
        return this.fechaCreacion.compareTo(otro.fechaCreacion);
    }

    @Override
    public String toString() {
        return "Ticket ID: " + id +
                "\nUsuario: " + nombreCompleto +
                "\nDescripción: " + descripcion +
                "\nFecha creación: " + fechaCreacion +
                "\nFecha resolución: " + fechaResolucion +
                "\n-------------------------";
    }
}