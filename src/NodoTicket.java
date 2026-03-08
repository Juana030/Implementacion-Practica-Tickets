public class NodoTicket {
    Ticket ticket;
    NodoTicket siguiente;


    public NodoTicket(Ticket ticket) {
        this.ticket = ticket;
        this.siguiente = null;
    }
}
