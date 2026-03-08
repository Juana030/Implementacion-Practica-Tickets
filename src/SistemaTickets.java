import java.util.PriorityQueue;

public class SistemaTickets {

    private PriorityQueue<Ticket> colaTickets;
    private NodoTicket listaResueltos;

    public SistemaTickets() {
        colaTickets = new PriorityQueue<>();
        listaResueltos = null;
    }

    public void crearTicket(String descripcion, String nombre) {
        Ticket nuevo = new Ticket(descripcion, nombre);
        colaTickets.add(nuevo);
        System.out.println("Ticket creado con ID: " + nuevo.getId());
    }

    public void verTicketPendiente() {
        if (colaTickets.isEmpty()) {
            System.out.println("No hay tickets pendientes.");
        } else {
            System.out.println("Ticket al frente:");
            System.out.println(colaTickets.peek());
        }
    }

    public void resolverTicket() {

        if (colaTickets.isEmpty()) {
            System.out.println("No hay tickets para resolver.");
            return;
        }

        Ticket resuelto = colaTickets.poll();
        resuelto.resolver();

        NodoTicket nuevoNodo = new NodoTicket(resuelto);

        if (listaResueltos == null) {
            listaResueltos = nuevoNodo;
        } else {
            NodoTicket actual = listaResueltos;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }

        System.out.println("Ticket resuelto:");
        System.out.println(resuelto);
    }

    public void buscarTicketResuelto(int id) {

        NodoTicket actual = listaResueltos;

        while (actual != null) {

            if (actual.ticket.getId() == id) {
                System.out.println("Ticket encontrado: ");
                System.out.println(actual.ticket);
                return;
            }
            actual = actual.siguiente;
        }

        System.out.println("El ticket está pendiente o no existe.");
    }
}